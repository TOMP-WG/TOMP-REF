package org.tomp.api.authorisation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.tomp.api.utils.HeaderValidator;

public class AuthorizationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HeaderValidator.validateHeader(request);
		Authorizer authorizer = getAuthorizer(request);
		authorizer.autorize(request);

		return true;
	}

	private Authorizer getAuthorizer(HttpServletRequest request) {
		return new Authorizer() {
			@Override
			public void autorize(HttpServletRequest request) {

			}
		};
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Authorizer authorizer = getAuthorizer(request);
		authorizer.autorize(request);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Authorizer authorizer = getAuthorizer(request);
		authorizer.autorize(request);
	}
}
