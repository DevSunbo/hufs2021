package hufs2021.jeongbo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class TeamProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pNumber;

    private String pField;

    private String pName;

    private int pMin;

    private int pMax;

    private LocalDate pDeadline;

    private String pMainLanguage;

    private String pLocation;

    private String pContent;

    private Integer fId;

    private LocalDateTime createdAt;

    private int createdBy;

    private LocalDateTime updatedAt;

    private int updatedBy;



}
