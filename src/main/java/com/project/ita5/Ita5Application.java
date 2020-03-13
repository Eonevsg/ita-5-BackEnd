package com.project.ita5;

import com.project.ita5.answer.Answer;
import com.project.ita5.answer.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ita5Application /*implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(Ita5Application.class, args);
	}

/*
	@Autowired
	AnswerRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Answer("119", "12123", "answer1"));
		repo.save(new Answer("122", "1233", "answer2"));
		repo.save(new Answer("121", "1234", "answer3"));
		repo.save(new Answer("120", "1235", "answer4"));
		System.out.println(repo.findAll().toString());
	}*/
}
