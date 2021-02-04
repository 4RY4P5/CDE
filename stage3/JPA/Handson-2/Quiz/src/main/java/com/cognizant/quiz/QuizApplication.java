package com.cognizant.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.model.AttemptOption;
import com.cognizant.quiz.model.AttemptQuestion;
import com.cognizant.quiz.service.AttemptService;


@SpringBootApplication
public class QuizApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizApplication.class);
	private static AttemptService attemptService;
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context=SpringApplication.run(QuizApplication.class, args);
		attemptService=context.getBean(AttemptService.class);
		getAttemptDetailsTest();
		
	}

	private static void getAttemptDetailsTest() {

		LOGGER.info("Start get attempt details");

		Attempt attempt = attemptService.getAttempt(1, 1);

		LOGGER.debug("Attempt = {}", attempt);

		for (AttemptQuestion attemptQuestion : attempt.getAttemptQuestions()) {
			System.out.println(attemptQuestion.getQuestion().getText());
			int optionNo = 1;
			for (AttemptOption attemptOption : attemptQuestion.getAttemptOptions()) {
				System.out.println(optionNo + ") " + attemptOption.getOptions().getText() + " "
						+ attemptOption.getOptions().getScore() + " " + attemptOption.isSelected());
				optionNo++;
			}

		}
		LOGGER.info("End get attempt details ");
	}
}
