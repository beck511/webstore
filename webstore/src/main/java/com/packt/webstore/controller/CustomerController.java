package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.*;
import com.packt.webstore.service.impl.CustomerServiceImpl;

public class CustomerController {
	@Controller
	public class HomeController {

	  @RequestMapping("/webstore/customers")
	  public void list(Model model) {
		  Customer
	  }
	}
}
