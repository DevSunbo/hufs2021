package hufs2021.jeongbo.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetAllowedListApiRequest {
    private Integer studentId; // 학번 FK
    private Integer caNumber; // 카테고리 번호 Fk

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
