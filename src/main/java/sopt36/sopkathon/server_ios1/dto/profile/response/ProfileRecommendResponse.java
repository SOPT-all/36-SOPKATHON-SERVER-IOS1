package sopt36.sopkathon.server_ios1.dto.profile.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import sopt36.sopkathon.server_ios1.domain.profile.Area;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;
import sopt36.sopkathon.server_ios1.util.DistanceCalculator;

public record ProfileRecommendResponse(
        @JsonProperty("profile_id")
        long profileId,
        @JsonProperty("profile_image")
        String profileImage,
        String nickname,
        String area,
        float distance,
        int age,
        String hobby,
        String description
) {
        public static ProfileRecommendResponse of(Profile recommended, float currentLat, float currentLon){
                Area recommendArea = recommended.getArea();
                float distance = DistanceCalculator.calculateDistance(currentLat, currentLon, recommendArea.getLat(), recommendArea.getLon());
                float roundedDistance = Math.round(distance * 10f) / 10f;
                return new ProfileRecommendResponse(
                        recommended.getId(),
                        recommended.getProfileImage(),
                        recommended.getNickname(),
                        recommended.getArea().getName(),
                        roundedDistance,
                        recommended.getAge(),
                        recommended.getHobby().getText(),
                        recommended.getDescription()
                );
        }
}
