package com.tweetapp.service;

import com.tweetapp.exception.TweetNotFoundException;
import com.tweetapp.model.Comments;
import com.tweetapp.repository.CommentsRepository;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;
import org.assertj.core.api.Assertions;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * The type Comment service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CommentServiceTest {


	/**
	 * The Comment service.
	 */
	@InjectMocks
	CommentService commentService;

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
	 * The Comments repo.
	 */
	@MockBean
	CommentsRepository commentsRepo;
	
	
	
	private Comments comment;

	/**
	 * Sets up.
	 */
	@BeforeEach
	void setUp() {
	
		comment = new Comments("Hello",100,new Date(),"kalyani");
		
	}


	/**
	 * Testpost comment.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test replyTweetById() with valid tweetId")
	public void testpostComment() throws Exception {
	
		when(commentsRepo.save(comment)).thenReturn(comment);
		Assertions.assertThat(commentService.postComment(comment).getLoginId()).isEqualTo("kalyani");
		
	}


	/**
	 * Testget all.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@DisplayName("Test replyTweetById() with invalid tweetId")
	public void testgetAll() throws Exception {
		when(commentsRepo.getAllBytweetId(100, Sort.by(Sort.Direction.DESC, "date"))).thenReturn(List.of(comment));
		Assertions.assertThat(commentService.getAll(100)).isEqualTo(List.of(comment));
	}


}
