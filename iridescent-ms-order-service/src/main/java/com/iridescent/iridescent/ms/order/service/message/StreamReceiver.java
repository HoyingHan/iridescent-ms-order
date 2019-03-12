package com.iridescent.iridescent.ms.order.service.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/12
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener("myMessage")
    public void process(Object message) {
        log.info("StreamReceiver: {}", message);
    }

}
