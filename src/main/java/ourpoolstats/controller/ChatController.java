package ourpoolstats.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.chat.ChatExexute;
import ourpoolstats.api.chat.ChatPrepare;
import ourpoolstats.response.ChatResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ChatController {

	@RequestMapping(value = "/sendMessage/{sender}/reciver/{reciver}/message/{message}", method = RequestMethod.POST)
	public ResponseEntity<ChatResponse> sendMessage(@PathVariable("sender") String sender,@PathVariable("reciver") String reciver,@PathVariable("message") String message){
		return new ChatExexute().sendMessage(reciver, sender, message);
	}
	
	@RequestMapping(value = "/getMessage/{sender}/reciver/{reciver}", method = RequestMethod.POST)
	public ResponseEntity<ChatResponse> getMessage(@PathVariable("sender") String sender,@PathVariable("reciver") String reciver){
		return new ChatPrepare().getMessage(sender, reciver);
	}
	
}
