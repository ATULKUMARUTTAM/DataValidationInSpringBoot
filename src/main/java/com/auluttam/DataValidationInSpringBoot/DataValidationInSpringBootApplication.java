package com.auluttam.DataValidationInSpringBoot;

import jakarta.validation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Set;


@SpringBootApplication
public class DataValidationInSpringBootApplication {
	public static void main(String[] args) {

	ApplicationContext ctx =   SpringApplication.run(DataValidationInSpringBootApplication.class, args);

	Student s1 = ctx.getBean(Student.class);
		Validator validator = ctx.getBean(Validator.class);

	s1.setName(null);
	s1.setDob(LocalDate.of(2025,12, 12));
	s1.setEmail("abc");
	s1.setRoll(200);
   try {
	   StudentValidator(s1, validator);
	   System.out.println(s1);
   }
   catch (Exception e)
   {
	   System.out.println(e.getMessage());
   }
	}

	public static void StudentValidator( Student s, Validator validator)
	{
		Set<ConstraintViolation<Student>> violations = validator.validate(s);
		if(violations.isEmpty())
		{
			System.out.println("Valid Student");
		}
		else
		{
			System.out.println("Invalid Student");
			for(ConstraintViolation<Student> violation: violations)
			{
				System.out.println(violation.getMessage());
			}
		}
	}


/*	private static void validateStudent(Student student, Validator validator) {
		Set<ConstraintViolation<Student>> violations = validator.validate(student);
		if (!violations.isEmpty()) {
						for (ConstraintViolation<Student> violation : violations) {
				errorMessage.append(violation.getMessage()).append("; ");
			}
			throw new ConstraintViolationException(errorMessage.toString(), violations);
		}
	}*/

}
