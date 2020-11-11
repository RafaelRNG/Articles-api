package com.rng.articles;

import com.rng.articles.entities.User;
import com.rng.articles.entities.enums.ContactRule;
import com.rng.articles.entities.enums.UserRole;
import com.rng.articles.entities.enums.UserStatus;
import com.rng.articles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticlesApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArticlesApplication.class, args);
	}

	public void run(String... args) throws Exception{

		User user1 = new User(null, "Rafael", ContactRule.ALL_USERS, UserRole.ADMIN, UserStatus.ACTIVE);

		userRepository.save(user1);
	}
}
