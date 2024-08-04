package com.oleh.myweatherapp.pexelImage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oleh.myweatherapp.network.NetworkResponse;
import com.oleh.myweatherapp.network.NetworkService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PexelImageImpl implements PexelImageService {
    private final static String APP_ID = "VcVEvxy7V62yi9PAr8Xw9MbN133BcFXQ7YBEHfe2cAB3HJVA5xv7rHjx";
    private final NetworkService networkService;

    public PexelImageImpl(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public List<PexelImage> getImagesForQuery(String query) {
        Map<String, String> params = new HashMap<>();
        params.put("query", query);


        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", APP_ID);

        NetworkResponse response = networkService.getResponse("https://api.pexels.com/v1/search", params, headers);
        String body = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(body);

            List<PexelImage> images = new ArrayList<>();
            for (JsonNode node : rootNode.get("photos")) {
                PexelImage image = new PexelImage(
                        node.get("photographer").asText(),
                        node.get("src").get("portrait").asText()
                );
                images.add(image);
            }
            return images;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
//        return Collections.emptyList();
    }

    @Override
    public PexelImage getRandomImagesForQuery(String query) {
        List<PexelImage> images = getImagesForQuery(query);
        if (!images.isEmpty()) {
            Random random = new Random();
            int position = random.nextInt(images.size());
            return images.get(position);
        }
        return null;
    }
}
