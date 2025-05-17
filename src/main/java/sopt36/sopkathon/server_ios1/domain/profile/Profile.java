package sopt36.sopkathon.server_ios1.domain.profile;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt36.sopkathon.server_ios1.domain.BaseEntity;
import sopt36.sopkathon.server_ios1.domain.enums.Gender;
import sopt36.sopkathon.server_ios1.domain.enums.Hobby;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profile")
public class Profile extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "description")
    private String description;

    @Column(name = "age")
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "hobby")
    private Hobby hobby;

    @Column(name = "same_gender_only")
    private Boolean sameGenderOnly;

    @Column(name = "profile_open")
    private Boolean profileOpen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;
}
