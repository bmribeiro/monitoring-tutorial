package com.ribeiro.bruno.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ribeiro.bruno.entity.Check;
import com.ribeiro.bruno.service.CheckService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
public class CheckListController {
	
	@ManagedProperty("#{checkService}")
	private CheckService checkService;
	
	private List<Check> checks;
	
	@PostConstruct
	public void loadChecks() {
		checks = checkService.findAll();
	}

}
