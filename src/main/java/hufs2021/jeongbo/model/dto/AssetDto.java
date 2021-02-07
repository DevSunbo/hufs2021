package hufs2021.jeongbo.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {

    private String caRental; //  대여가능 여부
    private String caKind; //  기자재 종류
    private String caName; //  기자재 이름

    private Integer aiSerial; // 기자재 구분 번호 serial number

    private Integer restAsset; // 남은 재고 계산해서 입력

    private LocalDate assetDeadline; // Asset 반납일 값을 입력 받음음


}
