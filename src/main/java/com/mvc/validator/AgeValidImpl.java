package com.mvc.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidImpl implements ConstraintValidator<AgeValid, Date> {
	
	private int ageLimit = 18;
	private String dateFormat;
	  
	@Override
	public void initialize(AgeValid constraintAnnotation) {
		dateFormat = constraintAnnotation.fomart();
	}

	@Override
    public boolean isValid(Date dob, ConstraintValidatorContext context) {
		boolean isValid = false;
        try {
        	if(getAge(dob) >= ageLimit) {
        		isValid = true;
        	}
        } catch (Exception e) {
            return isValid;
        }
        return isValid;
    }
	
	//get age using dob
	private int getAge(Date dob) {                                                                             
	    DateFormat formatter = new SimpleDateFormat(dateFormat);                           
	    int d1 = Integer.parseInt(formatter.format(dob));                            
	    int d2 = Integer.parseInt(formatter.format(new Date()));                          
	    int age = (d2 - d1) / 10000;    
	    return age;                        
	}
}
