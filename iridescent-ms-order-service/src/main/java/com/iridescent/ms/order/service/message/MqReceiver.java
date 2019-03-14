package com.iridescent.ms.order.service.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description: 接收mq消息
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Slf4j
@Component
public class MqReceiver {

    // 三种方式
    // 1. @RabbitListener(queues = "myQueue")
    // 2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3. 自动创建，Exchange和Queue绑定
    /* @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))*/

    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }
}
