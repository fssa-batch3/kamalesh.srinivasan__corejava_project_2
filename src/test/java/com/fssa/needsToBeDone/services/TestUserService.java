package com.fssa.needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.UserService;

class TestUserService {

    private UserService userService;
 
    @BeforeEach
    void setUp() {
        userService = new UserService(); 
    }
 
    @Test
    void testRegisterValidUser() {

    	LocalDate date = LocalDate.of(2003, 8, 6);
        User validUser = new User("karthi"+System.nanoTime()+"@gmail.com","Test@123","Kamalesh","Srinivasan",true,9878656754l,date,876567843564l,"Chennai");
        try {
            assertTrue(userService.registerUser(validUser));
        } catch (ServiceException e) {
            fail("ServiceException occurred: " + e.getMessage());
        }
    } 
 
    @Test
    void testRegisterInvalidUser() {
    	LocalDate date = LocalDate.of(2003, 8, 6);
        User invalidUser = new User("karthi@gmail.com","Test@123","Kamalesh","Srinivasan",true,9878656754l,date,876567843564l,"Chennai");
        ServiceException result = assertThrows(ServiceException.class, () -> userService.registerUser(invalidUser));
        assertEquals("Email already exist!!!", result.getMessage());
    }

    @Test
    void testLogInValidUser() {
        User validUser = new User("kamalesh.srinivasan@fssa.freshworks.com","Test@123");
        try {
            User loggedInUser = userService.logInUser(validUser);
            System.out.println(loggedInUser);
            assertNotNull(loggedInUser);
        } catch (ServiceException e) {
            fail("ServiceException occurred: " + e.getMessage());
        }
    }
    
    
    @Test
    void testLogInInValidUserNotRegister() {
    	User invalidUser = new User("karthi404@gmail.com","Test1234");
        ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(invalidUser));
        assertEquals("User is not registered", result.getMessage());
    }

    @Test
    void testLogInInvalidUser() {
        User invalidUser = new User("karthi@gmail.com","Test1234");
        ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(invalidUser));
        assertEquals("Login Faild - password mismatch", result.getMessage());
    }
}