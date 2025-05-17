package sopt36.sopkathon.server_ios1.dto.matching.response;

import lombok.Builder;

@Builder
public record MatchingResponse (
        Long matchingId,
        String phoneNumber
) {
    public static MatchingResponse of(Long matchingId, String phoneNumber) {
        return MatchingResponse.builder()
                .matchingId(matchingId)
                .phoneNumber(phoneNumber)
                .build();
    }
}
