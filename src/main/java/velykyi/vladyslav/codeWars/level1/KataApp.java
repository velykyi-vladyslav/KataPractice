package velykyi.vladyslav.codeWars.level1;

@SuppressWarnings("unused")
public class KataApp {

    /**
     * Method to test KATA tasks
     * @param args ignored
     */
    public static void main(String[] args) {

    }

    /**
     * Given an integral number, determine if it's a square number.
     *
     * @param n integral number.
     * @return true if it's square, false otherwise.
     */
    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return n == 0 || sqrt % Math.round(sqrt) == 0.0;
    }

    /**
     * Function that takes an array of words and smashes them together into a sentence and returns the sentence.
     *
     * @param words words
     * @return sentence
     */
    public static String smash(String... words) {
        return String.join(" ", words);
    }

    /**
     * The first century spans from the year 1 up to and including the year 100,
     * the second century - from the year 101 up to and including the year 200, etc.
     *
     * @param number a given year.
     * @return the century it is in.
     */
    public static int century(int number) {
        // better way: (number + 99) / 100
        int century =  number / 100;
        int remnant = number % 100 + number % 10;

        if (remnant == 0) {
            return century;
        }

        return century + 1;
    }

    /**
     * A function that takes a string and return a new string with all vowels removed.
     * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
     *
     * @param str text to parse
     * @return new string with all vowels removed
     */
    public static String disemvowel2(String str) {
        return str.replaceAll("(?i)[aeiouy]", "");
    }

    /**
     * Complete the solution so that it returns true if the first argument(string) passed in
     * ends with the 2nd argument (also a string).
     */
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
}
