package com.ribeiro.bruno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribeiro.bruno.entity.Check;
import com.ribeiro.bruno.repository.CheckRepository;

@Service
public class CheckService {

	@Autowired
	private CheckRepository checkRepository;

	public List<Check> findAll() {
		return checkRepository.findAll();
	}

	public void save(Check check) {
		checkRepository.save(check);
	}

	public void remove(Check check) {
		checkRepository.delete(check);
		
	}

}
