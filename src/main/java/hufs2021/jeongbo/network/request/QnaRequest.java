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
public class QnaRequest {

    private Integer qaNumber;

    private Integer qaDivision;

    private Integer qaPrivate;

    private String qaName;

    private String qaField;

    private String qaContent;

    private Integer fId;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    private Integer studentId;
}
