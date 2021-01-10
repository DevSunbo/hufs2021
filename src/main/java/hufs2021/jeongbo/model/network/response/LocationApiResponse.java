package hufs2021.jeongbo.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationApiResponse {
    private Integer roomLocation; // 호실 PK

    // 스터디룸 : 1, 강의실 : 2, 사무실 : 3
    private Integer roomPupose; // Enum 방의 사용 목적

    private String manager; // 방 관리자 이름
    private String managerPhoneNumber; // 관리자 핸드폰 번호
    private String managerOfficePn; // 관리자 사무실 전화번호

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}
