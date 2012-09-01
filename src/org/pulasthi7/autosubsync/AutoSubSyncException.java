package org.pulasthi7.autosubsync;

public class AutoSubSyncException extends Exception {
	private static final long serialVersionUID = 1813703866951325418L;
		
	public AutoSubSyncException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AutoSubSyncException(String message) {
		super(message);
	}	
}
