package com.tweetapp.service;

import com.tweetapp.exception.TweetNotFoundException;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * The type Tweet service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TweetServiceTest {


	/**
	 * The Tweet service.
	 */
	@InjectMocks
	TweetService tweetService;

	/**
	 * The User repo.
	 */
	@MockBean
	UserRepository userRepo;

	/**
	 * The Tweet repo.
	 */
	@MockBean
	TweetRepository tweetRepo;


	private Users user,resetPasswordUser;
	private Tweet tweet;


	/**
	 * Sets up.
	 */
	@BeforeEach
	void setUp() {
		
		user = new Users( "kalyani", "M", "kalyani@gmail.com","kalyani", "password", "1234567890");
		 tweet = new Tweet(100, "kalyani","Hello",new Date());
		 resetPasswordUser  = new Users( "kalyani", "M", "kalyani@gmail.com","kalyani", "newpassword", "1234567890");
	}


	/***************************************************  postTweetByUser() @throws Exception */
	@Test
	@DisplayName("Test postTweetByUser()")
	public void testPostTweetByUserValid()  {
			when(tweetRepo.save(tweet)).thenReturn(tweet);
		
		
	}


	/**
	 * Gets get all tweets.
	 *
	 * @throws TweetNotFoundException the tweet not found exception
	 */
	@Test
	@DisplayName("Test getAllTweets()")
	public void testGetAllTweets() throws TweetNotFoundException {
		when(tweetRepo.findAll(Sort.by(Sort.Direction.DESC,"date"))).thenReturn(List.of(tweet));
		assertThat(tweetService.findAll()).hasSize(1);
		
	}
	
//	/*********************************************************  getAllTweetsByUser()  @throws Exception ******************************************************/

	/**
	 * Gets get all tweets by user.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test getAllTweetsByUser() valid username")
	public void testGetAllTweetsByUser() throws Exception {
	
		when(tweetRepo.findByloginId("kalyani", Sort.by(Sort.Direction.DESC, "date"))).thenReturn(List.of(tweet));
		assertThat(tweetService.findByLoginId("kalyani")).isNotNull();
	
	}

	/**
	 * Test delete tweet by id valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test deleteTweetById() with valid tweetId")
	public void testDeleteTweetByIdValid() throws Exception {
		when(tweetRepo.findById(100l)).thenReturn(Optional.of(tweet));
		
	}

	/**
	 * Test update tweet valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test updateTweet()")
	public void testUpdateTweetValid() throws Exception {
		when(tweetRepo.save(tweet)).thenReturn(tweet);
		
		assertThat(tweetService.updateTweet(100,tweet)).isNotNull();
		
	}

	/**
	 * Test delete tweet by id invalid tweet id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test deleteTweetById() with invalid tweetId")
	public void testDeleteTweetByIdInvalidTweetId() throws Exception {
		when(tweetRepo.findById(101l)).thenReturn(Optional.empty());
		
	}

}
