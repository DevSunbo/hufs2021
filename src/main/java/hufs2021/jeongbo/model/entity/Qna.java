package hufs2021.jeongbo.model.entity;

import hufs2021.jeongbo.model.enumclass.QnaField;
import hufs2021.jeongbo.model.key.QnaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@IdClass(QnaId.class) //쿼리 짜는게 Embeddable이랑 좀 다름
public class Qna implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment 없음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qaNumber;


    @Id
//    @EmbeddedId
    private Integer qaDivision;

    private Integer qaPrivate;

    private String qaName;

    @Enumerated(EnumType.STRING)
    private QnaField qaField;

    private String qaContent;

    private Integer fId;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    @Column(name = "USER_student_id")
    private Integer student_id;

    @ManyToOne
    @JoinColumn(name = "USER_student_id", insertable = false, updatable = false)
    private User user;
}
