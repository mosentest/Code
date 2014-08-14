package org.mu.opencomm.common.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;

public class MyAuthenticationFilter extends PassThruAuthenticationFilter {

	@Override
	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			if (httpRequest.getHeader("x-requested-with") != null
					&& httpRequest.getHeader("x-requested-with")
							.equalsIgnoreCase("XMLHttpRequest")) {
				httpResponse.setStatus(200);
				httpResponse.setHeader("sessionStatus", "timeout");
			}
		} else
			super.redirectToLogin(request, response);
	}

}
