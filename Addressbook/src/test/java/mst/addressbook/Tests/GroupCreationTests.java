package mst.addressbook.Tests;

import mst.addressbook.Model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test_groupname", "test_groupheader", "test_groupfooter"));
        app.getGroupHelper().submitGroupGreation();
        app.getGroupHelper().returnToGroupPage();
    }

}