package hufs2021.jeongbo.model.entity;

import hufs2021.jeongbo.model.enumclass.TeamProjectApplyApproved;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class TeamProjectApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paNumber;

    private String paContent;

    @Enumerated(EnumType.STRING)
    private TeamProjectApplyApproved paApproved;

    private Integer fId;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;
<<<<<<< HEAD
=======

    @Column(name = "USER_student_id")
    private Integer studentId;

    @Column(name = "TEAM_PROJECT_p_number")
    private Integer pNumber;

    @ManyToOne
    @JoinColumn(name = "USER_student_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "TEAM_PROJECT_p_number", insertable = false, updatable = false)
    private TeamProject teamProject;
>>>>>>> e7a89746a63ddf192d5d7359afcc5dfcd971df8d


}
