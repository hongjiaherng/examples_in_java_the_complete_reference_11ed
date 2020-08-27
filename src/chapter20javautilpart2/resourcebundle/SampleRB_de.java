// Second resource bundle (German)

package chapter20javautilpart2.resourcebundle;

import java.util.ListResourceBundle;

public class SampleRB_de extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "Mein Programm";

        resources[1][0] = "StopText";
        resources[1][1] = "Anschlag";

        resources[2][0] = "StartText";
        resources[2][1] = "Anfang";

        return resources;
    }
}