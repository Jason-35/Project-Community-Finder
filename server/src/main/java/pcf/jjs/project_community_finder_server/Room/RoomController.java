package pcf.jjs.project_community_finder_server.Room;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcf.jjs.project_community_finder_server.Room.dto.RoomDTO;

@RestController
@RequestMapping(path = "/api/room")
public class RoomController {

    public final RoomService roomService;

    RoomController(RoomService roomService){
        this.roomService = roomService;
    }
    

    @PostMapping(path = "/createRoom")
    public String createRoom(@RequestBody RoomDTO roomDTO){
        roomService.createRoom(roomDTO);


        return "room created";
    }
}
