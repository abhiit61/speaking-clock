package com.example.myclock.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myclock.service.MyClockService;

@RestController
@RequestMapping("/api/v1/clock")
public class MyClockController {

	@Autowired
	private MyClockService service;
	
	@RequestMapping("/speak")
	public String speak(@RequestParam(required = false) String time) {
		if(StringUtils.hasText(time)) {
			return service.speak(time);
		} else {
			return service.speak(LocalTime.now());
		}
		
	}
	
}
