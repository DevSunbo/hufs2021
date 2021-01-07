package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.StudyRoom;
import hufs2021.jeongbo.model.entity.StudyRoomPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, StudyRoomPK> {
}
