package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import pcf.jjs.project_community_finder_server.Users.Users;
import pcf.jjs.project_community_finder_server.Users.UsersRepository;

@Service
@Transactional
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
        System.out.println(listOfSender.size());
        System.out.println("ASDasdojasfnsladdnsladfnlkasdnfmkjdsnksjfank");
        responseData.put("senders", listOfSender);
        return responseData;
    }


    public String friendRequestResponse(String sender, String receiver, String response){        
        if(response.equalsIgnoreCase("decline")){
                friendRequestRepository.deleteBySenderAndReceiver(sender, receiver);
            }
            
        if(response.equalsIgnoreCase("accept")){
            
            Users senderUser = usersRepository.findUsersByEmail(sender).get();
            Users receiverUser = usersRepository.findUsersByEmail(receiver).get();

            receiverUser.addFriend(senderUser);
            senderUser.addFriend(receiverUser);

            usersRepository.save(receiverUser);
            usersRepository.save(senderUser);

            friendRequestRepository.deleteBySenderAndReceiver(sender, receiver);   
        }
        return "ok";
    }

}
