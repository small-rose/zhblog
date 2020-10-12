package com.zzy.blog.web.common.exception;

public class BussException extends Exception {

	private static final long serialVersionUID = -1159415994299403806L;

	public BussException() {
		super();
	}

	public BussException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BussException(String message, Throwable cause) {
		super(message, cause);
	}

	public BussException(String message) {
		super(message);
	}

	public BussException(Throwable cause) {
		super(cause);
	}
	
}
