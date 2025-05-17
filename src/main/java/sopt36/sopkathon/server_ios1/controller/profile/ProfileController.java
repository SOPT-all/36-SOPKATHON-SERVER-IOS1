package sopt36.sopkathon.server_ios1.controller.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt36.sopkathon.server_ios1.dto.global.ResponseDto;
import sopt36.sopkathon.server_ios1.dto.profile.request.ProfileCreateRequest;
import sopt36.sopkathon.server_ios1.dto.profile.response.ProfileCreateResponse;
import sopt36.sopkathon.server_ios1.service.profile.ProfileService;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseDto<ProfileCreateResponse> saveProfile(@RequestBody ProfileCreateRequest request){
        ProfileCreateResponse response = profileService.saveProfile(request);
        return ResponseDto.created("프로필 등록에 성공했습니다.", response);
    }
}
