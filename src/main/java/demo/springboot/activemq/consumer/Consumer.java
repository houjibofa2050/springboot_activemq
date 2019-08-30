package demo.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author dean.lee
 */
@Component
public class Consumer {

    private int num1;

    private int num2;

    //接收queue类型消息
    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
    @JmsListener(destination="springboot.queue")
    public void ListenQueue(String msg){
        System.out.println("接收到queue消息：" + msg);
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        num1++;
        System.out.println("消费第一个消息队列的个数:"+num1);
    }

    @JmsListener(destination="springboot.queue")
    public void ListenQueue2(String msg){
        System.out.println("接收到queue2消息：" + msg);
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        num2++;
        System.out.println("消费第二个消息队列的个数:"+num2);
    }

    //接收topic类型消息
    //destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
    //containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
    @JmsListener(destination="springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void ListenTopic(String msg){
        System.out.println("接收到topic消息：" + msg);
        num1++;
        System.out.println("消费第一个消息队列的个数:"+num1);

    }



    @JmsListener(destination="springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void ListenTopic2(String msg){
        System.out.println("接收到topic2消息：" + msg);
        num2++;
        System.out.println("消费第二个消息队列的个数:"+num2);
    }
}
