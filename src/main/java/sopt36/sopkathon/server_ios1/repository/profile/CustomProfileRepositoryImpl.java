package sopt36.sopkathon.server_ios1.repository.profile;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;
import sopt36.sopkathon.server_ios1.domain.profile.QProfile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class CustomProfileRepositoryImpl implements CustomProfileRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Profile> findRandomRecommendedProfile(Profile currentProfile) {
        QProfile profile = QProfile.profile;

        BooleanBuilder condition = new BooleanBuilder()
                .and(profile.profileOpen.isTrue())
                .and(profile.hobby.eq(currentProfile.getHobby()))
                .and(profile.id.ne(currentProfile.getId()));

        if (Boolean.TRUE.equals(currentProfile.getSameGenderOnly())) {
            condition.and(profile.gender.eq(currentProfile.getGender()));
        }

        // 추천 대상이 동성만 허용할 경우 → current와 동성만 허용
        condition.and(
                profile.sameGenderOnly.eq(false)
                        .or(profile.gender.eq(currentProfile.getGender()))
        );

        List<Profile> candidates = queryFactory
                .selectFrom(profile)
                .where(condition)
                .fetch();

        if (candidates.isEmpty()) return Optional.empty();

        Profile random = candidates.get(ThreadLocalRandom.current().nextInt(candidates.size()));
        return Optional.of(random);
    }
}

