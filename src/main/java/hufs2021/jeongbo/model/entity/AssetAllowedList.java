package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class AssetAllowedList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caNumber; // 카테고리 번호 Fk
    private Integer studentId; // 학번 FK
}
