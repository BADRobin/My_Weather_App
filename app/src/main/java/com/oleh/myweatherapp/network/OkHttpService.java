package com.oleh.myweatherapp.network;

import java.io.IOException;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpService implements NetworkService {


    @Override
    public NetworkResponse getResponse(String url) {
        return getResponse(url, null);
    }

    @Override
    public NetworkResponse getResponse(String url, Map<String, String> queryParameters) {
        return getResponse(url, queryParameters, null);
    }

    @Override
    public NetworkResponse getResponse(String url, Map<String, String> queryParameters, Map<String, String> headers) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(url).newBuilder();

        if (queryParameters != null) {
            for (String parameter : queryParameters.keySet()) {
                httpUrlBuilder.addQueryParameter(
                        parameter,
                        queryParameters.get(parameter)
                );
            }
        }

        HttpUrl httpUrl = httpUrlBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(httpUrl);
        if (headers != null) {
            for (String headerName : headers.keySet()) {
                requestBuilder.addHeader(
                        headerName,
                        headers.get(headerName)
                );
            }
        }
        Request request = requestBuilder.build();

        Response response = null;
        try {
            response = client.newCall(request).execute();

            return new NetworkResponse(
                    response.code(),
                    response.body().string()
            );

        } catch (IOException e) {
            throw new NetworkException(e.getMessage());
        }
    }
}