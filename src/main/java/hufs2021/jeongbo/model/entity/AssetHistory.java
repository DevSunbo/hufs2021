package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
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
public class AssetHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ahNumber; // 구분키 PK
    private Integer aiNumber; // Asset Inventory ai_number FK

    private LocalDate ahApplicationdate; // 신청한 날
    private LocalDate ahReturndate; // 반납한 날

    private LocalDateTime createdAt; // 등록일 = 신청한 날
    private Integer createdBy; // 등록한 사람 = 신청한 사람
    private LocalDateTime updatedAt; // 수정일 = 반납한 날
    private Integer updatedBy; // 수정한 사람 = 관리자

    //private int USER_student_id; // 신청한 사람 학번 FK
}
