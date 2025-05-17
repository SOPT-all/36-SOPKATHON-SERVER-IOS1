package sopt36.sopkathon.server_ios1.domain.matching;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt36.sopkathon.server_ios1.domain.BaseEntity;
import sopt36.sopkathon.server_ios1.domain.profile.Profile;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "matching")
public class Matching extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "profile1_id")
    private Profile profile1;

    @ManyToOne
    @JoinColumn(name = "profile2_id")
    private Profile profile2;

    @Builder
    public Matching(Profile profile1, Profile profile2) {
        this.profile1 = profile1;
        this.profile2 = profile2;
    }
}
