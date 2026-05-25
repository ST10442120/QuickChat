/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

//package actionlogin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuickChatTest {

    Login login = new Login("John", "Doe");

    @Test
    void testUsernameCorrect() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    void testUsernameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    void testPasswordValid() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    void testPasswordInvalid() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    void testCellPhoneValid() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    void testCellPhoneInvalid() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    void testLoginSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginFail() {
        assertFalse(login.loginUser("wrong", "wrong"));
    }
}