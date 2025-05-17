package sopt36.sopkathon.server_ios1.service.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt36.sopkathon.server_ios1.domain.content.Content;
import sopt36.sopkathon.server_ios1.domain.enums.Hobby;
import sopt36.sopkathon.server_ios1.dto.content.response.ContentListResponse;
import sopt36.sopkathon.server_ios1.dto.content.response.ContentResponse;
import sopt36.sopkathon.server_ios1.repository.content.ContentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentListResponse getContents(Long profileId, String hobby) {
        Hobby profileHobby = Hobby.fromText(hobby);

        List<Content> contents = contentRepository.findAllByHobbyIs(profileHobby);

        List<ContentResponse> contentResponseList=  contents.stream()
                .map(ContentResponse::from)
                .toList();

        return ContentListResponse.from(contentResponseList);
    }
}
