package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		User user = (User)arg0;
		if(!StringUtils.hasLength(user.getUserId())) {
			arg1.rejectValue("userId", "error.required");
		}
		if(!StringUtils.hasLength(user.getPassword())) {
			arg1.rejectValue("password", "error.reuired");
		}
		if(arg1.hasErrors()) {
			arg1.reject("error.input.user");
		}
	}

}
