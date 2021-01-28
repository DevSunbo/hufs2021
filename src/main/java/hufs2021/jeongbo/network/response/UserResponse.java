package hufs2021.jeongbo.network.response;

import hufs2021.jeongbo.model.enumclass.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer studentId;

    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    private RoleEnum role;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    private Integer mCode;
}
