package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData(
                "test_firstname",
                "test_middlename",
                "test_lastname",
                "test_nickname",
                "test_title",
                "test_company",
                "test_address",
                "test_homephone",
                "test_mobilephone",
                "test_workphone",
                "test_fax",
                "test@email.com",
                "test@email2.com",
                "test@email3.com",
                "test_homepage.ru",
                "test_address2",
                "test_homephone2",
                "test_notes"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
