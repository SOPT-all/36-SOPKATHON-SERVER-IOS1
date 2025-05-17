package sopt36.sopkathon.server_ios1.repository.profile;

import sopt36.sopkathon.server_ios1.domain.profile.Profile;

import java.util.Optional;

public interface CustomProfileRepository {
    Optional<Profile> findRandomRecommendedProfile(Profile currentProfile);
}

