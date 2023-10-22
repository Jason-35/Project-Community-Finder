package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

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
        
        FriendRequest request = new FriendRequest(senderOptional.get(), receiverOptional.get());
        friendRequestRepository.save(request);

        return "request sent";
    }

    public Map<String, Object> getAllFriendRequest(String reciever){
        Optional<List<String>> fr = friendRequestRepository.findAllByReceiverEmail(reciever);
        System.out.println(fr.get().get(0));
        System.out.println(fr.get().get(1));
        Map<String, Object> responseData = new HashMap<>();
        List<String> listOfSender = fr.get();
        responseData.put("senders", listOfSender);
        return responseData;
    }

    public String friendRequestResponse(String sender, String reciever, String response){

        return response;
    }

}
