# tweet-app
Tweet App is SPA (Single Page App) for registered users to post new tweets, reply to tweets, like/unlike tweets.
Guest users cannot see any tweets.
The core modules of tweet app are:

  1. User registration and login
  2. Post tweet
  3. View users/handles and their respective tweets


BUSINESS-REQUIREMENT:

As an application developer, develop frontend, middleware and deploy the Tweet App (Single Page App) with below guidelines:

User Story # User Story Name User Story

US_01 Registration and Login As a user I should be able to login/Register in the tweet application Acceptance criteria: 1. A logged-in user can reset their password so they can login, even if they forget their password. 2. A logged-in user: a. Cannot change their username. b. Can logout from their account. 3. As a user I should be able to furnish following details at the time of registration a. First Name b. Last Name c. Email d. Login Id e. Password f. Confirm Password g. Contact Number 4. All details fields must be mandatory 5. Login Id and Email must be unique 6. Password and Confirm Password must be same 7. If any constraint is not satisfied, validation message must be shown

US_02 Post Tweet As a user I should be able to post a tweet Acceptance criteria: a. Tweet should not go beyond 144 characters. b. Tweet can optionally be associated with a tag which should not go beyond 50 characters

US_03 View and Reply Tweet As a user I should be able to view others tweet and reply to it. Acceptance criteria: a. View others tweet and reply b. Others tweet should display original tweet with all the reply c. Tweet and reply must have user name and time of post displayed along. d. Reply should not go beyond 144 characters e. I should be optionally able to add a tag while replying



REST API (PRODUCTS & FRAMEWORKS -> COMPUTE & INTEGRATION):

 Implement HTTP methods like GET, POST, PUT, DELETE, PATCH to implement RESTful resources:

    POST /api/v1.0/tweets/register Register as new user
    GET /api/v1.0/tweets/login Login
    GET /api/v1.0/tweets/<username>/forgot Forgot password
    GET /api/v1.0/tweets/all Get all tweets
    GET /api/v1.0/tweets/users/all Get all users
    GET /api/v/1.0/tweets/user/search/username* Search by username
    GET /api/v1.0/tweets/username Get all tweets of user
    POST /api/v1.0/tweets/<username>/add Post new tweet
    PUT /api/v1.0/tweets/<username>/update/<id> Update tweet
    DELETE /api/v1.0/tweets/<username>/delete/<id> Delete tweet
    PUT /api/v1.0/tweets/<username>/like/<id> Like tweet
    POST /api/v1.0/tweets/<username>/reply/<id> Reply to tweet

