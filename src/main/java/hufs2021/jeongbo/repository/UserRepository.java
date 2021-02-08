package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByStudentId(Integer sid);
    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);
}
