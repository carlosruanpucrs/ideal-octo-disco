/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.bonigarcia.wdm.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Test with Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldRegister() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        By createAccountLink = By.id("pt-createaccount");
        wait.until(elementToBeClickable(createAccountLink));
        driver.findElement(createAccountLink).click();

        By usernameInput = By.id("wpName2");
        wait.until(presenceOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys("CarlosRuanPajaresGomes");

        By passwordInput = By.id("wpPassword2");
        wait.until(presenceOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys("Ruan1234@");

        By confirmPasswordInput = By.id("wpRetype");
        wait.until(presenceOfElementLocated(confirmPasswordInput));
        driver.findElement(confirmPasswordInput).sendKeys("Ruan1234@");

        By emailInput = By.id("wpEmail");
        wait.until(presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys("carlos.ruan@acad.pucrs.br");

        By captchaInput = By.id("mw-input-captchaWord");
        wait.until(presenceOfElementLocated(captchaInput));
        driver.findElement(captchaInput).sendKeys("qualquercoisacaptcha");

        By submitButton = By.id("wpCreateaccount");
        wait.until(elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();

        Thread.sleep(6000);
    }

    @Test
    public void shouldDownloadPDF() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        By downloadPdfLink = By.id("coll-download-as-rl");
        wait.until(elementToBeClickable(downloadPdfLink));
        driver.findElement(downloadPdfLink).click();

        By downloadPdfButton = By.className("oo-ui-labelElement-label");
        wait.until(elementToBeClickable(downloadPdfButton));
        driver.findElement(downloadPdfButton).click();

        Thread.sleep(6000);
    }

}