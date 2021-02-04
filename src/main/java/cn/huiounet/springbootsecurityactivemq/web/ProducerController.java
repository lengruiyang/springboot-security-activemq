package cn.huiounet.springbootsecurityactivemq.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 12:36
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    //点对点
    @GetMapping("/queue/test")
    public String sendQueue(String str) {
        this.sendMessage(this.queue, str);
        return "success";
    }

    //发布订阅消息
    @GetMapping("/topic/test")
    public String sendTopic(String str) {
        this.sendMessage(this.topic, str);
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
