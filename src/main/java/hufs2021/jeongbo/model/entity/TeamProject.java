package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class TeamProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "USER_student_id")
    private Integer studentId;

    @ManyToOne
    @JoinColumn(name = "USER_student_id", insertable = false, updatable = false)
    private User user;

}
