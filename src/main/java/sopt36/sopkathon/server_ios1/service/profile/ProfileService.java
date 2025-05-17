package sopt36.sopkathon.server_ios1.service.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt36.sopkathon.server_ios1.domain.enums.Hobby;
import sopt36.sopkathon.server_ios1.domain.profile.Area;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;
import sopt36.sopkathon.server_ios1.dto.profile.request.ProfileCreateRequest;
import sopt36.sopkathon.server_ios1.dto.profile.response.ProfileCreateResponse;
import sopt36.sopkathon.server_ios1.exception.area.AreaErrorCode;
import sopt36.sopkathon.server_ios1.exception.area.AreaException;
import sopt36.sopkathon.server_ios1.repository.profile.AreaRepository;
import sopt36.sopkathon.server_ios1.repository.profile.ProfileRepository;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final AreaRepository areaRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    public ProfileCreateResponse saveProfile(ProfileCreateRequest request){
        Area area = areaRepository.findById(request.areaId()).orElseThrow(() -> new AreaException(AreaErrorCode.NOT_FOUND_AREA_EXCEPTION));

        Hobby hobby = Hobby.fromText(request.hobby());
        Profile profile = Profile.builder()
                .profileImage(request.profileImage())
                .nickname(request.nickname())
                .description(request.description())
                .age(request.age())
                .phoneNumber(request.phoneNumber())
                .gender(request.gender())
                .hobby(hobby)
                .sameGenderOnly(request.sameGenderOnly())
                .profileOpen(request.profileOpen())
                .area(area)
                .build();

        Profile savedProfile = profileRepository.save(profile);

        return new ProfileCreateResponse(savedProfile.getId());
    }
}
