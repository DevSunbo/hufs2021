package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    //foreign key
    @Column(name = "STUDY_ROOM_r_id")
    private Integer STUDYROOMRId;
    @Column(name = "STUDY_ROOM_r_number")
    private Integer STUDYROOMRNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "STUDY_ROOM_r_id", referencedColumnName = "rId", insertable = false, updatable = false),
            @JoinColumn(name = "STUDY_ROOM_r_number", referencedColumnName = "rNumber", insertable = false, updatable = false)
    })
    private StudyRoom studyRoom;
}
