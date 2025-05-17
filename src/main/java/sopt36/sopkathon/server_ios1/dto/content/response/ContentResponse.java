package sopt36.sopkathon.server_ios1.dto.content.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import sopt36.sopkathon.server_ios1.domain.content.Content;

@Builder
public record ContentResponse(
        @JsonProperty("content_id")
        Long contentId,
        String image,
        String location,
        String description
) {
    public static ContentResponse from(Content content) {
        return ContentResponse.builder()
                .contentId(content.getId())
                .image(content.getImage())
                .location(content.getLocation())
                .description(content.getDescription())
                .build();
    }
}
