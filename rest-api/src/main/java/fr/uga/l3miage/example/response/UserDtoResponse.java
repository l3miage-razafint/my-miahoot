package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDtoResponse {
    private Long userId;
    private String username;
    private String email;
    private Boolean creativeMode;
}
