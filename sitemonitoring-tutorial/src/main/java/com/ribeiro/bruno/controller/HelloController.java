package com.ribeiro.bruno.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ribeiro.bruno.service.HelloSpringService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean(name = "helloController")
//@Component
//@Named
public class HelloController {
	
	private String name = "Bruno";
	
	@ManagedProperty("#{helloSpringService}")
//	@Autowired
//	@Inject
	private HelloSpringService helloSpringService;
	
	@PostConstruct
	public void init() {
		name = "Bruno";
	}
	
	public String showHello() {
		return helloSpringService.sayHello();
	}
}
