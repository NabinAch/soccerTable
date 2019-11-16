package com.football.epl.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.epl.model.Table;
import com.football.epl.service.TableService;
import com.football.epl.util.TableComparator;

@RestController
@RequestMapping("/table")
public class TableController {

	@Autowired
	TableService tableService;
	
	@Autowired
	TableComparator tableComparator;
	
	@GetMapping
	public ArrayList<Table> getTable(){
		ArrayList<Table> table = tableService.getTable();
		Collections.sort(table, tableComparator);
		return table;
	}
	
}
