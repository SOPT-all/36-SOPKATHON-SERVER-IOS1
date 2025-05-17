package sopt36.sopkathon.server_ios1.dto.content.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record ContentListResponse(
        @JsonProperty("contents")
        List<ContentResponse> contentResponseList
) {
    public static ContentListResponse from(List<ContentResponse> contentResponseList) {
        return ContentListResponse.builder()
                .contentResponseList(contentResponseList)
                .build();
    }
}
