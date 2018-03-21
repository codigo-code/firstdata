package com.fd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {

	@RequestMapping(value = "/validCard")
	public String frontEnd() {

		return "validCard";
	}
}
