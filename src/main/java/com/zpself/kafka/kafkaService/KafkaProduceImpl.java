package com.zpself.kafka.kafkaService;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class KafkaProduceImpl  {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private Producer<String, String> producer;
    /**
     * 发送同步消息
     *
     * @param topic   消息主题
     * @param content 消息内容
     * @return 消息发送结果
     */
    public Object sendSyncMsg(String topic, String content) throws Exception {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, content);
        return send.get().getProducerRecord().toString();
    }

    /**
     * 异步消息，没有ListenableFuture.get()
     *
     * @param topic    消息主题
     * @param content  消息内容
     */
    public void sendAsyncMsg(String topic, String content) throws Exception {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, content);
        producer.send(producerRecord,null);
    }
}
