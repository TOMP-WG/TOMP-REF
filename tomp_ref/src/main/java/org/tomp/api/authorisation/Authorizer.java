package org.tomp.api.authorisation;

import javax.servlet.http.HttpServletRequest;

public interface Authorizer {

	void autorize(HttpServletRequest request);

}
