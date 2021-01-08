package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@IdClass(AssetAllowedListPK.class)
public class AssetAllowedList {
    @Id
    private Integer studentId; // 학번 FK
    @Id
    private Integer caNumber; // 카테고리 번호 Fk


    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
