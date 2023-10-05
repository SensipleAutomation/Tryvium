package org.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMSecondPage {

	public static WebDriver driver;

	@FindBy(id = "i0116")
	private WebElement username;

	@FindBy(id = "idSIButton9")
	private WebElement clickButton;

	@FindBy(id = "i0118")
	private WebElement passcode;

	@FindBy(id = "idSIButton9")
	private WebElement passClickButton;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement noButton;

	@FindBy(xpath = "//*[@title='Dismiss']")
	private WebElement dismissButton;

	@FindBy(xpath = "(//button[@class='app-bar-link app-bar-button '])[2]")
	private WebElement chatButton;

	@FindBy(id = "txtName")
	private WebElement txtNameElement;

	@FindBy(id = "txtEmail")
	private WebElement txtNameElement1;

	@FindBy(id = "txtQuery")
	private WebElement txtNameElement2;

	@FindBy(xpath = "//*[@id='chat-btn']")
	private WebElement WebButton;

	@FindBy(xpath = "//div[contains(text(),'How can I help you today?')]")
	private WebElement popupMessage;

	@FindBy(xpath = "//input[@placeholder='Type your message']")
	private WebElement responseInput;

	@FindBy(xpath = "//*[contains(text(), 'Outlook Archive')]")
	private WebElement OutlookArchieve;

	@FindBy(xpath = "//p[contains(text(),'Okay, I will archive all of your email')]")
	private WebElement Archieve;

	@FindBy(xpath = "//input[@placeholder='Type your message']")
	private WebElement response;

	@FindBy(xpath = "//p[contains(text(),'Is there anything else I could help you with?')]")
	private WebElement response1;

	@FindBy(xpath = "//input[@placeholder='Type your message']")
	private WebElement response2;

	@FindBy(xpath = "//p[contains(text(),'Sure, What can I do for you?')]")
	private WebElement response3;

	@FindBy(xpath = "//input[@placeholder='Type your message']")
	private WebElement response4;

	@FindBy(xpath = "//*[contains(text(), 'open tickets for your refrence:')]")
	private WebElement welResponse;

	@FindBy(xpath = "//p[text()='Would you like me to connect to an live agent?']/following::div[text()='Yes']")
	private WebElement AgentYes;

	public WebElement getAgentYes() {
		return AgentYes;
	}

	public WebElement getWelResponse() {
		return welResponse;
	}

	public WebElement getResponse3() {
		return response3;
	}

	public WebElement getResponse4() {
		return response4;
	}

	public WebElement getPopupMessage() {
		return popupMessage;
	}

	public WebElement getResponseInput() {
		return responseInput;
	}

	public WebElement getOutlookArchieve() {
		return OutlookArchieve;
	}

	public WebElement getArchieve() {
		return Archieve;
	}

	public WebElement getResponse() {
		return response;
	}

	public WebElement getResponse1() {
		return response1;
	}

	public WebElement getResponse2() {
		return response2;
	}

	public WebElement getWebButton() {
		return WebButton;
	}

	public WebElement getTxtNameElement() {
		return txtNameElement;
	}

	public WebElement getTxtNameElement1() {
		return txtNameElement1;
	}

	public WebElement getTxtNameElement2() {
		return txtNameElement2;
	}

	public WebElement getDismissButton() {
		return dismissButton;
	}

	public WebElement getChatButton() {
		return chatButton;
	}

	public WebElement getNoButton() {
		return noButton;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getClickButton() {
		return clickButton;
	}

	public WebElement getPasscode() {
		return passcode;
	}

	public WebElement getPassClickButton() {
		return passClickButton;
	}

	public POMSecondPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

}
