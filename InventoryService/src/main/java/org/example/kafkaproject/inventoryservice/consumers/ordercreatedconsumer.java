package org.example.kafkaproject.inventoryservice.consumers;

import lombok.extern.slf4j.Slf4j;
import org.example.kafkaproject.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ordercreatedconsumer {


    @KafkaListener(topics = "order-created-topic")
    public void handleOrderCreatedTopic(OrderCreatedEvent orderEvent){
        log.info("handleOrderCreatedTopic1 "+orderEvent);
    }


}
