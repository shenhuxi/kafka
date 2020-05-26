package com.zpself.kafka.module.controller;

import com.zpself.kafka.kafkaService.KafkaProduceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 本类只用于测试服务，实际不存在
 */
@RestController()
@Slf4j
public class TestRocketMQSendController {
    @Autowired
    private KafkaProduceImpl kafkaProduceImpl;
    @GetMapping("/createKafkaSendSyncMsg")
    public Object createKafkaMessage(String topic, String content) throws Exception {
        return kafkaProduceImpl.sendSyncMsg(topic,content);
    }

    @GetMapping("/createKafkaSendAsyncMsg")
    public boolean createKafkaMessageBatch(String topic,String content)throws Exception {
        kafkaProduceImpl.sendAsyncMsg(topic,content);
        return true;
    }
}