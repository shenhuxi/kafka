package com.zpself.kafka.config;

import com.zpself.kafka.utils.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@Slf4j
public class KafkaConsumerConfig {
    @EventListener(condition = "#event.msgs.topic()=='T6'")
    public void rocketmqMsgListener3(MessageEvent event) {
        ConsumerRecord msgs = event.getMsgs();
        log.info("执行T6  主题的逻辑............." + msgs);
    }

    //------------------- 单个消费 -------------------
    @KafkaListener(topics = {"T.ack", "Tlove"}, groupId = "group_001")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("线程=" + Thread.currentThread() + "->user组 kafka消费主题【" + record.topic() + " 分区：" + record.partition() + "】" + "record =" + record + "+ message =" + message);
        }
    }
}