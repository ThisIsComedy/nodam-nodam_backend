package thisiscomedy.nodamnodam.server.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import thisiscomedy.nodamnodam.server.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer smokePerDay;

    @Column(nullable = false)
    private Integer cigarettePrice;

    @Builder
    public User(String name, String email, Integer smokePerDay, Integer cigarettePrice) {
        this.name = name;
        this.email = email;
        this.smokePerDay = smokePerDay;
        this.cigarettePrice = cigarettePrice;
    }
}
