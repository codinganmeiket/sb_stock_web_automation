Feature: Login

    @login-success
    Scenario: Successful login with valid credentials
        Given I am on the login page
        When I enter username "LOGIN_USERNAME"
        And I enter password "LOGIN_PASSWORD"
        And I click the login button
        Then I should be redirected to the dashboard
    
    @login-failed-invalid-username-and-password
    Scenario: Failed login because using invalid username and password
        Given I am on the login page
        When I enter username "Username"
        And I enter password "Password"
        And I click the login button
        Then I get login error message