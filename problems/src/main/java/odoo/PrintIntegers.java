package odoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Write a function that takes a list of strings and returns the sum of the list items that represents an integer (skipping the other items)
 */
public class PrintIntegers {

    private static Logger logger = LoggerFactory.getLogger(PrintIntegers.class);

    public static void main(String[] args) {
        int res = new PrintIntegers().printIntegersRecursively(new LinkedList<>(Arrays.asList("1", "a", "1a", "b2", "02", "12")));
        String s = String.valueOf(res);
        logger.info(s);
    }

    private int printIntegers(List<String> strings) {
        return strings.stream()
                      .filter(s -> s.matches("[0-9]+"))
                      .mapToInt(Integer::valueOf)
                      .sum();

    }

    private int printIntegersRecursively(Queue<String> strings) {
        return printIntegersRecursively(strings, 0);
    }

    private int printIntegersRecursively(Queue<String> strings, int sum) {
        String next = strings.poll();
        if (next != null) {
            int integer = 0;
            try {
                integer = Integer.parseInt(next);
            } catch (NumberFormatException ignored) {
            }
            return printIntegersRecursively(strings, sum + integer);
        }
        return sum;
    }
}
