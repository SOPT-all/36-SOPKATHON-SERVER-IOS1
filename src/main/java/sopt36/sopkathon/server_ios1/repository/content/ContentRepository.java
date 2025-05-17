package sopt36.sopkathon.server_ios1.repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt36.sopkathon.server_ios1.domain.content.Content;
import sopt36.sopkathon.server_ios1.domain.enums.Hobby;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAllByHobbyIs(Hobby hobby);
}
