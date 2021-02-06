package radix;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Write a function called validBraces that takes a string of braces, and determines if the order of the braces is valid.
 * validBraces should return true if the string is valid, and false if it's invalid.
 * <p>
 * All input strings will be nonempty, and will only consist of open parentheses '(' , closed parentheses ')',
 * open brackets '[', closed brackets ']', open curly braces '{' and closed curly braces '}'.
 * <p>
 * What is considered Valid?
 * A string of braces is considered valid if all braces are matched with the correct brace. For example:
 * '(){}[]' and '([{}])' would be considered valid, while '(}', '[(])', and '[({})](]' would be considered invalid.
 */
public class Braces {

    private Braces() {
    }

    public static boolean validate(String braces) {

        Deque<Character> stack = new LinkedList<>();
        List<Character> openParenthesis = Arrays.asList('[', '{', '(');
        List<Character> closeParenthesis = Arrays.asList(']', '}', ')');


        List<Character> chars = braces.chars().mapToObj(e -> (char) e).collect(toList());
        for (char ch : chars) {
            if (openParenthesis.contains(ch)) {
                stack.push(ch);
            }

            if (closeParenthesis.contains(ch) &&
                    (stack.isEmpty() || !isMatchingPair(stack.pop(), ch))) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char char1, char char2) {
        if (char1 == '(' && char2 == ')')
            return true;
        else if (char1 == '{' && char2 == '}')
            return true;
        else return char1 == '[' && char2 == ']';
    }
}
