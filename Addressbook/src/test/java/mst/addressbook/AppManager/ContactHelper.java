package mst.addressbook.AppManager;

import mst.addressbook.Model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

//    public GroupHelper(FirefoxDriver wd) {
//        super(wd);
//    }

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomePage());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getHomePhone2());
        type(By.name("notes"), contactData.getNotes());
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void initContactCreation() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"));
    }

    public void skipQuickAddForm() {
        click(By.xpath("//*[@id=\"content\"]/form/input[1]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        skipQuickAddForm();
        fillContactForm(contact);
        submitContactCreation();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("selected[]"));
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
