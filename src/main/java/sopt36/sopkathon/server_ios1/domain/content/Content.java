package sopt36.sopkathon.server_ios1.domain.content;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt36.sopkathon.server_ios1.domain.BaseEntity;
import sopt36.sopkathon.server_ios1.domain.enums.Hobby;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "content")
public class Content extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "hobby")
    private Hobby hobby;

    @Column(name = "image")
    private String image;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;
}
