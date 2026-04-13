/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;


import java.util.regex.Pattern;
import java.util.Scanner;



/**
 *
 * @author Student
 */
 class Login {
     
    private String storedUsername;
    private String storedPassword;
    private String storedCellPhone;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String pattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        return Pattern.matches(pattern, password);
    }

    public boolean checkCellPhoneNumber(String cellPhone) {
        String pattern = "^\\+27\\d{9}$";
        return Pattern.matches(pattern, cellPhone);
    }

    public String registerUser(String username, String password, String cellPhone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } else {
            System.out.println("Username successfully captured.");
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else {
            System.out.println("Password successfully captured.");
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        } else {
            System.out.println("Cell phone number successfully added.");
        }

        storedUsername = username;
        storedPassword = password;
        storedCellPhone = cellPhone;

        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }    }

    
}

public class QuickChat {

   public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        Login user = new Login(firstName, lastName);

        // METHODREGISTRATION
        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Phone (+27...): ");
        String cellPhone = input.nextLine();

        String registrationMessage = user.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        // METHODLOGIN
        if (registrationMessage.equals("User successfully registered.")) {

        System.out.print("\nLogin Username: ");
        String loginUsername = input.nextLine();

        System.out.print("Login Password: ");
        String loginPassword = input.nextLine();

        boolean status = user.loginUser(loginUsername, loginPassword);
        System.out.println(user.returnLoginStatus(status));
        }

        input.close();
    }
}
