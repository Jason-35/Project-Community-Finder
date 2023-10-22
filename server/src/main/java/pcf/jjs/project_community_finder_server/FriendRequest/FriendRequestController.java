package pcf.jjs.project_community_finder_server.FriendRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(sender);
        System.out.println(receiver);
        return friendRequestService.sendFriendRequest(sender, receiver);
    }
}
