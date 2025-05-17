package sopt36.sopkathon.server_ios1.dto.profile.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import sopt36.sopkathon.server_ios1.domain.enums.Gender;

public record ProfileCreateRequest(
        String nickname,
        @JsonProperty("profile_image")
        String profileImage,
        String description,
        Integer age,
        @JsonProperty("phone_number")
        String phoneNumber,
        Gender gender,
        @JsonProperty("area_id")
        Long areaId,
        String hobby,
        @JsonProperty("same_gender_only")
        Boolean sameGenderOnly,
        @JsonProperty("profile_open")
        Boolean profileOpen
) {
}
