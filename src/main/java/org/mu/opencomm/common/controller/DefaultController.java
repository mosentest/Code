package org.mu.opencomm.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefaultController implements GenericController {

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, ModelMap model) {
		return new ModelAndView("home", model);
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView homee() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, ModelMap model) {
		return new ModelAndView("login", model);
	}
}
