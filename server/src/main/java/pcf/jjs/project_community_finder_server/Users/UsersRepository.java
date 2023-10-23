package pcf.jjs.project_community_finder_server.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUsersByEmail(String email);

    void deleteUsersByEmail(String email);

    @Query("DELETE FROM Users u WHERE u.email = :email")
    void deleteUser(@Param("email") String email);

}


