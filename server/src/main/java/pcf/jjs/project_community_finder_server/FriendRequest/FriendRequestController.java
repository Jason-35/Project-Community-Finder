package pcf.jjs.project_community_finder_server.FriendRequest;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import pcf.jjs.project_community_finder_server.FriendRequest.dto.FriendRequestDTO;
import pcf.jjs.project_community_finder_server.Users.Users;

@RestController
@RequestMapping(path = "/api/friendRequest")
public class FriendRequestController {

    public final FriendRequestService friendRequestService;
    FriendRequestController(FriendRequestService friendRequestService){
        this.friendRequestService = friendRequestService;
    }
    
    @PostMapping(path = "send")
    public String sendFriendRequest(@RequestBody @Valid FriendRequestDTO friendRequest){
        // These will be String containing email address.
        String sender = friendRequest.getSender();
        String receiver = friendRequest.getReceiver();
        return friendRequestService.sendFriendRequest(sender, receiver);
    }

    @GetMapping(path = "getAllRequest")
    public Map<String, Object> getAllFriendRequest(@RequestParam String receiverEmail){
        System.out.println(receiverEmail);
        return friendRequestService.getAllFriendRequest(receiverEmail);
    }

    @PatchMapping(path = "accept")
    public String acceptFriendRequest(@RequestBody FriendRequestDTO request){
        String sender = request.getSender();
        String receiver = request.getReceiver();
        return friendRequestService.friendRequestResponse(sender, receiver, "accept");
    }

    @DeleteMapping(path = "decline")
    public String declineFriendRequest(@RequestParam String sender, @RequestParam String receiver){
       friendRequestService.friendRequestResponse(sender, receiver, "decline");
        return "decline request";
    }

    
}
