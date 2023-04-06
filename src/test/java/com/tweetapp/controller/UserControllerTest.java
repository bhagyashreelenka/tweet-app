package com.tweetapp.controller;

import com.tweetapp.model.Users;
import com.tweetapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The type User controller test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;

    /**
     * Context loads.
     *
     * @throws Exception the exception
     */
    @Test
	public void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}
	@Mock
	private Users user;
	
	@Mock
	private UserService userService;

    /**
     * Sets up.
     */
    @BeforeEach
	 public void setUp()
	 {
		 user=new Users("kalyani","M","kalyani@gmail.com","kalyani","password","1111111111");
		
	 }

    /**
     * Register user.
     *
     * @throws Exception the exception
     */
    @Test
	public void registerUser() throws Exception{
		ResponseEntity<?> responseEntity = null;
		when(userService.register(user)).thenReturn(user);
		responseEntity = userController.register(user);
		assertEquals(responseEntity.getStatusCodeValue(),201);
	}

    /**
     * Authentication success test.
     *
     * @throws Exception the exception
     */
    @Test
	public void authenticationSuccessTest() throws Exception{
		when(userService.authenticate(user.getLoginId(),user.getPassword())).thenReturn(true);
		
		assertEquals(userController.authencticate(user.getLoginId(), user.getPassword()),true);
	}

    /**
     * Authentication failure test.
     *
     * @throws Exception the exception
     */
    @Test
	public void authenticationFailureTest() throws Exception{
		when(userService.authenticate(user.getLoginId(),"kalyani")).thenReturn(false);
		
		assertEquals(userController.authencticate(user.getLoginId(),"kalyani"),false);
	}

    /**
     * Gets all user test.
     *
     * @throws Exception the exception
     */
    @Test
	public void getAllUserTest() throws Exception{
		 List<Users> userList = new ArrayList<Users>();
		Users user1 = new Users("krithvik","N","krithvik@gmail.com","krithvik","password","222222222");
		Users user2 = new Users("Sushmitha","M","Sushmitha@gmail.com","Sushmitha","password","222222222");
		 userList.add(user1);
		 userList.add(user2);
		 when(userService.getAllUsers()).thenReturn(userList);
		 assertEquals( userController.getAllUsers().size(),2);
		
	}

    /**
     * Search by regex test.
     *
     * @throws Exception the exception
     */
    @Test
	public void searchByRegexTest() throws Exception{
		List<Users> userList = new ArrayList<>();
		Users user1 = new Users("krithvik","N","krithvik@gmail.com","krithvik","password","222222222");
		Users user2 = new Users("Sushmitha","M","Sushmitha@gmail.com","Sushmitha","password","222222222");
		userList.add(user1);
		userList.add(user2);
		when(userService.searchByRegex("h")).thenReturn(userList);
		assertEquals( userController.searchByRegex("h").size(),2);
	}

    /**
     * Gets user test.
     *
     * @throws Exception the exception
     */
    @Test
	public void getUserTest() throws Exception{
		when(userService.getUser(user.getLoginId())).thenReturn(user);
		assertEquals(userController.getUser(user.getLoginId()).getLoginId(),"kalyani");
	}

    /**
     * Update password test.
     *
     * @throws Exception the exception
     */
    @Test
	public void updatePasswordTest() throws Exception{
		
		ResponseEntity<Users> responseEntity = null;
		responseEntity = userController.updatePassword(user.getLoginId(), user);
		assertEquals(responseEntity.getStatusCodeValue(),200);

	}

}
