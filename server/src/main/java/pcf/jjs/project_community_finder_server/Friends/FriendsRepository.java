package pcf.jjs.project_community_finder_server.Friends;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long>{
    // Optional<Friends> findFriendsByEmail(String email);    
}
