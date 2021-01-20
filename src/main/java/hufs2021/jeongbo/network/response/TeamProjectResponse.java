package hufs2021.jeongbo.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamProjectResponse {

    private Integer pNumber;

    private String pField;

    private String pName;

    private Integer pMin;

    private Integer pMax;

    private LocalDate pDeadline;

    private String pMainLanguage;

    private String pLocation;

    private String pContent;

    private Integer fId;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    private Integer studentId;
}
