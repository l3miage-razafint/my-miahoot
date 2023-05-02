package fr.uga.l3miage.example.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class UserDtoRequest {

//    @NotEmpty(message = "User ID required")
//    private Long userId;

    @NotBlank(message = "Username is required")
    private String username;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Boolean creativeMode;
}
