package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class AssetAllowedListPK implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    private Integer studentId; // 학번 FK

    @EqualsAndHashCode.Include
    @Id
    private Integer caNumber; // 카테고리 번호 Fk


}
