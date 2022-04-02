package uz.ibrokhimoff.meal.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.ibrokhimoff.meal.domain.base.Auditable;
import uz.elmurodov.meal.enums.*;
import uz.ibrokhimoff.meal.enums.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auth_user", indexes = {
        @Index(name = "auth_user_username_key",
                columnList = "username", unique = true
        )
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable implements GrantedAuthority {

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "chat_id")
    private String chatId;

    @Enumerated(EnumType.STRING)
    private AuthRole role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Override
    public String getAuthority() {
        return role.name();
    }


    @Builder(builderMethodName = "childBuilder")
    public AuthUser(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, String username, String password, String fullName, String phone, Department department, String chatId, AuthRole role, Status status, Position position, Language language) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted);
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.department = department;
        this.chatId = chatId;
        this.role = role;
        this.status = status;
        this.position = position;
        this.language = language;
    }
}