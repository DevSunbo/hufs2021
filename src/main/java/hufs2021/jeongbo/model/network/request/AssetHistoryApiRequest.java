package hufs2021.jeongbo.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetHistoryApiRequest {
    private Integer ahNumber; // 구분키 PK

    private Integer ahAiNumber; // Asset Inventory ai_number FK

    private LocalDate ahApplicationdate; // 신청한 날
    private LocalDate ahReturndate; // 반납한 날

    private LocalDateTime createdAt; // 등록일 = 신청한 날
    private Integer createdBy; // 등록한 사람 = 신청한 사람
    private LocalDateTime updatedAt; // 수정일 = 반납한 날
    private Integer updatedBy; // 수정한 사람 = 관리자

    private int studentId; // 신청한 사람 학번 FK
}
