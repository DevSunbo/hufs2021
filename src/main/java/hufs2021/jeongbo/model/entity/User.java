package hufs2021.jeongbo.model.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;

    private String phoneNumber;

    private String email;

    private LocalDateTime createdAt;

    private int createdBy;

    private LocalDateTime updatedAt;

    private int updatedBy;

    @OneToOne
    private Major major;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Qna> qnaList;

}
