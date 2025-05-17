package sopt36.sopkathon.server_ios1.dto.profile.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProfileCreateResponse(
        @JsonProperty("profile_id")
        long profileId
) {
}
