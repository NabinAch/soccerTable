package com.football.epl.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.epl.model.Table;
import com.football.epl.service.TableService;

@RestController
@RequestMapping("/table")
public class TableController {

	@Autowired
	TableService tableService;
	
	@GetMapping
	public ArrayList<Table> getTable(){
		return tableService.getTable();
	}
	
}
