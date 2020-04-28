package org.tomp.api.authentication;

import java.security.Principal;


public class TompPrincipal implements Principal {

	private String thumbprint;
	
	public TompPrincipal(String thumbprint) {
		this.setThumbprint(thumbprint);
	}
	@Override
	public String getName() {
		return getThumbprint();
	}
	public String getThumbprint() {
		return thumbprint;
	}
	public void setThumbprint(String thumbprint) {
		this.thumbprint = thumbprint;
	}

}
