package vitamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortColumnsTest {

    @Test
    public void sortCsvColumns() {
        String input;
        String expectedResult;

//        input = "Beth,Charles,Danielle,Adam,Eric\n17945,10091,10088,3907,10132\n2,12,13,48,";
//        expectedResult = "Adam,Beth,Charles,Danielle,Eric\n3907,17945,10091,10088,10132\n48,2,12,13, ";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
//
//        input = "Beth,Charles,Danielle,Adam,Eric\n17945,10091,10088,3907,10132\n2,12,13,48,11";
//        expectedResult = "Adam,Beth,Charles,Danielle,Eric\n3907,17945,10091,10088,10132\n48,2,12,13,11";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
//
//        input = "Beth,Charles,Danielle,Adam,Eric\n17945,,10088,3907,10132\n2,12,13,48,11";
//        expectedResult = "Adam,Beth,Charles,Danielle,Eric\n3907,17945, ,10088,10132\n48,2,12,13,11";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
//
//
//        input = "Beth,Charles,Danielle,,Eric\n17945,10091,10088,3907,10132\n2,12,13,48,11";
//        expectedResult = ",Beth,Charles,Danielle,Eric\n3907,17945,10091,10088,10132\n48,2,12,13,11";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
//
//        input = "Beth,Charles,Danielle,Adam,Eric\n17945,10091,10088,3907,10132\n2,12,13,48,11";
//        expectedResult = "Adam,Beth,Charles,Danielle,Eric\n3907,17945,10091,10088,10132\n48,2,12,13,11";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
//
//        input = "Beth,Charles,Danielle,Adam,Eric\n17945,10091,10088,3907,10132\n2,12,13,48,11";
        expectedResult = "Adam,Beth,Charles,Danielle,Eric\n3907,17945,10091,10088,10132\n48,2,12,13,11";
//        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));

        input = "country,email,First Name,id,Last Name,Notes,Suffix\n" +
                "        false,Poland,jwilliamson0@sfgate.com,Judith,1,Williamson,augue vel accumsan tellus,\n" +
                "        false,China,pkelly1@reference.com,Paul,2,Kelly,lacus at velit,\n" +
                "        false,China,lpayne2@ftc.gov,Lillian,3,Payne,pede libero quis orci,\n" +
                "        false,Jamaica,eberry3@qq.com,Eric,4,Berry,odio donec,\n" +
                "        false,Democratic Republic of the Congo,mdunn4@studiopress.com,Marie,5,Dunn,metus aenean fermentum donec ut,\n" +
                "        true,Philippines,hmontgomery5@fastcompany.com,Helen,6,Montgomery,rutrum ac lobortis vel,Sr\n" +
                "        false,Yemen,jkim6@nhs.uk,Jose,7,Kim,nunc viverra,\n" +
                "        false,Thailand,cmason7@flickr.com,Carol,8,Mason,tortor sollicitudin mi,\n" +
                "        true,Nigeria,asanchez8@google.com.hk,Andrew,9,Sanchez,purus phasellus in felis donec,\n" +
                "        true,,bfrazier9@youku.com,Brandon,10,Frazier,,\n" +
                "        true,United States,msimmonsa@seesaa.net,Maria,11,Simmons,scelerisque mauris sit amet eros,\n" +
                "        true,Russia,nrobinsonb@dmoz.org,Nancy,12,Robinson,vestibulum ac,\n" +
                "        true,,tmedinac@oracle.com,Thomas,13,Medina,,Jr\n" +
                "        false,Poland,ccarterd@reddit.com,Craig,14,Carter,justo lacinia eget,IV\n" +
                "        false,Indonesia,jsanderse@imageshack.us,Joan,15,Sanders,in eleifend quam a odio,\n" +
                "        true,China,ajonesf@free.fr,Amy,16,Jones,ut massa,III\n" +
                "        true,Peru,kwoodg@angelfire.com,Kathy,17,Wood,ipsum praesent blandit lacinia,\n" +
                "        false,Panama,crobertsonh@google.com.au,Christopher,18,Robertson,faucibus orci luctus et ultrices,\n" +
                "        false,Argentina,charveyi@indiatimes.com,Cheryl,19,Harvey,proin eu mi nulla ac,\n" +
                "        false,Estonia,iwelchj@wordpress.org,Irene,20,Welch,pede morbi porttitor,]> but was:<Active,[First Name,Last Name,Notes,Suffix,country,email,id\n" +
                "        false,Judith,Williamson,augue vel accumsan tellus, ,Poland,jwilliamson0@sfgate.com,1\n" +
                "        false,Paul,Kelly,lacus at velit, ,China,pkelly1@reference.com,2\n" +
                "        false,Lillian,Payne,pede libero quis orci, ,China,lpayne2@ftc.gov,3\n" +
                "        false,Eric,Berry,odio donec, ,Jamaica,eberry3@qq.com,4\n" +
                "        false,Marie,Dunn,metus aenean fermentum donec ut, ,Democratic Republic of the Congo,mdunn4@studiopress.com,5\n" +
                "        true,Helen,Montgomery,rutrum ac lobortis vel,Sr,Philippines,hmontgomery5@fastcompany.com,6\n" +
                "        false,Jose,Kim,nunc viverra, ,Yemen,jkim6@nhs.uk,7\n" +
                "        false,Carol,Mason,tortor sollicitudin mi, ,Thailand,cmason7@flickr.com,8\n" +
                "        true,Andrew,Sanchez,purus phasellus in felis donec, ,Nigeria,asanchez8@google.com.hk,9\n" +
                "        true,Brandon,Frazier, , , ,bfrazier9@youku.com,10\n" +
                "        true,Maria,Simmons,scelerisque mauris sit amet eros, ,United States,msimmonsa@seesaa.net,11\n" +
                "        true,Nancy,Robinson,vestibulum ac, ,Russia,nrobinsonb@dmoz.org,12\n" +
                "        true,Thomas,Medina, ,Jr, ,tmedinac@oracle.com,13\n" +
                "        false,Craig,Carter,justo lacinia eget,IV,Poland,ccarterd@reddit.com,14\n" +
                "        false,Joan,Sanders,in eleifend quam a odio, ,Indonesia,jsanderse@imageshack.us,15\n" +
                "        true,Amy,Jones,ut massa,III,China,ajonesf@free.fr,16\n" +
                "        true,Kathy,Wood,ipsum praesent blandit lacinia, ,Peru,kwoodg@angelfire.com,17\n" +
                "        false,Christopher,Robertson,faucibus orci luctus et ultrices, ,Panama,crobertsonh@google.com.au,18\n" +
                "        false,Cheryl,Harvey,proin eu mi nulla ac, ,Argentina,charveyi@indiatimes.com,19\n" +
                "        false,Irene,Welch,pede morbi porttitor, ,Estonia,iwelchj@wordpress.org,20";
        assertEquals(expectedResult, SortColumns.sortCsvColumns(input));
    }
}