package pcf.jjs.project_community_finder_server.friends;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pcf.jjs.project_community_finder_server.Users.Users;
import pcf.jjs.project_community_finder_server.Users.UsersRepository;

@Service
public class FriendService {
    public final UsersRepository usersRepository;
    public final FriendRepository friendRepository;

    FriendService(UsersRepository usersRepository, FriendRepository friendRepository){
        this.usersRepository = usersRepository;
        this.friendRepository = friendRepository;
    }
    
    public String getFriendsUsernames(String email){
        // Optional<Users> usr = usersRepository.findUsersByEmail(email);
        Users usersFriends = friendRepository.findUserFriends(email);
        System.out.println(usersFriends.getUsername());
        // return usr.get().getFriendsUsername();
        return "pow";
    }
}
