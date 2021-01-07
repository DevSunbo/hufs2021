package hufs2021.jeongbo.model.entity;

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
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qaNumber;

    private int qaPrivate;

    private String qaName;

    private String qaField;

    private String qaContent;

    private String qaSolution;

    private String qaAnswer;

    private LocalDateTime createdAt;

    private int createdBy;

    private LocalDateTime updatedAt;

    private int updatedBy;

    @ManyToOne //좀 이상함
    private File file;

    @ManyToOne
    private User user;
}
