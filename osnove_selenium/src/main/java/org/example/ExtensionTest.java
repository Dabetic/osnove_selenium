package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ExtensionTest {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\.java\\Extension\\AdBlock.crx"));

        WebDriver driver = new ChromeDriver(opt);

        driver.navigate().to("https://demoqa.com/webtables");
//        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".mr-2>svg")).click();
    }
}
