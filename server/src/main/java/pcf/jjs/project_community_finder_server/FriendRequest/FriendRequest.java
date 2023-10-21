package pcf.jjs.project_community_finder_server.Friends.FriendRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class FriendRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String requestFrom;
    private String requestTo;

    public FriendRequest(){

    }
}
