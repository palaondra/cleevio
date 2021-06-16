package com.pala.cleevio.demo.dto.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pala.cleevio.demo.dto.validators.annotations.ValidBase64;

/**
 * Validate if incoming <code>value</code> is correct Base64 format.
 */
public class Base64Validator implements ConstraintValidator<ValidBase64,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			java.util.Base64.getDecoder().decode(value);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		
		return true;
	}

}
