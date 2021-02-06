package odoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Pattern;

import static util.FileUtils.writeToFile;

/**
 * Write a program to download the contents of http://www.sap.com/belgique/index.html (the SAP homepage for Belgium), and then save the contents of the page to a new local file, with all occurrences of "SAP" replaced by "Odoo".
 */
public class Sap2Odoo {

    public static void main(String[] args) throws IOException {
        replaceInPage(new URL("https://www.sap.com/belgique/index.html"), "SAP", "odoo", "odoo.html");
    }

    private static void replaceInPage(URL url, String old, String nnew, String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            String str = Pattern.compile(old).matcher(sb).replaceAll(nnew);

            writeToFile(str, fileName, Sap2Odoo.class);
        }
    }
}
