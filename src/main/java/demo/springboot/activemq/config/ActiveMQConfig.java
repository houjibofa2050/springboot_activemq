package demo.springboot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Properties;

/**
 * @author dean.lee
 */
@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("springboot.queue");
    }

    //springboot默认只配置queue类型消息，如果要使用topic类型的消息，则需要配置该bean
    @Bean
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //这里必须设置为true，false则表示是queue类型
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public Topic topic() {
//        return new ActiveMQTopic("springboot.topic");
//        return new ActiveMQTopic("springboot.topic?consumer.prefetchSize=10");
        return new ActiveMQTopic("springboot.topic");
    }

    @Bean
    public Topic topic2() {
//        return new ActiveMQTopic("springboot.topic");
        return new ActiveMQTopic("springboot.topic2?consumer.prefetchSize=10");
//        return new ActiveMQTopic("springboot.topic");
    }
}
