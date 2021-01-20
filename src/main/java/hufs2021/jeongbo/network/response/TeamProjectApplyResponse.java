package hufs2021.jeongbo.network.response;

import hufs2021.jeongbo.model.enumclass.TeamProjectApplyApproved;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamProjectApplyResponse {

    private Integer paNumber;

    private String paContent;

    private TeamProjectApplyApproved paApproved;

    private Integer fId;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    private Integer studentId;

    private Integer pNumber;
}
