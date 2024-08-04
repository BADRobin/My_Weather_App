package com.oleh.myweatherapp.network;


import static com.oleh.myweatherapp.network.APIConstance.*;


public enum WeatherIconCode {

    CLEAR(ClearCode),
    CLEAR_NIGHT(ClearNightCode),

    FEW_CLOUDS(Few_cloudsCode),
    FEW_CLOUDS_NIGHT(Few_cloudsNightCode),

    SCATTERED_CLOUDS(Scattered_cloudsCode),
    SCATTERED_CLOUDS_NIGHT(Scattered_cloudsNightCode),

    OVERCAST_CLOUDS(Overcast_cloudsCode),
    OVERCAST_CLOUDS_NIGHT(Overcast_cloudsNightCode),

    DRIZZLE(DrizzleCode),
    DRIZZLE_NIGHT(DrizzleNightCode),

    RAIN(RainCode),
    RAIN_NIGHT(RainNightCode),

    SNOW(SnowCode),
    SNOW_NIGHT(SnowNightCode),

    SMOKE(SmokeCode),
    SMOKE_NIGHT(SmokeNightCode),

    UNKNOWN(null) ;


    String iconCode;

    WeatherIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public static WeatherIconCode fromString(String iconCode){
        switch (iconCode){
            case ClearCode : return CLEAR;
            case ClearNightCode: return CLEAR_NIGHT;

            case Few_cloudsCode : return FEW_CLOUDS;
            case Few_cloudsNightCode: return FEW_CLOUDS_NIGHT;

            case Scattered_cloudsCode : return SCATTERED_CLOUDS;
            case Scattered_cloudsNightCode: return SCATTERED_CLOUDS_NIGHT;

            case Overcast_cloudsCode : return OVERCAST_CLOUDS;
            case Overcast_cloudsNightCode: return OVERCAST_CLOUDS_NIGHT;

            case DrizzleCode : return DRIZZLE;
            case DrizzleNightCode: return DRIZZLE_NIGHT;

            case RainCode : return RAIN;
            case RainNightCode: return RAIN_NIGHT;

            case SnowCode : return SNOW;
            case SnowNightCode: return SNOW_NIGHT;

            case SmokeCode : return SMOKE;
            case SmokeNightCode: return SMOKE_NIGHT;
        }

        return UNKNOWN;
    }
    

}
