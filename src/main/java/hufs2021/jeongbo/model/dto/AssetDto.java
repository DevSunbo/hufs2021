package hufs2021.jeongbo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {

    private String caRental; //  대여가능 여부
    private String caKind; //  기자재 종류
    private String caName; //  기자재 이름

    private Integer aiNumber; // 기자재 구분 번호 PK

    private Integer assetId; // Asset PK 구분하기 위해 사용

    private Integer restAsset; // 남은 재고 계산해서 입력

    private LocalDate assetDeadline; // Asset 반납일



}
