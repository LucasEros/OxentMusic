package br.com.oxentmusic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.oxentmusic.validator.NotEqualsEmailValidator;

@Constraint(validatedBy = NotEqualsEmailValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEqualsEmail {
	
	String message() default "Email ja registrado!";

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; 


}
