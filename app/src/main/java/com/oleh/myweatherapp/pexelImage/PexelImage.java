package com.oleh.myweatherapp.pexelImage;

import java.util.Objects;

public class PexelImage {
    private final String photographer;
    private final String portraitURL;

    public PexelImage(String photographer, String portraitURL) {
        this.photographer = photographer;
        this.portraitURL = portraitURL;
    }

    public String getPhotographer() {
        return photographer;
    }

    public String getPortraitURL() {
        return portraitURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PexelImage that = (PexelImage) o;
        return Objects.equals(photographer, that.photographer) && Objects.equals(portraitURL, that.portraitURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photographer, portraitURL);
    }

    @Override
    public String toString() {
        return "PexelImage{" +
                "photographer='" + photographer + '\'' +
                ", portraitURL='" + portraitURL + '\'' +
                '}';
    }
}
