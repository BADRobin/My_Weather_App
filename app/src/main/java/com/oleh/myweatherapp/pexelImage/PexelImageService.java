package com.oleh.myweatherapp.pexelImage;

import java.util.List;

public interface PexelImageService {
    List<PexelImage> getImagesForQuery(String query);
    PexelImage getRandomImagesForQuery(String query);
}
