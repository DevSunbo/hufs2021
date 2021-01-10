package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum LocationState {
    STUDYROOM (1,"스터디룸", "학생이 사용하는 스터디룸"),
    LECTUREROOM (2, "강의실", "강의를 진행하는 강의실"),
    OFFICEROOM (3, "사무실", "행정업무를 보는 사무실");

    private Integer id;
    private String title;
    private String description;
}
