package demo.springboot.activemq.producer;

import demo.springboot.activemq.config.ActiveMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Random;

/**
 * @author dean.lee
 */
@RestController
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;





    //发送queue类型消息
    @GetMapping("/queue")
    public void sendQueueMsg(String msg){
        jmsTemplate.convertAndSend(queue, msg);
    }

//    //发送topic类型消息
//    @GetMapping("/topic")
//    public void sendTopicMsg(String msg){
//        Random r=new Random();
//        int i = r.nextInt();
//        System.out.println(i);
//        if(i%2==0){
////            System.out.println("第一个队列");
//            ActiveMQConfig activeMQConfig=new ActiveMQConfig();
//            Topic topic = activeMQConfig.topic();
//            jmsTemplate.convertAndSend(topic, msg);
//
//        }else{
////            System.out.println("第二个队列");
//            ActiveMQConfig activeMQConfig=new ActiveMQConfig();
//            Topic topic2 = activeMQConfig.topic2();
//            jmsTemplate.convertAndSend(topic2, msg);
//        }
//
//    }

    //发送topic类型消息
    @GetMapping("/topic")
    public void sendTopicMsg(String msg){
            ActiveMQConfig activeMQConfig=new ActiveMQConfig();
            Topic topic = activeMQConfig.topic();
            jmsTemplate.convertAndSend(topic, msg);

    }

}
