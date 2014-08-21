package org.mu.opencomm.code.controller;

import org.mu.opencomm.common.controller.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController implements GenericController {

	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index(ModelMap modelMap) {

		return new ModelAndView("admin/index", modelMap);
	}
}
