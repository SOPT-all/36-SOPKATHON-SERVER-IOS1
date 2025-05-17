package sopt36.sopkathon.server_ios1.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Hobby {
    WALKING("산책"),        // 걷기: 가벼운 산책이나 건강을 위한 활동
    COOKING("요리"),        // 요리: 다양한 음식을 만들며 즐기는 취미
    HIKING("등산"),         // 등산: 산을 오르며 자연을 즐기는 활동
    KNITTING("뜨개질"),       // 뜨개질: 실과 바늘로 물건을 만드는 섬세한 취미
    CALLIGRAPHY("서예"),    // 서예: 붓글씨를 통해 글씨체를 아름답게 표현
    HANDWRITING_ART("캘리그라피"),// 캘리그라피: 감성적인 글씨 디자인 활동
    SWIMMING("수영"),       // 수영: 건강을 위한 유산소 운동
    BASEBALL("야구"),       // 야구: 구기 스포츠로 팀워크가 중요한 활동
    READING("독서"),        // 독서: 책을 읽으며 지식을 쌓는 취미
    ENGLISH("영어회화"),        // 영어회화: 외국어 실력 향상을 위한 활동
    GARDENING("식물 기르기"),      // 식물 기르기: 반려식물 돌보며 힐링하는 취미
    TEA_CEREMONY("다도"),   // 다도: 차를 준비하고 마시는 전통 문화 활동
    CAMPING("캠핑");

    private final String text;

    public static Hobby fromText(String text) {
        return Arrays.stream(Hobby.values())
                .filter(h -> h.getText().equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 hobby 값이 존재하지 않습니다: " + text));
    }

}
