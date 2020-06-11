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
public class KafkaListenerMy {
    @EventListener(condition = "#event.msgs.topic()=='test'")
    public void rocketmqMsgListener3(MessageEvent event) {
        ConsumerRecord msgs = event.getMsgs();
        log.info("监听到了Canal发送到Test 的数据修改............." + msgs);
    }

    //------------------- 单个消费 -------------------
    @KafkaListener(topics = {"test"},groupId = "order"/*, id="order001"/*,topicPartitions = {@TopicPartition(topic = "T6",partitions = {"0","1"})}*/)
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("监听到了Canal发送到Test 的数据修改............." + message);
        }
    }
    @KafkaListener(topics = {"T7"},groupId = "order"/*,id="order002",topicPartitions = {@TopicPartition(topic = "T6",partitions = {"2"})}*/)
    public void listen2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("2线程=" + Thread.currentThread() + "->user组 kafka消费主题【" + record.topic() + " 分区：" + record.partition() + "】" + "record =" + record + "+ message =" + message);
        }
    }
}