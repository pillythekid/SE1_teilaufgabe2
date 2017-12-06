package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private final static String req_NextTurn = "./NextTurnRequest.xml";
	private final static String req_RegisterNewPlayer = "./RegisterNewPlayerRequest.xml";
	private final static String req_SendMap = "./SendMaprequest.xml";
	private final static String req_PlayerData = "./PlayerDataRequest.xml";
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
