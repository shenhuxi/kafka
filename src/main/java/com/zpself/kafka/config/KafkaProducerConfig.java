package com.zpself.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * kafka生产者初始化类
 * @author zyting
 * @sinne 2020-02-23
 */
@Configuration
public class KafkaProducerConfig {

    // kafka监听地址
    private String bootstrapServers;

    @Autowired
    private Environment env;

    public Map<String,Object> senderProps(){

        Map<String,Object> props = new ConcurrentHashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, env.getProperty("spring.kafka.bootstrap-servers"));
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    // 默认两个都配置，因此把条件判断注解先注释
    // @ConditionalOnExpression("${mq.enabled}==1&&${mq.kafka.enabled}==1")
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(senderProps());
    }

    @Bean //kafka发送消息模板
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }

    @Bean
    public Producer<String, String> producer() {
        System.out.println("初始化kafka生产者........");
        return new KafkaProducer<String, String>(senderProps());
    }

}
