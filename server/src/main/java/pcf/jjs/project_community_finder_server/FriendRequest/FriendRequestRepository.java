package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long>{

    @Query("SELECT r.sender.email FROM FriendRequest r WHERE r.receiver.email = :email")
    Optional<List<String>> findAllByReceiverEmail(@Param("email") String receiverEmail);
}
