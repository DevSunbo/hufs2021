package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudyRoomState {
    RESERVE_OK (1,"예약가능", "예약 가능한 상태"),
    RESERVE_ING (2, "예약중", "예약자가 있는 예약중 상태"),
    RESERVE_NO (3, "예약불가", "예약이 불가능한 상태");

    private Integer id;
    private String title;
    private String description;
}
