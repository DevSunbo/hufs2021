package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId; // Asset PK 구분하기 위해 사용
    private String aMajor; // 해당 Asset을 사용할 수 있는 전공
    private LocalDate aDeadline; // Asset 반납일

    private LocalDateTime createdAt; // 등록일
    private int createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private int updatedBy; // 수정자
}
