package com.pala.cleevio.demo.dto.validators.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.pala.cleevio.demo.dto.validators.Base64Validator;

/**
 * Annotation for Base64 format validation. Uses <code>Base64Validator</code> class.
 */
@Constraint(validatedBy = Base64Validator.class)  
@Retention(RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
public @interface ValidBase64 {  
    
	//error message  
    public String message() default "Invalid Base64 format";  
    
    public Class<?>[] groups() default {};  
      
    public Class<? extends Payload>[] payload() default {};  
}  
