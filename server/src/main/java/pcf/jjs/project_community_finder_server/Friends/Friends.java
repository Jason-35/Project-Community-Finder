package pcf.jjs.project_community_finder_server.Friends;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pcf.jjs.project_community_finder_server.Users.Users;

@Entity
@Table
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fromUser;
    private String toUser;
    private ArrayList<String> friend_request;
    private String status;

    public Friends(){}
}
