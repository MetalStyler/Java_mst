package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "test_firstname_modified",
                "test_middlename_modified",
                "test_lastname_modified",
                "test_nickname_modified",
                "test_title_modified",
                "test_company_modified",
                "test_address_modified",
                "test_homephone_modified",
                "test_mobilephone_modified",
                "test_workphone_modified",
                "test_fax_modified",
                "test_modified@email.com",
                "test_modified@email2.com",
                "test_modified@email3.com",
                "test_homepage_modified.ru",
                "test_address2_modified",
                "test_homephone2_modified",
                "test_notes_modified"));
        app.getContactHelper().submitContactModification();
    }
}
