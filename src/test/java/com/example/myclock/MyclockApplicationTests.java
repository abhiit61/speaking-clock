package com.example.myclock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.myclock.service.MyClockService;

@SpringBootTest
class MyclockApplicationTests {

	@Autowired
	private MyClockService service;
	
	@Test
	void testSpeakClock() {
		String correctResult = "It's eight thirty four";
		LocalTime time = LocalTime.of(8, 34);
		String result = service.speak(time);
		assertEquals(correctResult, result);
	}

}
