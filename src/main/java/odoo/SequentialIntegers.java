package odoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialIntegers {

    private static Logger logger = LoggerFactory.getLogger(SequentialIntegers.class);

    public static void main(String[] args) {
        printSequentialIntegers(100);
    }

    /**
     * Write a program that outputs sequentially the integers from 1 to 99 but on some conditions prints a string instead:
     * when the integer is a multiple of 3 print “Open” instead of the number,
     * when it is a multiple of 7 print “Source” instead of the number,
     * when it is a multiple of both 3 and 7 print “OpenSource” instead of the number.
     */
    static void printSequentialIntegers(int limit) {

        for (int i = 0; i < limit; i++) {
            if ((i % 3 == 0) && (i % 7 == 0)) {
                logger.info("OpenSource ");
            } else if (i % 3 == 0) {
                logger.info("Open ");
            } else if (i % 7 == 0) {
                logger.info("Source ");
            } else {
                String format = String.format("%d  ", i);
                logger.info(format);
            }
        }
    }
}
