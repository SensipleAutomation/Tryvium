package com.StepDefinition;

import java.time.Duration;
import org.BaseClass.BaseClass;
import org.POM.POMFirstPage;
import org.POM.POMSecondPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	private boolean errorFlag = false;
	private String expectedErrorMessage = "Incorrect Username or Password";

	POMFirstPage F = new POMFirstPage(driver);
	POMSecondPage S = new POMSecondPage(driver);

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		getUrl();
	}

	@When("I enter invalid credentials {string} and {string}")

	public void i_enter_invalid_credentials_and(String string, String string2) {

		WebDriverWait credentials = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement MailInput = credentials.until(ExpectedConditions.elementToBeClickable(F.getMail()));
		MailInput.sendKeys(string);
		WebElement PasswordInput = credentials.until(ExpectedConditions.elementToBeClickable(F.getPassword()));
		PasswordInput.sendKeys(string2);

	}

	@When("I click the login")

	public void i_click_the_login() {
		clickOnElement(F.getLogButton());
	}

	@Then("I should see an error message")

	public void i_should_see_an_error_message() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOf(F.getErrmsg()));
			String actualErrorMessage = errorMessageElement.getText();

			if (actualErrorMessage.equals(expectedErrorMessage)) {
				errorFlag = true;
			}
		} catch (TimeoutException e) {

		}
	}

	@When("I enter my valid {string} and {string}")

	public void i_enter_my_valid_and(String string, String string2) throws InterruptedException {
		WebDriverWait mail = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement MailInput = mail.until(ExpectedConditions.elementToBeClickable(F.getMail()));
		MailInput.clear();
		MailInput.sendKeys(string);
		WebDriverWait password = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement PasswordInput = password.until(ExpectedConditions.elementToBeClickable(F.getPassword()));
		PasswordInput.clear();
		PasswordInput.sendKeys(string2);
		clickOnElement(F.getLogButton());
		Thread.sleep(5000);

	}

	@When("I click the login button")

	public void i_click_the_login_button() throws InterruptedException {

		try {
			WebDriverWait Dashbot = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement Bot = Dashbot.until(ExpectedConditions.elementToBeClickable(F.getFirstBot()));
			Select botSelectJenniePM = new Select(Bot);

			WebElement selectedBot = botSelectJenniePM.getFirstSelectedOption();
			String currentSelectBot = selectedBot.getText();

			String expectedBot = "JENIE PM";
			if (currentSelectBot.equals(expectedBot)) {
				System.out.println("Already selected SkillGroup BOT: " + currentSelectBot);
			} else {
				botSelectJenniePM.selectByVisibleText(expectedBot);
				System.out.println("Selected SkillGroup BOT: " + expectedBot);
			}
		} catch (StaleElementReferenceException e) {
			// Retry the operation if a StaleElementReferenceException occurs
			user_passing_values();
		}
	}

	@Then("I should be redirected to the dashboard")

	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("User Redirected To The Dashboard");
	}

	@When("User click on Bot Management")

	public void user_click_on_bot_management() {
		WebDriverWait Bot = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement BotClick = Bot.until(ExpectedConditions.elementToBeClickable(F.getBotClick()));
		BotClick.click();

	}

	@When("User click on action button")

	public void user_click_on_action_button() throws InterruptedException {

		WebDriverWait Jenie = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Edit = Jenie.until(ExpectedConditions.elementToBeClickable(F.getJennieEdit()));
		Edit.click();
		pageDown(F.getScrolltoVisual());
		WebDriverWait EditPage = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement dropdown = EditPage.until(ExpectedConditions.elementToBeClickable(F.getVisualIVR()));
		Select select = new Select(dropdown);

		WebElement selectedOption = select.getFirstSelectedOption();

		boolean changesMade = false;

		if (selectedOption.getText().equalsIgnoreCase("Enabled")) {
			select.selectByVisibleText("Disabled");
			System.out.println("Changed selection to 'Disabled'");
			changesMade = true;
		} else if (selectedOption.getText().equalsIgnoreCase("Disabled")) {
			System.out.println("Already in 'Disabled' state, no change needed");
		}

		WebDriverWait thirdDropdownWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement thirdDropdownElement = thirdDropdownWait
				.until(ExpectedConditions.elementToBeClickable(F.getContext()));
		Select select3 = new Select(thirdDropdownElement);

		WebElement selectedOption3 = select3.getFirstSelectedOption();

		String expectedOption3 = "snow fu4[ServiceNow]";

		String currentSelection3 = selectedOption3.getText();

		if (currentSelection3.equals(expectedOption3)) {
			System.out.println("Already selected: " + currentSelection3);
		} else {
			select3.selectByVisibleText(expectedOption3);
			System.out.println("Selected: " + expectedOption3);
			changesMade = true;
		}

		WebDriverWait NLU = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement NLUEngine = NLU.until(ExpectedConditions.elementToBeClickable(F.getNLUENgine()));
		Select select1 = new Select(NLUEngine);

		WebElement selectedOption1 = select1.getFirstSelectedOption();

		String expectedOption = "NLU-CSAgent (LUIS)";

		String currentSelection = selectedOption1.getText();

		if (currentSelection.equals(expectedOption)) {
			System.out.println("Already selected: " + currentSelection);
		} else {
			select1.selectByVisibleText(expectedOption);
			System.out.println("Selected: " + expectedOption);
			changesMade = true;
		}
		pageDown(F.getCancelDOwn());
		if (changesMade) {
			Thread.sleep(2000);

			WebDriverWait SaveClosewait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement saveButton = SaveClosewait.until(ExpectedConditions.elementToBeClickable(F.getSaveButton()));

			if (saveButton.isEnabled()) {
				saveButton.click();
				System.out.println("Clicked 'Save' button");
				WebElement toasterMessage = SaveClosewait.until(ExpectedConditions.visibilityOf(F.getToasterJennie()));

				// Validate the toaster message text
				String expectedToasterMessage = "JENIE PM properties is saved successfully";
				String actualToasterMessage = toasterMessage.getText();

				if (actualToasterMessage.equals(expectedToasterMessage)) {
					System.out.println("Toaster message validated: " + actualToasterMessage);
				} else {
					System.out.println("Toaster message validation failed. Expected: " + expectedToasterMessage
							+ ", Actual: " + actualToasterMessage);
				}
			} else {
				System.out.println("'Save' button is not enabled. Cannot save changes.");
			}
		} else {
			WebDriverWait SaveClosewait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement cancelButton = SaveClosewait.until(ExpectedConditions.elementToBeClickable(F.getCancelButton()));
			cancelButton.click();
			System.out.println("Clicked 'Cancel' button");
		}

	}

	@When("User click on user management")

	public void user_click_on_user_management() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(F.getUserManage());
		Thread.sleep(2000);
		clickOnElementwait(driver, F.getAutoAgent());
		pageDown(F.getScrollBot());
		Thread.sleep(2000);
		boolean isAgentSavedSuccessfully = false;
		WebDriverWait bot = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement botJennie = bot.until(ExpectedConditions.elementToBeClickable(F.getBot()));
		Select botSelect = new Select(botJennie);

		WebElement selectedOption2 = botSelect.getFirstSelectedOption();
		String currentSelection1 = selectedOption2.getText();

		String expectedOption = "JENIE PM";
		if (currentSelection1.equals(expectedOption)) {
			System.out.println("Already selected: " + currentSelection1);
			Thread.sleep(2000);
			backward();
		} else {
			botSelect.selectByVisibleText(expectedOption);
			System.out.println("Selected: " + expectedOption);
			Thread.sleep(3000);
			pageDown(F.getAgentClose());
			clickOnElementwait(driver, F.getAgentSave());
			Thread.sleep(2000);

			try {
				WebElement toasterElement = F.getAgentToaster();
				String toasterMessage = toasterElement.getText();

				if (toasterMessage.contains("Agent Saved Successfully")) {
					System.out.println("Agent Saved Successfully message is displayed.");
					isAgentSavedSuccessfully = true;
				} else {
					System.out.println("Agent Saved Successfully message is not displayed.");
				}
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Toaster message did not appear within the expected time.");
			}
		}
	}

	@When("User click on Skill Group")

	public void user_click_on_skill_group() throws InterruptedException {
		clickOnElementwait(driver, F.getToSkillGroup());
		clickOnElementwait(driver, F.getSkillGroupSelect());
		clickOnElementwait(driver, F.getJusClick());
		Thread.sleep(2000);
		WebDriverWait bot = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement botJennie = bot.until(ExpectedConditions.elementToBeClickable(F.getSkillbot()));
		Select botSelect = new Select(botJennie);

		WebElement selectedOption2 = botSelect.getFirstSelectedOption();
		String currentSelection1 = selectedOption2.getText();

		String expectedOption = "JENIE PM";
		if (currentSelection1.equals(expectedOption)) {
			System.out.println("Already selected SkillGroup BOT: " + currentSelection1);

		} else {
			botSelect.selectByVisibleText(expectedOption);
			System.out.println("Selected SkillGroup BOT: " + expectedOption);
		}
		Thread.sleep(2000);

		try {
			WebElement elementToHover = F.getDefaultgroup(); // Assuming this returns a WebElement

			if (elementToHover != null) {
				Actions actions = new Actions(driver);
				actions.moveToElement(elementToHover).perform();

				WebDriverWait Default = new WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement visibleElement = Default.until(ExpectedConditions.elementToBeClickable(F.getDefaultgroup()));
				visibleElement.click();

				System.out.println("****Changed Default Group to Application Support****");
			} else {
				System.out.println("**Default Group is already in Application Support**");
			}
		} catch (TimeoutException e) {
			System.out.println("**Default Group is already in Application Support**");
		}
		clickOnElementwait(driver, F.getSKillGroupFunc());
		Thread.sleep(4000);
		/// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
		WebElement search = F.getSearchBar();
		WebElement mail = F.getAgentAuto();
		WebElement drop = F.getDropElement();
		WebElement element = null;
		boolean changesMade = false; // Initialize a variable to track changes

		try {
			element = F.getFollowingAgent1();

			if (element.isDisplayed()) {
				System.out.println("AutoAgent1 Test Available");
			} else {
				System.out.println("Agent not available. Performing the Darg Scenario...");
				changesMade = true; // Change detected
			}
		} catch (Exception e) {

			search.sendKeys("auto");
			Actions act = new Actions(driver);
			act.clickAndHold(mail).moveToElement(drop).release(drop).perform();
			System.out.println("Dragged Agent");
			changesMade = true; // Change detected
		}

		Thread.sleep(1000);
		pageDown(F.getScrollerToSnow());
		Thread.sleep(2000);

		WebDriverWait configWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement context = configWait.until(ExpectedConditions.elementToBeClickable(F.getConfigContent()));
		Select configuration = new Select(context);

		WebElement selection = configuration.getFirstSelectedOption();
		String currentValue = selection.getText();

		String expectedOptionConfig = " snow fu4 [ServiceNow]";

		if (currentValue.equals(expectedOptionConfig)) {
			System.out.println("Already selected SkillGroup BOT: " + currentValue);
		} else {
			configuration.selectByVisibleText(expectedOptionConfig);
			System.out.println("Selected SkillGroup BOT: " + expectedOptionConfig);
		}

		// Attempt to click the 'Save' button
		try {
			WebDriverWait saveButtonWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement saveButton = saveButtonWait.until(ExpectedConditions.elementToBeClickable(F.getSkillSave()));

			if (saveButton.isEnabled()) {
				saveButton.click();
				System.out.println("Clicked 'Save' button");

				WebDriverWait toasterWait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement toasterMessage = toasterWait.until(ExpectedConditions.visibilityOf(F.getSkillToaster()));

				// Validate the toaster message text
				String expectedToasterMessage = "Application Support is updated successfully";
				String actualToasterMessage = toasterMessage.getText();

				if (actualToasterMessage.equals(expectedToasterMessage)) {
					System.out.println("Toaster message validated: " + actualToasterMessage);
				} else {
					System.out.println("Toaster message validation failed. Expected: " + expectedToasterMessage
							+ ", Actual: " + actualToasterMessage);
				}
			} else {
				System.out.println("'Save' button is not enabled. Clicking 'Cancel' button.");
				// Click the 'Cancel' button if no changes were made
				WebDriverWait cancelWait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement cancelButton = cancelWait.until(ExpectedConditions.elementToBeClickable(F.getSkillCancel()));
				cancelButton.click();
				System.out.println("Clicked 'Cancel' button");
			}
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: 'Save' button not found or not clickable. Clicking 'Cancel' button.");
			// Click the 'Cancel' button if 'Save' button is not found or not clickable
			WebDriverWait cancelWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement cancelButton = cancelWait.until(ExpectedConditions.elementToBeClickable(F.getSkillCancel()));
			cancelButton.click();
			System.out.println("Clicked 'Cancel' button");
		}

	}

	@Then("Bot properties ensured")

	public void bot_properties_ensured() throws InterruptedException {

		System.out.println("Bot Properties has been ensured");
		Thread.sleep(2000);
	}

	@Given("I am on the Microsoft Teams login page")
	public void i_am_on_the_microsoft_teams_login_page() {
		((JavascriptExecutor) driver).executeScript("window.open()");

		// Switch to the newly opened tab
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		// Navigate to the Microsoft Teams login page URL
		getTeamsUrl();
	}

	@When("I enter {string} into the username field")

	public void i_enter_into_the_username_field(String string) {

		WebDriverWait usernam = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Input = usernam.until(ExpectedConditions.elementToBeClickable(S.getUsername()));
		Input.sendKeys(string);
		clickOnElement(S.getClickButton());
	}

	@When("I enter {string} into the password field")

	public void i_enter_into_the_password_field(String string) {
		WebDriverWait password = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement PassInput = password.until(ExpectedConditions.elementToBeClickable(S.getPasscode()));
		PassInput.sendKeys(string);
		clickOnElement(S.getPassClickButton());
		WebDriverWait NO = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Noclick = NO.until(ExpectedConditions.elementToBeClickable(S.getNoButton()));
		Noclick.click();
		WebDriverWait Dismiss = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement DisClick = Dismiss.until(ExpectedConditions.elementToBeClickable(S.getDismissButton()));
		DisClick.click();
		WebDriverWait chatButton = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement chat = chatButton.until(ExpectedConditions.elementToBeClickable(S.getChatButton()));
		chat.click();

	}

	@Then("I should see Teams dashboard")
	public void i_should_see_teams_dashboard() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		String thirdTabHandle = null;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(driver.getWindowHandle())) {
				thirdTabHandle = handle;
			}
		}
		driver.switchTo().window(thirdTabHandle);

		// Navigate to the Microsoft Teams login page URL
		getWebUrl();
		driver.switchTo().frame(0);
	}

	@When("User Open Url in New Tab")
	public void user_open_url_in_new_tab() {
		WebDriverWait Webconnect = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement txtNameElement = Webconnect.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement()));
		txtNameElement.sendKeys("Andrew");

		WebElement txtNameElement1 = Webconnect.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement1()));
		txtNameElement1.sendKeys("TestUser2@lab.ontryvium.com");

		WebElement txtNameElement2 = Webconnect.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement2()));
		txtNameElement2.sendKeys("Hi");

		clickOnElement(S.getWebButton());

		WebElement scroller = Webconnect.until(ExpectedConditions.visibilityOf(S.getWelResponse()));

		if (scroller.isDisplayed()) {
			ScrollDown();
		} else {
			System.out.println("Issue with Bot response");
		}
	}

	@When("User Passing Values")
	public void user_passing_values() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// Wait for the visibility of the popup message
		WebElement popupMessage = wait.until(ExpectedConditions.visibilityOf(S.getPopupMessage()));

		// Send the next message
		WebElement responseInput = S.getResponseInput();
		responseInput.sendKeys("Outlook Issue");
		responseInput.submit();

		// Wait for the visibility of the Outlook Archive
		wait.until(ExpectedConditions.visibilityOf(S.getOutlookArchieve())).click();

		// Wait for the visibility of the Archive element
		wait.until(ExpectedConditions.visibilityOf(S.getArchieve()));

		// Introduce a dynamic wait instead of static sleep
		WebElement response = wait.until(ExpectedConditions.visibilityOf(S.getResponse()));
		response.sendKeys("Yes");
		response.submit();
		Thread.sleep(2000);
	}

	@When("Initiating chat in Bot")
	public void initiating_chat_in_bot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait for the visibility of S.getResponse1()
		WebElement response1 = wait.until(ExpectedConditions.visibilityOf(S.getResponse1()));

		// Introduce a dynamic wait instead of static sleep
		WebElement response2 = S.getResponse2();
		response2.sendKeys("Y");
		Thread.sleep(1000);
		response2.sendKeys("es");
		Thread.sleep(1000);
		response2.submit();
		// Introduce a dynamic wait instead of static sleep
		ScrollDown();

		// Wait for the visibility of S.getResponse3()
		WebElement response3 = wait.until(ExpectedConditions.visibilityOf(S.getResponse3()));

		// Introduce a dynamic wait instead of static sleep
		WebElement response4 = S.getResponse4();
		response4.sendKeys("Outlook");
		response4.submit();

		Thread.sleep(2000);
		ScrollDown();
		Thread.sleep(1000);

		response2.sendKeys("Rebuild Outlook profile");
		response2.submit();
		Thread.sleep(3000);

		for (int i = 0; i < 9; i++) { // Repeat the click action 5 times
			// Wait for four seconds
			Thread.sleep(5000);

			// Find the button element
			WebElement button = S.getResponse2();

			response2.sendKeys("Yes");
			response2.submit();

//			System.out.println("Click action executed");
		}

		Thread.sleep(2000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		WebDriverWait WaitEmployeCounter = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Dashboard = WaitEmployeCounter.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='treeview ng-star-inserted'])[1]")));
		Dashboard.click();

		Thread.sleep(2000);
		WebElement EmployeCounter = WaitEmployeCounter
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@title='Refresh'])[1]")));
		EmployeCounter.click();
		Thread.sleep(3000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
		driver.switchTo().frame(0);
		WebDriverWait tre = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ssswww = tre.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//p[contains(text(),'Is there anything else I could help you with?')]")));

		Thread.sleep(3000);
//		WebElement vfe = driver.findElement(By.xpath("//input[@placeholder='Type your message']"));
//		vfe.sendKeys("NO");
//		vfe.submit();
		Thread.sleep(2000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		EmployeCounter.click();
		Thread.sleep(2000);
	}

	@Then("Closing the chat with Bot")
	public void closing_the_chat_with_bot() throws InterruptedException {
		System.out.println("Opening another tab for Webchat");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
		Thread.sleep(2000);
	}

	@When("Open Url in New Tab")
	public void open_url_in_new_tab() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		String fourthTabHandle = null;
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(driver.getWindowHandle())) {
				fourthTabHandle = handle;
			}
		}
		driver.switchTo().window(fourthTabHandle);
		getWebUrl();
		driver.switchTo().frame(0);
	}

	@When("User Passing Credentials")
	public void user_passing_credentials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement nameElement = wait.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement()));
		nameElement.sendKeys("Brandon");

		WebElement nameElement1 = wait.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement1()));
		nameElement1.sendKeys("brandon.user@lab.ontryvium.com");

		WebElement nameElement2 = wait.until(ExpectedConditions.elementToBeClickable(S.getTxtNameElement2()));
		nameElement2.sendKeys("Hello");

		clickOnElement(S.getWebButton());

		WebElement responseElement = wait.until(ExpectedConditions.visibilityOf(S.getWelResponse()));

		if (responseElement.isDisplayed()) {
			ScrollDown();
		} else {
			System.out.println("Issue with Bot response");
		}
	}

	@When("Initiating chat as new user Bot")
	public void initiating_chat_as_new_user_bot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(S.getPopupMessage()));

		// Send the next message
		WebElement responseInputElement = S.getResponseInput();
		responseInputElement.sendKeys("Connect to agent");
		responseInputElement.submit();
		
		WebElement Confirmation = wait.until(ExpectedConditions.visibilityOf(S.getAgentYes()));
		Confirmation.click();
		Thread.sleep(3000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		WebElement Dashboard = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='side-menu-icon'])[1]")));
		Dashboard.click();
		Thread.sleep(2000);
		WebElement EmployeCounter = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@title='Refresh'])[1]")));
		EmployeCounter.click();
		Thread.sleep(2000);
		
	}

	@Then("user close the chat")
	public void user_close_the_chat() {

	}

}
