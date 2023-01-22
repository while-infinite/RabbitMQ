package producer_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Queue firstQueue(){
        return new Queue("firstQueue");
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("secondQueue");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingFirst(){
        return  BindingBuilder.bind(firstQueue()).to(directExchange()).with("high");
    }

    @Bean
    public Binding bindingSecond(){
        return  BindingBuilder.bind(secondQueue()).to(directExchange()).with("middle");
    }

    @Bean
    public Binding bindingThird(){
        return  BindingBuilder.bind(secondQueue()).to(directExchange()).with("low");
    }

}
