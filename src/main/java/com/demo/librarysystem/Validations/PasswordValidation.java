package com.demo.librarysystem.Validations;

public class PasswordValidation {


    public boolean isValidPassword(String password){

        boolean isValid = true;
        if(password.length() < 8 || password.length() > 15){
            System.out.println("Should have characters between 8 and 15");
            isValid = false;
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if(!password.matches(upperCaseChars)){
            System.out.println("Password sgould have atleast one upper case character");
            isValid = false;
        }

        String lowerCaseChars = "(.*[a-z].*)";
        if(!password.matches(lowerCaseChars)){
            System.out.println("Password should have atleast one lower case character");
            isValid = false;
        }

        String numbers = "(.*[0-9].*)";
        if(!password.matches(numbers)){
            System.out.println("Password should have atleast one number");
            isValid = false;
        }

        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            System.out.println("Password should have atleast one special character");
            isValid = false;
        }
        return isValid;
    }
}
