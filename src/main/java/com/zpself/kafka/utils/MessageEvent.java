package com.zpself.kafka.utils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.ApplicationEvent;

/**
 * 监听
 * @author yuyang
 *
 */
public class MessageEvent extends ApplicationEvent {
    private static final long serialVersionUID = -4468405250074063206L;
    private ConsumerRecord<Integer, String> msgs;

    public MessageEvent(ConsumerRecord msgs) {
        super(msgs);
        this.setMsgs(msgs);
    }

    public ConsumerRecord getMsgs() {
        return msgs;
    }

    public void setMsgs(ConsumerRecord msgs) {
        this.msgs = msgs;
    }
}
