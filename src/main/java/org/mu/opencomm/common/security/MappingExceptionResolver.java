package org.mu.opencomm.common.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.mu.opencomm.common.constants.VariableConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			ModelAndView mv = getModelAndView(viewName, ex, request);
			if (ex instanceof UnauthorizedException) {
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with")
								.equalsIgnoreCase("XMLHttpRequest")) {
					response.setStatus(200);
					response.setHeader("sessionStatus", "unauthorized");
				}
				mv.addObject("message", "ACCESS_DENIED");
			}
			request.getSession().setAttribute(VariableConstants.ERROR_ATTRIBUTE, "");
			return new ModelAndView("error/access");
		} else {
			return null;
		}
	}
}
