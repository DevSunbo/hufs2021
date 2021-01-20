package hufs2021.jeongbo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Accessors(chain = true)
public class Major {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키를 직접 설정하는 것, 키 값을 직접 설정할 때는 없어도 됨
//    @Column(name = "m_code")
>>>>>>> e7a89746a63ddf192d5d7359afcc5dfcd971df8d
    private Integer mCode; // 전공 구분 코드 PK

    private String mName; // 전공 이름

    private LocalDateTime createdAt; // 등록일

    private Integer createdBy; // 등록자

    private LocalDateTime updatedAt;// 수정일

    private Integer updatedBy;// 수정자
<<<<<<< HEAD
=======

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "major")
    private List<User> userList;
>>>>>>> e7a89746a63ddf192d5d7359afcc5dfcd971df8d

}
