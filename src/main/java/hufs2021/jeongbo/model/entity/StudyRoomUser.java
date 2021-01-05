package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudyRoomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruKey; // 구분 PK

    private Integer ruId; // 호실 번호
    private Integer ruNumber; // 스터디룸 안 방번호
    private Integer ruStudentId; // 예약자 학번
    private Integer ruApplicant; // 예약자 일행 학번

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자 = 예약한 사람 학번
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자


}
