package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class AssetNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer anNumber; // 등록 번호 PK

    private String anContent; // 공지 내용

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
