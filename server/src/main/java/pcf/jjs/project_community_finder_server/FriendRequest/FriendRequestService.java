package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import pcf.jjs.project_community_finder_server.Users.Users;
import pcf.jjs.project_community_finder_server.Users.UsersRepository;

@Service
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UsersRepository usersRepository;
    public FriendRequestService(FriendRequestRepository friendRequestRepository, UsersRepository usersRepository){
        this.friendRequestRepository = friendRequestRepository;
        this.usersRepository = usersRepository;
    }


    public String sendFriendRequest(String sender, String receiver){
        System.out.println(sender);
        System.out.println(receiver);
        Optional<Users> senderOptional = usersRepository.findUsersByEmail(sender);
        Optional<Users> receiverOptional = usersRepository.findUsersByEmail(receiver);
        
        // System.out.println(senderOptional.get().getEmail());

        FriendRequest request = new FriendRequest(senderOptional.get(), receiverOptional.get());
        friendRequestRepository.save(request);

        return "request sent";
    }

}
