package hufs2021.jeongbo.network.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDto {

    private String accessToken;
}
