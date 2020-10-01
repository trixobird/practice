package fb;

public class RotationalCipher {

    static String rotationalCipher(String input, int rotationFactor) {

        StringBuilder sb = new StringBuilder();
        input.chars().boxed().forEach(integer -> {
            final int result;
            if(integer >=65 && integer <= 90) {
                int i = integer + rotationFactor % 26;
                result = i > 90 ? i - 26 : i;
            } else if(integer >=97 && integer <= 122) {
                int i = integer + rotationFactor % 26;
                result = i > 122 ? i - 26 : i;
            } else if(integer >=48 && integer <= 57) {
                int i = integer + rotationFactor % 10;
                result = i > 57 ? i - 10 : i;
            } else {
                result = integer;
            }
            sb.append((char) result);
        });

        return sb.toString();
    }
}
