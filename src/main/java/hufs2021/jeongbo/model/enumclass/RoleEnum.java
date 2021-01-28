package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {

    USER("USER"),
    ADMIN("ADMIN")
    ;

    private String role;

}
