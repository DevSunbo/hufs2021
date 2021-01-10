package hufs2021.jeongbo.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyRoomApiRequest {
    private Integer rId; // 호실번호 Location room_location Fk

    private Integer rNumber; // 스터디룸 방번호 rId 에 따라 AI

    //예약가능 : 1, 예약중 : 2, 예약 불가 : 3
    private Integer rStatus; // Enum 스터디룸 예약 상태
    private LocalDate rDate; // 스터디룸 날짜
    private LocalDateTime rFrom; // 스터디룸 오픈시간
    private LocalDateTime rEnd; // 스터디룸 마감시간

    private Integer rMajor; // 스터디룸 제한 전공 전공 코드 FK

    private Integer rMax; // 스터디룸 입장 최대 인원

    private LocalDateTime createdAt; // 등록일
    private Integer createdBy; // 등록자
    private LocalDateTime updatedAt; // 수정일
    private Integer updatedBy; // 수정자
}