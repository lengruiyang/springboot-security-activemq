package cn.huiounet.springbootsecurityactivemq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 12:42
 */
@Component
public class TopicConsumerListener {
    //topic模式的消费者
    @JmsListener(destination="${spring.activemq.topic-name}", containerFactory="topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
    }
}
