package org.tomp.api.authentication;

public class AuthenticationException extends org.springframework.security.core.AuthenticationException {

	private static final long serialVersionUID = 465573297278193239L;

	public AuthenticationException(String msg) {
		super(msg);
	}


}
