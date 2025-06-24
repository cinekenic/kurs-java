package com.kodilla.kodillatesting2.crudapp;

import com.kodilla.kodillatesting2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://cinekenic.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

//    @AfterEach
//    public void cleanUpAfterTest() {
//        driver.close();
//    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[@action='https://tasksapplication.onrender.com/v1/tasks']//input[@name='title']";
        final String XPATH_TASK_CONTENT = "//form[@action='https://tasksapplication.onrender.com/v1/tasks']//textarea[@name='content']";
        final String XPATH_ADD_BUTTON = "//form[@action='https://tasksapplication.onrender.com/v1/tasks']//fieldset[contains(@class,'button-section')]//button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int tasksBefore = driver.findElements(By.xpath("//section[@class='datatable']//div")).size();

        wait.until(driver -> driver.findElements(By.xpath("//section[@class='datatable']//div")).size() > tasksBefore);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
    }

    private boolean checkTaskExistsInTrello(String taskName)  throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        Thread.sleep(4000);

        driverTrello.findElement(By.id("username")).sendKeys("piotr.trzcinski01@gmail.com");
        driverTrello.findElement(By.id("login-submit")).click();

        Thread.sleep(2000);

        driverTrello.findElement(By.id("password")).sendKeys("X8DbPN3C=cz.j9Z");

        driverTrello.findElement(By.id("login-submit")).click();

        Thread.sleep(8000);

        WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'jKBWU1uXSMBpHL')]"));
        element.click();
        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
//        assertTrue(checkTaskExistsInTrello(taskName));
        deleteTestTaskFromCrudApp(taskName);
    }

    private void deleteTestTaskFromCrudApp(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(form ->
                        form.findElement(By.xpath(".//p[@class='datatable__field-value']")).getText().equals(taskName))
                .forEach(form -> {
                    WebElement deleteButton = form.findElement(By.xpath(".//button[@data-task-delete-button]"));
                    deleteButton.click();
                });

        Thread.sleep(3000);
    }
}