package thisiscomedy.nodamnodam.server.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import thisiscomedy.nodamnodam.server.domain.auth.presentation.dto.request.UserRegisterRequest;
import thisiscomedy.nodamnodam.server.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String profileUrl;

    @Column(nullable = true)
    private Integer smokePerDay;

    @Column(nullable = true)
    private Integer cigarettePrice;

    @Builder
    public User(String name, String email, String profileUrl, Integer smokePerDay, Integer cigarettePrice) {
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
        this.smokePerDay = smokePerDay;
        this.cigarettePrice = cigarettePrice;
    }

    public User update(UserRegisterRequest request) {
        this.name = request.name();
        this.smokePerDay = request.smokePerDay();
        this.cigarettePrice = request.cigarettePrice();
        return this;
    }
}
