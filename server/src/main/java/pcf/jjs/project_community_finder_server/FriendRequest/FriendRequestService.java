package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Optional<Users> senderOptional = usersRepository.findUsersByEmail(sender);
        Optional<Users> receiverOptional = usersRepository.findUsersByEmail(receiver);
        
        FriendRequest request = new FriendRequest(senderOptional.get(), receiverOptional.get());
        friendRequestRepository.save(request);

        return "request sent";
    }

    /**
     * Gets a list of emails that send a friend request to the receiver
     * @param reciever the user who is recieving the friend request's email
     * @return a list of emails from sender to the reciever
     */
    public Map<String, Object> getAllFriendRequest(String receiver){
        Optional<List<String>> fr = friendRequestRepository.findAllByReceiverEmail(receiver);
        Map<String, Object> responseData = new HashMap<>();
        List<String> listOfSender = fr.get();
        responseData.put("senders", listOfSender);
        return responseData;
    }

    public String friendRequestResponse(String sender, String receiver, String response){        
        if(response.equalsIgnoreCase("decline")){
            // friendRequestRepository.deleteBySenderAndReceiver(sender, receiver);
            // friendRequestRepository.deleteAll();
            // Long f = (long) 1;
            // friendRequestRepository.deleteById((long) 1);
            friendRequestRepository.testDel();
            // friendRequestRepository.delete(null);
            // System.out.println("halla");
        }
        return "decline ok";
    }

}
