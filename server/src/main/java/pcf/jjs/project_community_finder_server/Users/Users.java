package pcf.jjs.project_community_finder_server.Users;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long id;

    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @Email(message = "must be an email")
    @NotEmpty(message = "email cannot be empty")
    private String email;
    
    private String bio;
    private String experience;
    private ArrayList<String> languages;
    private ArrayList<String> frameworks;

    public Users(){}

    public Users( String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.languages = new ArrayList<String>();
        this.frameworks = new ArrayList<String>();
    }
    
    public ArrayList<String> getFramework(){
        return this.frameworks;
    }

    public void addFramework(String framework){
        this.frameworks.add(framework);
    }

    public void removeFramework(String framework){
        int index = this.frameworks.indexOf(framework);
        this.frameworks.remove(index);
    }

    public ArrayList<String> getLanguages(){
        return this.languages;
    }

    public void addLanguages(String language){
        this.languages.add(language);
    }

    public void removeLanguages(String language){
        int index = this.languages.indexOf(language);
        this.languages.remove(index);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}