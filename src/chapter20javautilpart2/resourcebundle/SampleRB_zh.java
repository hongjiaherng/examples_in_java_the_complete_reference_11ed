// Third resource bundle (Chinese version)

package chapter20javautilpart2.resourcebundle;

import java.util.ListResourceBundle;

public class SampleRB_zh extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "我的程序";

        resources[1][0] = "StopText";
        resources[1][1] = "暂停";

        resources[2][0] = "StartText";
        resources[2][1] = "开始";

        return resources;
    }
}
