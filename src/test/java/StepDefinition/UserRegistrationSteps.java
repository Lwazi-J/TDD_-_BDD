package StepDefinition;

import User.UserService;
import User.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class UserRegistrationSteps {
    private UserService userService = new UserService();
    private String email;
    private String password;
    private User registeredUser;
    private Exception registrationException;

    @Given("I have a valid email {string}")
    public void iHaveAValidEmail(String email) {
        this.email = email;
    }

    @Given("I have a valid password {string}")
    public void iHaveAValidPassword(String password) {
        this.password = password;
    }

    @Given("I have an invalid email {string}")
    public void iHaveAnInvalidEmail(String email) {
        this.email = email;
    }

    @Given("I have an invalid password {string}")
    public void iHaveAnInvalidPassword(String password) {
        this.password = password;
    }

    @When("I register a new account")
    public void iRegisterANewAccount() {
        try {
            registeredUser = userService.registerUser(email, password);
            registrationException = null;
        } catch (Exception e) {
            registrationException = e;
        }
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        assertNull(registrationException);
        assertNotNull(registeredUser);
    }

    @Then("the user account should be active")
    public void theUserAccountShouldBeActive() {
        assertTrue(registeredUser.isActive());
    }

    @Then("the registration should fail with message {string}")
    public void theRegistrationShouldFailWithMessage(String message) {
        assertNotNull(registrationException);
        assertEquals(message, registrationException.getMessage());
    }
}
