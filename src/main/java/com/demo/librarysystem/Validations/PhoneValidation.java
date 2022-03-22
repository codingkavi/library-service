package com.demo.librarysystem.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidation {
            public void isValid123(){
                String mobile = "(832)595-9501";
                Pattern p = Pattern.compile("^\\(?\\d{3}\\)?-? *\\d{3}-? *-?\\d{4}$");
                Matcher m = p.matcher(mobile);
                if(m.find()){
                    System.out.println(m.group() + " " +" is a valid mobile number");
                }
                else
                    System.out.println(mobile + " is not a valid mobile number");

            }

}
