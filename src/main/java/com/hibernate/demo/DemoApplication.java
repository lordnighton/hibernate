package com.hibernate.demo;

import com.hibernate.entities.Message;
import com.hibernate.repositories.MessageRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;
import java.util.Collection;

@SpringBootApplication
@EnableJpaRepositories("com.hibernate")
@EntityScan(basePackages = "com.hibernate.entities")
public class DemoApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Resource
	private MessageRepository messageRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		LOGGER.info("ADD NEW MESSAGE -> ");
		Message message = new Message(RandomStringUtils.randomAlphabetic(10));
		messageRepository.save(message);

		Iterable<Message> messages = messageRepository.findAll();
		LOGGER.info(String.format("ALL MESSAGES (%d) -> ", messageRepository.count()));
		messages.forEach(System.out::println);

		Collection<Message> messagesWithLetter = messageRepository.fetchMessagesThatContainCapitalLetter();
		LOGGER.info(String.format("Messages that contain letter 'C' (%d) -> ", messagesWithLetter.size()));
		messagesWithLetter.forEach(System.out::println);
	}

}