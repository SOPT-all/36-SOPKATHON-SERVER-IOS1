package sopt36.sopkathon.server_ios1.controller.matching;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt36.sopkathon.server_ios1.dto.global.ResponseDto;
import sopt36.sopkathon.server_ios1.dto.matching.response.MatchingResponse;
import sopt36.sopkathon.server_ios1.service.MatchingService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;

    @PostMapping("/matching/{other_id}")
    public ResponseDto<MatchingResponse> createMatching(@RequestHeader("profile_id") Long profileId, @PathVariable("other_id") Long otherId){
        return ResponseDto.created("매칭에 성공했습니다.", matchingService.createMatching(profileId, otherId));
    }
}
