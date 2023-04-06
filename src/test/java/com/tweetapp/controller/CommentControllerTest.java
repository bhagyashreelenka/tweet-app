package com.tweetapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.model.Comments;
import com.tweetapp.model.Users;
import com.tweetapp.service.CommentService;
import com.tweetapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * The type Comment controller test.
 */
@WebMvcTest(value = CommentsController.class)
class CommentControllerTest {
    /**
     * The Mock mvc.
     */
    @Autowired
	MockMvc mockMvc;

    /**
     * The Object mapper.
     */
    @Autowired
	ObjectMapper objectMapper;

    /**
     * The User service.
     */
    @MockBean
	UserService userService;

    /**
     * The Comment service.
     */
    @MockBean
	CommentService commentService;
	
	@MockBean
	private Users user;

	@MockBean
	private Comments comment;
	
	private Date date;

    /**
     * Sets up.
     */
    @BeforeEach
	void setUp() {
		 date = new Date();
		user = new Users("kalyani", "kalyani", "M", "kalyani@gmail.com", "password", "1234567890");
		comment = new Comments("Hello",100,new Date(),"kalyani");
	}

    /**
     * Test mock mvc not null.
     */
    @Test
	@DisplayName("Test Mock MVC ")
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

    /******************************************************  postTweetByUser()  @throws Exception   @throws Exception the exception*/


    @Test
	@DisplayName("Test getAll()")
	public void getAll() throws Exception {
		when(commentService.postComment(comment)).thenReturn(comment);
		this.mockMvc.perform(get("/api/v1.0/tweets/comments/{tweetId}","100"))
				.andExpect(status().isOk());
		
	}

}
