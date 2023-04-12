package ru.alex.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[contains(@class, 'UserID-Badge')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */

    @FindBy(xpath = "//*[contains(@class, 'MenuItem_logout')]")
    private WebElement logoutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public Boolean userMenuIsDisplayed() {
        Boolean badgeIsDisplayed = userMenu.isDisplayed();
        return badgeIsDisplayed; }
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click(); }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }
}
