package thisiscomedy.nodamnodam.server.domain.smoke.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import thisiscomedy.nodamnodam.server.domain.user.domain.User;
import thisiscomedy.nodamnodam.server.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
public class Smoke extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Moment moment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Where where;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Why why;

    @Builder
    public Smoke(User user, Moment moment, Where where, Why why) {
        this.user = user;
        this.moment = moment;
        this.where = where;
        this.why = why;
    }
}
