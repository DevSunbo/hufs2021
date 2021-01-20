package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamProjectApplyApproved {

    승인(0, "승인", "승인 완료"),
    거절(1, "거절", "거절"),
    대기(2, "대기 중", "대기중");

    private Integer id;

    private String title;

    private String description;
}
