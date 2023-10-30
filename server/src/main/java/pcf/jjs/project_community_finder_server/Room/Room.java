package pcf.jjs.project_community_finder_server.Room;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import pcf.jjs.project_community_finder_server.Users.Users;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    @JoinColumn(name = "owner_email")
    private Users roomOwner;

    private String status;

    @NotEmpty(message = "room name cannot be empty")
    private String roomName;
    private String description; 
    private List<String> tags;
    private String ownerUsername;
    // private List<String> members;

    public Room(){}
    
    public Room(Users roomOwner, String ownerUsername, String roomName, String status, String description, List<String> tags){
        this.roomOwner = roomOwner;
        this.roomName = roomName;
        this.status = status;
        this.description = description;
        this.tags = tags;
        this.ownerUsername = ownerUsername;
    }

    public String getOwnerUsername(){
        return this.ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername){
        this.ownerUsername = ownerUsername;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public List<String> getTags(){
        return this.tags;
    }

    public void setRoomOwner(Users roomOwner){
        this.roomOwner = roomOwner;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Users getRoomOwner(){
        return this.roomOwner;
    }

    public String getStatus(){
        return this.status;
    }
    
    public String getRoomName(){
        return this.roomName;
    }

    public String getDescription(){
        return this.description;
    }
    

}
