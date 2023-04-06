package com.tweetapp.service;

import com.tweetapp.exception.NoUserException;
import com.tweetapp.exception.UserAlreadyPresentException;
import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


/**
 * The type User service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	/**
	 * The User service.
	 */
	@InjectMocks
	UserService userService;

	/**
	 * The User repo.
	 */
	@MockBean
	UserRepository userRepo;

	private Users user,resetPasswordUser;
	private Tweet tweet;


	/**
	 * Sets up.
	 */
	@BeforeEach
	void setUp() {
		
		user = new Users( "Prathyusha", "M", "prathyusha@gmail.com","Prathyusha", "password", "1234567890");
		 tweet = new Tweet(100, "Prathyusha","Hello",new Date());
		 resetPasswordUser  = new Users( "Prathyusha", "M", "Prathyusha@gmail.com","Prathyusha", "newpassword", "1234567890");
	}


	/**
	 * Test register user exists.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test registerUser() with valid user")
	public void testRegisterUserExists() throws Exception {
		user = new Users( "krithvik", "M", "krithvik@gmail.com","krithvik", "password", "1234567890");
		when(userRepo.save(user)).thenReturn(user);
	}
	

//	/********************************************  loginUser()  ********************************************************/


	/**
	 * Test login user valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test loginUser() with valid user")
	public void testLoginUserValid() throws Exception {
		when(userRepo.findByloginId("Prathyusha")).thenReturn(user);
		assertThat(userService.authenticate("Prathyusha", "password")).isEqualTo(true);
		
	}

	/**
	 * Test update password user valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test resetPasswordUser() with valid user")
	public void testUpdatePasswordUserValid() throws Exception {
		when(userRepo.findByloginId("kalyani")).thenReturn(user);
		assertThat(userService.updatePassword("kalyani",resetPasswordUser)).isNull();
	
	}
	

//	/*******************************************  findAllUsers()  ************************************************/

	/**
	 * Test find all users valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test findAllUsers()")
	public void testFindAllUsersValid() throws Exception {
		when(userRepo.findAll()).thenReturn(List.of(user));
		assertThat(userService.getAllUsers()).hasSize(1);
	
	}

	/**
	 * Testsearch by username valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test searchByUsername()")
	public void testsearchByUsernameValid() throws Exception {
		when(userRepo.searchByRegex("va")).thenReturn(List.of(user));
		assertThat(userService.searchByRegex("va")).hasSize(1);

	}

	
}
