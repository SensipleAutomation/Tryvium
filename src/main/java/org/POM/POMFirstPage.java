package org.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMFirstPage {

	public static WebDriver driver;

	@FindBy(name = "useremail")
	private WebElement Mail;

	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//*[text()='Login ']")
	private WebElement LogButton;

	@FindBy(xpath = "//*[text()='Incorrect Username or Password']")
	private WebElement Errmsg;

	@FindBy(xpath = "(//*[contains(@class, 'treeview')])[2]")
	private WebElement BotClick;

	@FindBy(xpath = "(//i[@class='p-element fa fa-edit cursur-cl fa-edit-icon'])[2]")
	private WebElement JennieEdit;

	@FindBy(name = "enableVisual")
	private WebElement VisualIVR;

	@FindBy(xpath = "(//*[text()='Visual IVR'])[2]")
	private WebElement scrolltoVisual;

	@FindBy(name = "autoCompNaturalLang")
	private WebElement NLUENgine;

	@FindBy(xpath = "//*[@class='all-btns mar-right btn-disabled']")
	private WebElement cancelDOwn;

	@FindBy(xpath = "(//*[@class='all-btns ng-star-inserted'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@class='all-btns mar-right btn-disabled']")
	private WebElement cancelButton;

	@FindBy(id = "toast-container")
	private WebElement ToasterJennie;

	@FindBy(xpath = "(//*[contains(@class, 'treeview')])[3]")
	private WebElement UserManage;

	@FindBy(xpath = "//*[text()='AutoAgent1']")
	private WebElement AutoAgent;

	@FindBy(xpath = "(//*[@class='ng-untouched ng-pristine ng-valid'])[6]")
	private WebElement Bot;

	@FindBy(xpath = "//*[text()='Timezone ']")
	private WebElement scrollBot;

	@FindBy(xpath = "//*[@class='all-btns btn-disabled agenteditsave ng-star-inserted']")
	private WebElement AgentSave;

	@FindBy(xpath = "//*[@class='all-btns']")
	private WebElement AgentClose;

	@FindBy(xpath = "//*[text()=' Agent Saved Successfully ']")
	private WebElement AgentToaster;

	@FindBy(xpath = "(//li[@class='treeview ng-star-inserted'])[3]")
	private WebElement ToSkillGroup;

	@FindBy(xpath = "//a[@href='/adminconsole/Home/SkillGroup']")
	private WebElement SkillGroupSelect;

	@FindBy(xpath = "//th[text()='Skills']")
	private WebElement JusClick;

	@FindBy(name = "contextApplicationId")
	private WebElement context;

	@FindBy(xpath = "//select[@class='form-control langoption ng-untouched ng-pristine ng-valid']")
	private WebElement skillbot;

	@FindBy(xpath = "(//span[text()='Application Support']/following::span)[2]")
	private WebElement Defaultgroup;

	@FindBy(xpath = "//*[text()='Application Support']")
	private WebElement SKillGroupFunc;

	@FindBy(xpath = "(//*[@class='p-picklist-filter-input p-inputtext p-component'])[1]")
	private WebElement searchBar;

	@FindBy(xpath = "(//*[contains(@class, 'p-ripple p-element')])[1]")
	private WebElement DragElement;

	@FindBy(xpath = "//*[@class='cdk-drop-list p-picklist-list p-picklist-target']")
	private WebElement DropElement;

	@FindBy(xpath = "//input[@placeholder='Search by agents in group']")
	private WebElement AgentsInGroupSearch;

	@FindBy(xpath = "//div[text()='All agents']/following::div[text()='AutoAgent1 Test ']")
	private WebElement AgentAuto;

	@FindBy(xpath = "//div[text()='Agents in group']/following::div[text()='AutoAgent1 Test ']")
	private WebElement followingAgent1;

	@FindBy(xpath = "//*[text()=' Voice call back configuration ']")
	private WebElement ScrollerToSnow;

	@FindBy(name = "contextApplicationId")
	private WebElement ConfigContent;

	@FindBy(xpath = "//*[text()=' Application Support is updated successfully ']")
	private WebElement skillToaster;

	@FindBy(xpath = "//*[@formcontrolname='botid']")
	private WebElement FirstBot;

	public WebElement getFirstBot() {
		return FirstBot;
	}

	public WebElement getSkillToaster() {
		return skillToaster;
	}

	public WebElement getSkillSave() {
		return skillSave;
	}

	public WebElement getSkillCancel() {
		return skillCancel;
	}

	@FindBy(xpath = "//*[text()='Save ']")
	private WebElement skillSave;

	@FindBy(xpath = "//*[text()='Cancel']")
	private WebElement skillCancel;

	public WebElement getConfigContent() {
		return ConfigContent;
	}

	public WebElement getScrollerToSnow() {
		return ScrollerToSnow;
	}

	public WebElement getAgentAuto() {
		return AgentAuto;
	}

	public WebElement getFollowingAgent1() {
		return followingAgent1;
	}

	public WebElement getAgentsInGroupSearch() {
		return AgentsInGroupSearch;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getDragElement() {
		return DragElement;
	}

	public WebElement getDropElement() {
		return DropElement;
	}

	public WebElement getSKillGroupFunc() {
		return SKillGroupFunc;
	}

	public WebElement getDefaultgroup() {
		return Defaultgroup;
	}

	public WebElement getSkillbot() {
		return skillbot;
	}

	public WebElement getContext() {
		return context;
	}

	public WebElement getJusClick() {
		return JusClick;
	}

	public WebElement getSkillGroupSelect() {
		return SkillGroupSelect;
	}

	public WebElement getToSkillGroup() {
		return ToSkillGroup;
	}

	public WebElement getAgentToaster() {
		return AgentToaster;
	}

	public WebElement getAgentSave() {
		return AgentSave;
	}

	public WebElement getAgentClose() {
		return AgentClose;
	}

	public WebElement getScrollBot() {
		return scrollBot;
	}

	public WebElement getBot() {
		return Bot;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getAutoAgent() {
		return AutoAgent;
	}

	public WebElement getUserManage() {
		return UserManage;
	}

	public WebElement getToasterJennie() {
		return ToasterJennie;
	}

	public WebElement getCancelDOwn() {
		return cancelDOwn;
	}

	public WebElement getNLUENgine() {
		return NLUENgine;
	}

	public WebElement getScrolltoVisual() {
		return scrolltoVisual;
	}

	public WebElement getVisualIVR() {
		return VisualIVR;
	}

	public WebElement getJennieEdit() {
		return JennieEdit;
	}

	public WebElement getBotClick() {
		return BotClick;
	}

	public WebElement getErrmsg() {
		return Errmsg;
	}

	public WebElement getMail() {
		return Mail;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogButton() {
		return LogButton;
	}

	public POMFirstPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}
}
