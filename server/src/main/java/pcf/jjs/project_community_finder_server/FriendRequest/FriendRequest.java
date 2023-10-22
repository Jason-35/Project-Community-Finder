package pcf.jjs.project_community_finder_server.FriendRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pcf.jjs.project_community_finder_server.Users.Users;

@Entity
@Table
public class FriendRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_email")
    private Users sender;

    @ManyToOne
    @JoinColumn(name = "receiver_email")
    private Users receiver;

    public FriendRequest(){}

    public FriendRequest(Users sender, Users receiver){
        this.sender = sender;
        this.receiver = receiver;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setSender(Users sender){
        this.sender = sender;
    }

    public void setReceiver(Users receiver){
        this.receiver = receiver;
    }

    public long getId(){
        return this.id;
    }

    public Users getSender(){
        return this.sender;
    }

    public Users getReceiver(){
        return this.receiver;
    }
}
