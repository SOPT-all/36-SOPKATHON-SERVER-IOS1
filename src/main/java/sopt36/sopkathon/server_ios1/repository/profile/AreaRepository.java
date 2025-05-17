package sopt36.sopkathon.server_ios1.repository.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt36.sopkathon.server_ios1.domain.profile.Area;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    Optional<Area> findById(long id);
}
