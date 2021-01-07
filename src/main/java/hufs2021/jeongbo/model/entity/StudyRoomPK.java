package hufs2021.jeongbo.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class StudyRoomPK implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    private Integer rId; // 호실번호 Location room_location Fk

    @EqualsAndHashCode.Include
    @Id
    private Integer rNumber; // 스터디룸 방번호 rId 에 따라 AI

    public StudyRoomPK(Integer rId, Integer rNumber) {
        this.rId = rId;
        this.rNumber = rNumber;
    }
}
