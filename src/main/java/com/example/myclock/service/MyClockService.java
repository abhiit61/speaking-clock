package com.example.myclock.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.example.myclock.controller.MyClockUtil;

@Service
public class MyClockService {

	public String speak(LocalTime time) {
		return MyClockUtil.convertToWords(time);
	}
	
	public String speak(String time) {
		if(time == null || time.equals("")) {
			return MyClockUtil.convertToWords(LocalTime.now());
		}
		if (MyClockUtil.isValid(time)) {
			return MyClockUtil.convertToWords(time);
		} else {
			throw new IllegalArgumentException("Invalid time. Must be in hh:mm format");
		}
	}

}
