package sopt36.sopkathon.server_ios1.controller.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt36.sopkathon.server_ios1.dto.global.ResponseDto;
import sopt36.sopkathon.server_ios1.dto.profile.request.ProfileCreateRequest;
import sopt36.sopkathon.server_ios1.dto.profile.response.ProfileCreateResponse;
import sopt36.sopkathon.server_ios1.dto.profile.response.ProfileRecommendResponse;
import sopt36.sopkathon.server_ios1.service.profile.ProfileRecommendService;
import sopt36.sopkathon.server_ios1.service.profile.ProfileService;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileRecommendService profileRecommendService;

    @PostMapping
    public ResponseDto<ProfileCreateResponse> saveProfile(@RequestBody ProfileCreateRequest request){
        ProfileCreateResponse response = profileService.saveProfile(request);
        return ResponseDto.created("프로필 등록에 성공했습니다.", response);
    }

    @GetMapping("/recommend")
    public ResponseDto<ProfileRecommendResponse> getRecommendProfile(@RequestHeader("profile_id") long profileId){
        ProfileRecommendResponse response = profileRecommendService.recommend(profileId);
        return ResponseDto.success("취미 맞는 친구 랜덤 추천에 성공했습니다.", response);
    }
}
