package br.com.jamesson.tasks.prod;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckIT {

  @Test
  public void healthCheck() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.navigate().to("http://localhost:9999/tasks/");
      String version = driver.findElement(By.id("version")).getText();
      Assert.assertTrue(version.startsWith("build"));
    } finally {
      driver.quit();
    }
  }

}
