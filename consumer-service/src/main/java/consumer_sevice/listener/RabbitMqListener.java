package consumer_sevice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {

    @RabbitListener(queues = "firstQueue")
    public void processFirstQueue(String message){
        log.info("Received from firstQueue : {}", message);
    }

    @RabbitListener(queues = "secondQueue")
    public void processSecondQueue(String message){
        log.info("Received from secondQueue : {}", message);
    }
}
