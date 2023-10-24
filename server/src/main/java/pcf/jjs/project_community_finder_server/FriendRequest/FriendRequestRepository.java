package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long>{
    
    @Query("SELECT r.sender.email FROM FriendRequest r WHERE r.receiver.email = :email")
    Optional<List<String>> findAllByReceiverEmail(@Param("email") String receiverEmail);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM FriendRequest r WHERE r.sender.email = :sender AND r.receiver.email = :receiver")
    void deleteBySenderAndReceiver(@Param("sender") String sender, @Param("receiver") String receiver);
    
}
