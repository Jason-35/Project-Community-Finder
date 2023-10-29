package pcf.jjs.project_community_finder_server.Friends;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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
    
    public List<String> getFriendsUsernames(String email){
        List<String> usr = friendRepository.findUserFriends(email);
        return usr;
    }

    @Transactional
    @Modifying
    public void deleteFriend(String usrEmail, String friendEmail){
        Optional <Users> usrOpt = usersRepository.findUsersByEmail(usrEmail);
        Optional <Users> friendOpt = usersRepository.findUsersByEmail(friendEmail);

        Users usr = usrOpt.get();
        Users friend = friendOpt.get();

        usr.getFriends().remove(friend);
        friend.getFriends().remove(usr);
        usersRepository.save(usr);
        usersRepository.save(friend);
    }
}
