package wallethub;

class Palindrome {

    private Palindrome() {
    }

    static String palindrome(String str) {

        String noSpaces = str.replaceAll("\\s+","");
        return new StringBuilder(noSpaces).reverse().toString().equals(noSpaces)
                ? "true"
                : "false";
    }
}
