package hufs2021.jeongbo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mCode; // 전공 구분 코드 PK

    private String mName; // 전공 이름

    private LocalDateTime createdAt; // 등록일

    private int createdBy; // 등록자

    private LocalDateTime updatedAt;// 수정일

    private int updatedBy;// 수정자

}
