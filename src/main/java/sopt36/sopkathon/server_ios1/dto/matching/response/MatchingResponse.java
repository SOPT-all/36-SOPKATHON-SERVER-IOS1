package sopt36.sopkathon.server_ios1.dto.matching.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record MatchingResponse (
        @JsonProperty("matching_id")
        Long matchingId,

        @JsonProperty("phone_number")
        String phoneNumber
) {
    public static MatchingResponse of(Long matchingId, String phoneNumber) {
        return MatchingResponse.builder()
                .matchingId(matchingId)
                .phoneNumber(phoneNumber)
                .build();
    }
}
