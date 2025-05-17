package sopt36.sopkathon.server_ios1.service.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;
import sopt36.sopkathon.server_ios1.dto.profile.response.ProfileRecommendResponse;
import sopt36.sopkathon.server_ios1.exception.profile.ProfileErrorCode;
import sopt36.sopkathon.server_ios1.exception.profile.ProfileException;
import sopt36.sopkathon.server_ios1.repository.profile.ProfileRepository;

@Service
@RequiredArgsConstructor
public class ProfileRecommendService {

    private final ProfileRepository profileRepository;

    public ProfileRecommendResponse recommend(long profileId) {
        Profile currentProfile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileException(ProfileErrorCode.NOT_FOUND_PROFILE));

        Profile recommended = profileRepository.findRandomRecommendedProfile(currentProfile)
                .orElseThrow(() -> new RuntimeException("추천 가능한 프로필이 없습니다."));

        return ProfileRecommendResponse.of(recommended, currentProfile.getArea().getLat(), currentProfile.getArea().getLon());
    }
}
