package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class StudyRoomHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rhNumber; // 구분 번호 PK

    private LocalDate rhDate; // 예약한 날짜
    private LocalDateTime rhFrom; // 예약 시작시간
    private LocalDateTime rhEnd; // 예약 끝시간

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자 = 예약한 사람 학번번
   private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
