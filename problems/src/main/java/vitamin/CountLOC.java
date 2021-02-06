package vitamin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Count Lines of Code
 * The number of lines of code in a program's source code is one of the most fundamental
 * (and, perhaps, most easily misunderstood) metrics for analyzing its complexity.
 *
 * In this challenge, write a function CountLOC.count to count the lines of code in a Java source file.
 * A line of code is defined as any line in the source which contains at least one character of executable code.
 * This excludes comments and whitespace. All input will be valid Java code in string format.
 *
 * CountLOC.count(text)
 * Parameters
 * text: String - A stringified valid Java source file
 *
 * Return Value
 * int - A count of the number of lines of executable code in the source file
 *
 * Java comment syntax
 * Java comments are identical to those in JavaScript, C, C++ and C# and follow one of two formats:
 *
 * int i = 42;  // this is a single-line comment
 * and
 *
 * int i = 42; /* this is a
 *        multiline comment
 *Java string syntax
 *Java has simple string syntax which does not include templates or multiline strings.Strings are double-quote(")
 * delimited and cannot span more than a single line. Characters are single-quote (') delimited and contain a single
 * character with optional blackslash escape character, as in '\n'. Comments which are part of strings should be
 * disregarded by your line of code counter.
 */

public class CountLOC {

    private CountLOC() {}

    public static int count(String text) {
        int num = 0;
        String[] lines = text.split("\n");

        boolean multiComment = false;

        for (String line : lines) {
            Queue<Character> queue = line
                    .chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toCollection(LinkedList::new));

            char prevChar = ' ';
            boolean notCode = false;
            boolean singleComment = false;
            boolean str = false;
            boolean charr = false;

            do {
                Character currChar = queue.poll();
                switch (currChar) {
                    case '"':
                        if (!multiComment && !singleComment && !charr)
                            str = !str;
                        break;
                    case '\\':
                        if (!multiComment && !singleComment && (str || charr) && queue.peek() != null)
                            queue.poll();
                        break;
                    case '/':
                        if (str || charr)
                            break;
                        if (!singleComment && prevChar == '*') {
                            multiComment = false;
                            currChar = ' ';
                        } else if (!multiComment && prevChar == '/')
                            singleComment = true;
                        break;
                    case '*':
                        if (!str && !charr && !singleComment && prevChar == '/')
                            multiComment = true;
                        break;
                    case '\'':
                        if (!str && !multiComment && !singleComment)
                            charr = !charr;
                        break;
                    case ' ':
                        break;
                    default:
                        if (!multiComment && !singleComment && !str)
                            notCode = true;
                        break;
                }
                prevChar = currChar;
            } while (queue.peek() != null);
            if (notCode)
                num++;
        }
        return num;
    }
}

