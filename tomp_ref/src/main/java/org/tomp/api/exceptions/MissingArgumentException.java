package org.tomp.api.exceptions;

public class MissingArgumentException extends RuntimeException {

	private static final long serialVersionUID = -3443398319953659611L;
	private String requiredArgument;

	public MissingArgumentException(String requiredArgument) {
		this.setRequiredArgument(requiredArgument);
	}

	public String getRequiredArgument() {
		return requiredArgument;
	}

	public void setRequiredArgument(String requiredArgument) {
		this.requiredArgument = requiredArgument;
	}
	
	@Override
	public String getMessage() {
		return "Missing argument: " + requiredArgument;
	}

}
