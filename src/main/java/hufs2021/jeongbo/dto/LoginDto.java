package hufs2021.jeongbo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {
    Integer sid;

    String password;
}
