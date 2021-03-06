package com.ribeiro.bruno.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ribeiro.bruno.entity.Check;
import com.ribeiro.bruno.service.CheckService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class CheckListController implements Serializable {

	@ManagedProperty("#{checkService}")
	private CheckService checkService;

	private List<Check> checks;

	private Check check = new Check();

	@PostConstruct
	public void loadChecks() {
		checks = checkService.findAll();
	}

	public void save() {
		checkService.save(check);
		check = new Check();
		checks = checkService.findAll();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Check Saved!", null));
	}
	
	public void remove(Check check) {
		checkService.remove(check);
		checks = checkService.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Check removed!", null));
	}
	
	public void clear() {
		check = new Check();
	}
	

}
