package sopt36.sopkathon.server_ios1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt36.sopkathon.server_ios1.domain.matching.Matching;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;
import sopt36.sopkathon.server_ios1.dto.matching.response.MatchingResponse;
import sopt36.sopkathon.server_ios1.exception.matching.MatchingErrorCode;
import sopt36.sopkathon.server_ios1.exception.matching.MatchingException;
import sopt36.sopkathon.server_ios1.repository.matching.MatchingRepository;
import sopt36.sopkathon.server_ios1.repository.profile.ProfileRepository;

@Service
@RequiredArgsConstructor
public class MatchingService {
    private final ProfileRepository profileRepository;
    private final MatchingRepository matchingRepository;

    @Transactional
    public MatchingResponse createMatching(Long profileId, Long otherId) {
        Profile currentProfile = profileRepository.findById(profileId)
                .orElseThrow(() -> new MatchingException(MatchingErrorCode.NOT_FOUND_MATCHING_USER));
        Profile otherProfile = profileRepository.findById(otherId)
                .orElseThrow(() -> new MatchingException(MatchingErrorCode.NOT_FOUND_MATCHING_USER));

        Matching matching = Matching.builder()
                .profile1(currentProfile)
                .profile2(otherProfile)
                .build();

        matchingRepository.save(matching);

        return MatchingResponse.builder()
                .matchingId(matching.getId())
                .phoneNumber(otherProfile.getPhoneNumber())
                .build();
    }
}
