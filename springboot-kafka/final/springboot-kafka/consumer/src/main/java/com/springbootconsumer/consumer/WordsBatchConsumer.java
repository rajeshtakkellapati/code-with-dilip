package com.springbootconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.BatchAcknowledgingMessageListener;
import org.springframework.kafka.listener.BatchListenerFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WordsBatchConsumer implements BatchAcknowledgingMessageListener<String, String> {


    @Override
    @KafkaListener(
            topics = {"words"},
        containerFactory = "batchKafkaListenerContainerFactory"
    )
    public void onMessage(List<ConsumerRecord<String, String>> consumerRecords, Acknowledgment ack) {

        log.info("Total number of consumer Records : {} " , consumerRecords.size());
        consumerRecords.forEach((record) -> {
            log.info("Consumed Record is : {} ", record.value());
            try{
                if(record.value().equals("error")){
                    throw new IllegalStateException("Value Not Allowed");
                }
            }catch(Exception e){
                log.error("Exception Observed");
                throw new BatchListenerFailedException("Failed to process Record : ", record);

            }
        });
        assert ack != null;
        ack.acknowledge();
    }

}
