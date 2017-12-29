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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 打开页面
		driver.get("https://l.facebook.com/l.php?u=http%3A%2F%2Fwww.meru.com.tw%2Fmobile%2Fproduct.php%3Fpid_for_show%3D5450&h=ATPfN7vxgjJVRT3iZlQAB2kIDCjqrPdZGjYUgxvI5jBdTm4sX-ezLVO6oMvGaepoWsu1NoDH5IJpPuh8WQ_0FNAqp5RZayiz0GzKYB5uSuZhpMHgKRHhv3tibdOHuUgQFMXJG5Tw-oKvjkkXoemn-eaDUHwurwLGyzH0f1dZJVFchup5HznCLSfY4ueANmM9Ntb647yqo4HArulEO4zWkbOl_USROH7LQ4-sUlFg910JUYdeuvoARFmqfIe9fK3HLyFCOa3QSzeDh3RSOv0eaPRBl7KXGVEU");
		try {
			// 查找元素
			Thread.sleep(10000);
			//输出html内容
			WebElement webElement = driver.findElement(By.xpath("html"));
			System.out.println(webElement.getAttribute("outerHTML"));
//			 WebElement element = driver.findElement(By.id("content"));
//			 System.out.println(element.getText());
//			 System.out.println(element.getText());
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
