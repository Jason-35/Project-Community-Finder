package pcf.jjs.project_community_finder_server.FriendRequest.dto;

import jakarta.validation.Valid;

public class FriendRequestDTO {
    @Valid
    private String sender;

    @Valid
    private String receiver;

    public String getSender(){
        return this.sender;
    }

    public String getReceiver(){
        return this.receiver;
    }

    public void setSender(String sender){
        this.sender = sender;
    }

    public void setreceiver(String receiver){
        this.receiver = receiver;
    }
    
}
