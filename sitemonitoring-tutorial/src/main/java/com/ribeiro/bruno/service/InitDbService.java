package com.ribeiro.bruno.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribeiro.bruno.entity.Check;
import com.ribeiro.bruno.repository.CheckRepository;

@Service
public class InitDbService {
	
	@Autowired
	private CheckRepository checkRepository;
	
	@PostConstruct
	public void init() {
		System.out.println("INIT DATABASE START");
		
			{
				Check check = new Check();
				check.setName("Google");
				check.setUrl("https://www.google.pt/");
				checkRepository.save(check);
			}
			
		System.out.println("INIT DATABASE FINISH");
	}

}
