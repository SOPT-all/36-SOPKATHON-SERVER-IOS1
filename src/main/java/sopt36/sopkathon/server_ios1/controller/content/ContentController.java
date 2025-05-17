package sopt36.sopkathon.server_ios1.controller.content;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt36.sopkathon.server_ios1.dto.content.response.ContentListResponse;
import sopt36.sopkathon.server_ios1.dto.global.ResponseDto;
import sopt36.sopkathon.server_ios1.service.content.ContentService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping("/contents")
    public ResponseDto<ContentListResponse> getContents(
            @RequestHeader("profile_id") Long profileId,
            @RequestParam("hobby") String hobby
    ) {
        return ResponseDto.success("콘텐츠 조회에 성공했습니다.", contentService.getContents(profileId, hobby));
    }
}
