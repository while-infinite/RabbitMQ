package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RabbitController {

    private final RabbitTemplate template;

    @PostMapping("/message")
    public ResponseEntity<String> message(@RequestBody Map<String, String> message){
        template.setExchange("directExchange");
        template.convertAndSend(message.get("key"), message.get("message"));
        return ResponseEntity.ok("Success send message");
    }
}
