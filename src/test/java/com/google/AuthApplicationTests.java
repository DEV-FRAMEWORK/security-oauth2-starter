package com.google;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAuthorization(){
	Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
	String result = encoder.encode("myPassword");
	assertTrue(encoder.matches("myPassword", result));
	}	
}
