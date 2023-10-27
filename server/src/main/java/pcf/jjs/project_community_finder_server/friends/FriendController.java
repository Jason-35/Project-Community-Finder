package pcf.jjs.project_community_finder_server.friends;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/friends")
public class FriendController {

    public final FriendService friendService;


    FriendController(FriendService friendService) {
        this.friendService = friendService;
    }


    @GetMapping("/getFriends")
    public List<String> test(@RequestParam String email){
        return friendService.getFriendsUsernames(email);
        
    }
}
