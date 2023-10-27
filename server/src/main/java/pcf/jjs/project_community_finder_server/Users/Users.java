package pcf.jjs.project_community_finder_server.Users;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import pcf.jjs.project_community_finder_server.FriendRequest.FriendRequest;

@Entity
@Table
public class Users {

    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "password cannot be empty")
    private String password;
    
    @Email(message = "must be an email")
    @Id
    @NotEmpty(message = "email cannot be empty")
    private String email;
    
    private String bio;
    private String experience;
    private ArrayList<String> languages;
    private ArrayList<String> frameworks;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<FriendRequest> sentFriendRequest;

    // @ManyToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    // private List<Friends> friends;

    @ManyToMany
    @JoinTable(name = "friendships", joinColumns = @JoinColumn(name = "user_email"), inverseJoinColumns = @JoinColumn(name = "friend_email"))
    private List<Users> friends;

    public Users(){}

    public Users( String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.languages = new ArrayList<String>();
        this.frameworks = new ArrayList<String>();
        this.sentFriendRequest = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public List<Users> getFriends(){
        return this.friends;
    }

    public void addFriend(Users friend){
        this.friends.add(friend);
    }

    public void removeFriend(Users friend){
        System.out.println("remove a friend");
    }

    public void setSentFriendRequest(List<FriendRequest> sentFriendRequests){
        this.sentFriendRequest = sentFriendRequests;
    }

    public List<FriendRequest> getSentFriendRequest(){
        return this.sentFriendRequest;
    }
    
    public ArrayList<String> getFramework(){
        return this.frameworks;
    }

    public void setFramework(ArrayList<String> framework){
        this.frameworks = framework;
    }

    public ArrayList<String> getLanguages(){
        return this.languages;
    }

    public void setLanguages(ArrayList<String> language){
        this.languages = language;
    }

    public String getExperience(){
        return experience;
    }

    public void setExperience(String experience){
        this.experience = experience;
    }

    public String getBio(){
        return bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Account{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
