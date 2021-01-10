package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Accessors(chain=true)
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId; // Asset PK 구분하기 위해 사용
    private String aMajor; // 해당 Asset을 사용할 수 있는 전공
    private Integer aGrade; // Asset 학년 제한
    private LocalDate aDeadline; // Asset 반납일

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자

    @Column(name = "Category_ca_number")
    private Integer caNumber;  // Fk CATEGORY_ca_number
}
