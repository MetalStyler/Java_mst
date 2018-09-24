package mst.addressbook.Tests;

import mst.addressbook.Model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.isThereElements()) {
            app.getGroupHelper().createGroup(new GroupData("test_for_delete", "test_for_delete", "test_for_delete"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        System.out.println(app.getGroupHelper().getGroupList());
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        for (int i = 0; i < after.size(); i ++) {
            Assert.assertEquals(before.get(i), after.get(i));
        }
    }
}
