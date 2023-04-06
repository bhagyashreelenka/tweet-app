package com.tweetapp.service;

import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.model.Likes;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.repository.LikesCheckRepository;
import com.tweetapp.repository.LikesRepository;
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

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * The type Like service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LikeServiceTest {


	/**
	 * The Like service.
	 */
	@InjectMocks
	LikesService likeService;

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

	/**
	 * The Likes repo.
	 */
	@MockBean
	LikesRepository likesRepo;

	/**
	 * The Likecheck repo.
	 */
	@MockBean
	LikesCheckRepository likecheckRepo;
	private Users user,resetPasswordUser;
	private Tweet tweet;
	private Likes like;

	/**
	 * Sets up.
	 */
	@BeforeEach
	void setUp() {
		like = new Likes(12,200);
		user = new Users( "Prathyusha", "G", "prathyusha@gmail.com","Prathyusha", "password", "1234567890");
		 tweet = new Tweet(100, "Prathyusha","Hello",new Date());
		 resetPasswordUser  = new Users( "Prathyusha", "G", "prathyusha@gmail.com","Prathyusha", "newpassword", "1234567890");
	}


	/**
	 * Gets likes count.
	 *
	 * @throws Exception the exception
	 */
	@Test
@DisplayName("Test getLikesCount()")
public void testgetLikesCount() throws Exception {
	when(likesRepo.getLikeById(12)).thenReturn(like);
	
	assertThat(likeService.getLikesCount(12).getLikes()).isEqualTo(200);
	
}

	/**
	 * Gets all likes.
	 *
	 * @throws Exception the exception
	 */
	@Test
@DisplayName("Test getAllLikes()")
public void testgetAllLikes() throws Exception {
	when(likesRepo.findAll()).thenReturn(List.of(like));
	
	assertThat(likeService.getAll()).hasSize(1);
	
}

	/**
	 * Testcheck user valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
@DisplayName("Test likeTweetById() with valid tweetId")
public void testcheckUserValid() throws Exception {

	when(userRepo.findAll()).thenReturn(List.of(user));
	
	assertThat(likeService.check(100, "kalyani")).isEqualTo(false);
	
}


	/**
	 * Testupdate likes valid.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test likeTweetById() with valid tweetId")
	public void testupdateLikesValid() throws Exception {
	
		when(userRepo.findByloginId("kalyani")).thenReturn(user);
		
		assertThat(likeService.updateLikes(100, "kalyani", like)).isNull();;
		
	}

	/**
	 * Test delete byid.
	 */
	@Test
	@DisplayName("Test likeTweetById() with invalid tweetId")
	public void testDeleteByid() {
		assertThat(likesRepo.deleteById(100)).isNull();
	}

}
