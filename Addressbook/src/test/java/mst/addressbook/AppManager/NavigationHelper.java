package mst.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

//    public NavigationHelper(FirefoxDriver wd) {
//       super(wd);
//    }

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
       click(By.xpath("/html/body/div/div[3]/ul/li[3]/a"));
    }
}
