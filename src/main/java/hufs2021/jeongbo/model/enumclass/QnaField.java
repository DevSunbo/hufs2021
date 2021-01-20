package hufs2021.jeongbo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QnaField {

    기자재(0, "기자재", "기자재 관련 질문"),
    스터디룸(1, "스터디룸", "스터디룸 관련 질문"),
    팀프로젝트(2, "팀프로젝트", "팀 프로젝트 관련 질문"),
    기타(3, "기타", "위 3가지 분야를 제외한 모든 것들")
    ;

    private Integer id;

    private String title;

    private String description;
}
