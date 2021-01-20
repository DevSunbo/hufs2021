package hufs2021.jeongbo.model.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Embeddable
public class QnaId implements Serializable {

    private Integer qaNumber;

    private Integer qaDivision;
}
