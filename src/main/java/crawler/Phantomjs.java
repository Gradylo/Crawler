package crawler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Phantomjs {

	public static void main(String[] args) {
		// 设置必要参数
		DesiredCapabilities dcaps = new DesiredCapabilities();
		// ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		// 截屏支持
		dcaps.setCapability("takesScreenshot", true);
		// css搜索支持
		dcaps.setCapability("cssSelectorsEnabled", true);
		// js支持
		dcaps.setJavascriptEnabled(true);
		// 驱动支持（第二参数表明的是你的phantomjs引擎所在的路径）
		dcaps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"D:/Java/phantomjs/phantomjs/bin/phantomjs.exe");
		// 创建无界面浏览器对象
		PhantomJSDriver driver = new PhantomJSDriver(dcaps);

		// 设置隐性等待（作用于全局）
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// 打开页面
		driver.get("http://music.163.com/#/playlist?id=731629965");
		try {
			// 查找元素
			Thread.sleep(12000);
			//输出html内容
//			 WebElement webElement = webDriver.findElement(By.xpath("/html"));
//		     System.out.println(webElement.getAttribute("outerHTML"));
			
	        driver.switchTo().frame("g-iframe");
			 WebElement element = driver.findElement(By.id("song-list-pre-cache"));
			 System.out.println(element.getText());
			//
			// WebElement we1 = element
			// .findElement(By.className("rate-paginator"));
			// List<WebElement> we2 = we1.findElements(By.tagName("a"));
			// WebElement we3 = we2.get(we2.size() - 1);
			// we3.click();
			// Thread.sleep(1000);
			// WebElement element2 = driver.findElement(By.id("J_Reviews"));
			// System.out.println(element2.getText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭并退出浏览器
			driver.close();
			driver.quit();
		}
	}

}
