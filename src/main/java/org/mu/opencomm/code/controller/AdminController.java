package org.mu.opencomm.code.controller;

import javax.annotation.Resource;

import org.mu.opencomm.code.entity.JarFile;
import org.mu.opencomm.code.service.JarFileService;
import org.mu.opencomm.common.controller.GenericController;
import org.mu.opencomm.common.dbutil.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController implements GenericController {

	private JarFileService jarFileService;

	public JarFileService getJarFileService() {
		return jarFileService;
	}

	@Resource
	public void setJarFileService(JarFileService jarFileService) {
		this.jarFileService = jarFileService;
	}

	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index(
			@RequestParam(value = "pn", required = false, defaultValue = "0") Integer pn,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
			ModelMap modelMap) {
		Page<JarFile> jarFiles = jarFileService.getJarFiles(pn, size);
		modelMap.put("jarFiles", jarFiles);
		return new ModelAndView("admin/index", modelMap);
	}

	@RequestMapping(value = "layout.html", method = RequestMethod.GET)
	public ModelAndView layout(ModelMap modelMap) {
		return new ModelAndView("admin/layout", modelMap);
	}
}
