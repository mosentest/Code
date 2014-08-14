package org.mu.opencomm.code.controller;

import org.mu.opencomm.code.service.JarFileService;
import org.mu.opencomm.common.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/java/")
public class JavaController implements GenericController {
	
	@Autowired
	private JarFileService jarFileService;
	
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView home(
			@RequestParam(value = "pn", required = false) Integer pn,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
			ModelMap model) {
		model.put("page", jarFileService.getJarFiles(pn, size));
		return new ModelAndView("resource/libs", model);
	}
	
	@RequestMapping(value = "libs.html", method = RequestMethod.GET)
	public ModelAndView libs(
			@RequestParam(value = "pn", required = false, defaultValue = "0") Integer pn,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
			ModelMap model) {
		model.put("page", jarFileService.getJarFiles(pn, size));
		return new ModelAndView("resource/libs", model);
	}

	public JarFileService getJarFileService() {
		return jarFileService;
	}

	public void setJarFileService(JarFileService jarFileService) {
		this.jarFileService = jarFileService;
	}
	
}
