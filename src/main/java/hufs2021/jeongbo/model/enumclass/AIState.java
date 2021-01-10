package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AIState {
    BORROW_OK (1,"대여가능", "대여 가능한 상태"),
    BORROW_ING (2, "대여중", "사용자가 있는 대여중 상태"),
    BORROW_NO (3, "대여불가", "대여가 불가능한 상태");

    private Integer id;
    private String title;
    private String description;
}
