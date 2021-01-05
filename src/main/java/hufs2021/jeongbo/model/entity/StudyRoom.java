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
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId; // 호실번호 Location room_location Fk

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer r_number; // 스터디룸 방번호 rId 에 따라 AI

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