package org.houserenting.house_renting_backend.dto;

import lombok.*;
import org.houserenting.house_renting_backend.enums.UserRole;
import org.houserenting.house_renting_backend.model.User;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private String userId = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
    private String phoneNumber;

    public User convertToUser() {
        User user = new User();
        user.setUserId(this.userId);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setPhoneNumber(this.phoneNumber);
        user.setCreatedAt(java.sql.Date.valueOf(java.time.LocalDate.now()));
        return user;
    }
}
