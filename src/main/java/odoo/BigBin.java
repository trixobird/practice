package odoo;

import java.io.IOException;
import java.io.InputStream;

import static util.FileUtils.getFileFromResources;
import static util.FileUtils.writeToFile;

/*
 * A file is very big, therefore we need to delete each 7th character
 */
public class BigBin {

    public static void main(String[] args) throws IOException {

        int length = 7;
        InputStream is = getFileFromResources("big.bin", BigBin.class);
        byte[] bytes = new byte[length];
        StringBuilder sb = new StringBuilder();
        int charsRead = is.read(bytes, 0, 6);
        if (charsRead > 0) {
            sb.append(new String(bytes, 0, charsRead));
        }
        while (true) {
            charsRead = is.read(bytes, 0, length);
            if (charsRead <= 0) {
                break;
            }
            sb.append(new String(bytes, 1, charsRead - 1));
        }

        writeToFile(sb, "small1.bin", BigBin.class);
    }
}
