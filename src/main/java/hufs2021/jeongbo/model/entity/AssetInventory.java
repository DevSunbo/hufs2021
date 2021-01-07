package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "asset_inventory")
public class AssetInventory {
    @Id
    private Integer aiNumber; // 기자재 구분 번호 PK

    private Integer aiSerial; // 기자재 바코드
    private LocalDate aiExpiration; // 기자재 만료일

    // 대여가능 : 1, 대여중 : 2, 대여 대기 : 3
    private Integer aiStatus; // Enum 기자재 상태

    private Integer aiRoom; // 기자재 위치 Location room_location Fk
    private Integer aiUser; // 기자재를 빌린 사람
    private Integer caNumber; // 기자재 카테고리 CATEGORY ca_number FK

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자

}
