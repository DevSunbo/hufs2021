package hufs2021.jeongbo.model.dto;

import hufs2021.jeongbo.model.enumclass.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

    private Integer studentId;

    private String name;

    private RoleEnum role;
}
