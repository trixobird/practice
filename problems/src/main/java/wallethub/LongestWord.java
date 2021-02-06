package wallethub;

class LongestWord {

    private LongestWord() {
    }

    static String longestWord(String sen) {

        String noPunct = sen.replaceAll("\\p{Punct}","");
        String[] words = noPunct.split(" ");

        String biggestWord = null;
        int maxLetters = 0;
        for (String word : words) {
            if (word.length() > maxLetters) {
                maxLetters = word.length();
                biggestWord = word;
            }
        }
        return biggestWord;
    }
}
