package sopt36.sopkathon.server_ios1.util;

public class DistanceCalculator {

    private static final float EARTH_RADIUS_KM = 6371.0f;

    public static float calculateDistance(float lat1, float lon1, float lat2, float lon2) {
        float dLat = toRadians(lat2 - lat1);
        float dLon = toRadians(lon2 - lon1);

        float radLat1 = toRadians(lat1);
        float radLat2 = toRadians(lat2);

        float a = (float)(Math.sin(dLat / 2f) * Math.sin(dLat / 2f)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.sin(dLon / 2f) * Math.sin(dLon / 2f));

        float c = 2f * (float)Math.atan2(Math.sqrt(a), Math.sqrt(1f - a));
        return EARTH_RADIUS_KM * c;
    }

    private static float toRadians(float degrees) {
        return degrees * (float)Math.PI / 180f;
    }
}
