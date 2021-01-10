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
@Entity(name = "asset_history")
@Builder
public class AssetHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ahNumber; // 구분키 PK

    @Column(name = "ah_ai_number")
    private Integer ahAiNumber; // Asset Inventory ai_number FK

    private LocalDate ahApplicationdate; // 신청한 날
    private LocalDate ahReturndate; // 반납한 날

    private LocalDateTime createdAt; // 등록일 = 신청한 날
    private Integer createdBy; // 등록한 사람 = 신청한 사람
    private LocalDateTime updatedAt; // 수정일 = 반납한 날
    private Integer updatedBy; // 수정한 사람 = 관리자

    @Column(name = "USER_student_id")
    private int studentId; // 신청한 사람 학번 FK

    /*@ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ah_ai_number",  insertable = false, updatable = false),
            @JoinColumn(name = "USER_student_id", referencedColumnName = "aiUser",insertable = false, updatable = false)

    })
    private AssetInventory assetInventory;*/

}
