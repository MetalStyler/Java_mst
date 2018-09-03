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
        click(By.xpath("//li[@class='admin']/a"));
    }

    public void gotoContactPage() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
    }

    public void gotoContactCreationPage() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"));
    }

    public void skipContactAddressForm() {
        click(By.xpath("//*[@id=\"content\"]/form/input[1]"));
    }
}
