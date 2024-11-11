package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCalculatorTest extends BaseTest {


    @Test
    public void addShouldSucceed() throws InterruptedException {
        driver.findElement(By.id("btn_1")).click();
        driver.findElement(By.id("btn_2")).click();

        driver.findElement(By.id("plus")).click();

        driver.findElement(By.id("btn_1")).click();// cntrl+d dile pre same line asbe
        driver.findElement(By.id("btn_5")).click();// cntrl+d dile pre same line asbe

        driver.findElement(By.id("equal")).click();
        Assert.assertEquals(driver.findElement(By.id("formula")).getText().trim(), "27");
        takeScreenshot();
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(3000);


    }

    @Test

    public void subtractShouldSucceed() {
        driver.findElement(By.id("btn_9")).click();
        driver.findElement(By.id("btn_1")).click();

        driver.findElement(By.id("minus")).click();

        driver.findElement(By.id("btn_1")).click();// cntrl+d dile pre same line asbe
        driver.findElement(By.id("btn_5")).click();// cntrl+d dile pre same line asbe

        driver.findElement(By.id("equal")).click();
        Assert.assertEquals(driver.findElement(By.id("formula")).getText().trim(), "76");
        takeScreenshot();
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    @Test

    public void  divideShouldSucceed() {
        driver.findElement(By.id("btn_9")).click();

        driver.findElement(By.id("multi")).click();

        driver.findElement(By.id("btn_5")).click();// cntrl+d dile pre same line asbe

        driver.findElement(By.id("equal")).click();
        Assert.assertEquals(driver.findElement(By.id("formula")).getText().trim(), "45");
        takeScreenshot();
    }

    @Test

    public void mulShouldSucceed() throws InterruptedException {

        Thread.sleep(3000);
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("btn_8")).click();

        driver.findElement(By.id("divi")).click();

        driver.findElement(By.id("btn_2")).click();// cntrl+d dile pre same line asbe

        driver.findElement(By.id("equal")).click();
        Assert.assertEquals(driver.findElement(By.id("formula")).getText().trim(), "4");
    }

}
