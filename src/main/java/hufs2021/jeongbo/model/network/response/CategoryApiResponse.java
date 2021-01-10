package hufs2021.jeongbo.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryApiResponse {
    private Integer caNumber; // 카테고리 구분 번호 PK

    private String caRental; //  대여가능 여부
    private String caKind; //  기자재 종류
    private String caName; //  기자재 이름

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
