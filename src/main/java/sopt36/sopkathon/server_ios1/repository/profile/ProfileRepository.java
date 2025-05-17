package sopt36.sopkathon.server_ios1.repository.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {


}
