package hufs2021.jeongbo.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MajorRequest {

    private Integer mCode; // 전공 구분 코드 PK

    private String mName; // 전공 이름

    private LocalDateTime createdAt; // 등록일

    private Integer createdBy; // 등록자

    private LocalDateTime updatedAt;// 수정일

    private Integer updatedBy;// 수정자
}
