package com.digitalbooks.login.app.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import com.digitalbooks.login.app.model.Reader;

@Configuration
public class KafkaConfig {
	

	@Value("${kafka.group.id}")
    private String groupId;
    @Value("${kafka.reply.topic}")
    private String replyTopic;
	
	@Bean
	public ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate(ProducerFactory<String, String> pf, 
			ConcurrentKafkaListenerContainerFactory<String, String> factory) {
		ConcurrentMessageListenerContainer<String, String> replyContainer = factory.createContainer(replyTopic);
		replyContainer.getContainerProperties().setMissingTopicsFatal(false);
		replyContainer.getContainerProperties().setGroupId(groupId);
		return new ReplyingKafkaTemplate<>(pf, replyContainer);
		
	}
	
    @Bean
    public KafkaTemplate<String, Reader> replyTemplate(ProducerFactory<String, Reader> pf,
            ConcurrentKafkaListenerContainerFactory<String, String> factory) {
        KafkaTemplate<String, Reader> kafkaTemplate = new KafkaTemplate<>(pf);
        factory.getContainerProperties().setMissingTopicsFatal(false);
        factory.setReplyTemplate(kafkaTemplate);
        return kafkaTemplate;
    }

}
