package pcf.jjs.project_community_finder_server.friends;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pcf.jjs.project_community_finder_server.Users.Users;

@Repository
public interface FriendRepository extends JpaRepository<Users, String> {

    @Query("SELECT u2.username FROM Users u1 JOIN u1.friends u2 WHERE u1.email = :userEmail")
    List<String> findUserFriends(@Param("userEmail") String userEmail);
}
