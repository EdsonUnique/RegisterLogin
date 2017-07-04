package exception;

import org.omg.CORBA.UserException;

public class UserExistsException extends UserException {

	public UserExistsException() {
	}

	public UserExistsException(String reason) {
		super(reason);
	}

}
