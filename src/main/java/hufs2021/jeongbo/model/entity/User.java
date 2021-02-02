package hufs2021.jeongbo.model.entity;

import hufs2021.jeongbo.model.enumclass.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class User {

    @Id
    private Integer studentId;

    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;


    @Column(name = "major_m_code")
    private Integer mCode;

    @ManyToOne
    @JoinColumn(name = "major_m_code", insertable = false, updatable = false)
    private Major major;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<TeamProject> teamProjectList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Qna> qnaList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<TeamProjectApply> teamProjectApplyList;

}
