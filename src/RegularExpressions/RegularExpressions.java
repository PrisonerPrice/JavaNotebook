// reference: https://www.vogella.com/tutorials/JavaRegularExpressions/article.html

package RegularExpressions;

public class RegularExpressions {

    private static String myString = "qwertyuio123456!@#$%^&*(";
    private static String TAG_COMMON_SYMBOLS = "Common Matching Symbols";
    private static String TAG_META_CHARACTERS = "Meta Characters";
    private static String TAG_QUANTIFIER = "Quantifier";

    public static void main(String[] args) {

        /////////////////////////////
        // Common Matching Symbols //
        /////////////////////////////

        // . Matches any character
        //print(TAG_COMMON_SYMBOLS, ".");

        // ^regex Finds regex that must match at the beginning of the line
        //print(TAG_COMMON_SYMBOLS, "^qwe"); // "qwe" is replaced by "!"
        //print(TAG_COMMON_SYMBOLS, "^wer");

        // regex$ Finds regex that must match at the end of the line
        //print(TAG_COMMON_SYMBOLS, "($");  // throws exception

        // [abc] a or b or c
        //print(TAG_COMMON_SYMBOLS, "[qe]");

        // [abc][vz] a or b or c, followed by either v or z
        //print(TAG_COMMON_SYMBOLS, "[qc][wk][ex]");
        //print(TAG_COMMON_SYMBOLS, "[qc][m][ex]");

        // [^abc] all characters other than abc
        //print(TAG_COMMON_SYMBOLS, "[^qwe]");

        // [a-d1-7] range
        //print(TAG_COMMON_SYMBOLS, "[a-f1-7]");

        // X|Z Finds X or Z

        // XZ Finds XZ

        // $ Checks if a line end follows
        //print(TAG_COMMON_SYMBOLS, "$");

        /////////////////////
        // Meta Characters //
        /////////////////////

        // \d Any digit for [0-9]
        //print(TAG_META_CHARACTERS, "\\d");

        // \D A non-digit for [^0-9]
        //print(TAG_META_CHARACTERS, "\\D");

        // \s A white space character
        //print(TAG_META_CHARACTERS, "\\s");

        // \S A non-whitespace character
        //print(TAG_META_CHARACTERS, "\\S");

        // \w A word character

        // \W A non-word character
        //print(TAG_META_CHARACTERS, "\\W");

        // \S+ Several non-whitespace characters
        //print(TAG_META_CHARACTERS, "\\S+");

        // \b Matches a word boundary // add "!" at the beginning and ending of the word
        //print(TAG_META_CHARACTERS, "\\b");

        ////////////////
        // Quantifier //
        ////////////////

        // * Occurs zero or more time, eg X* Finds no or several letter X; eg .* finds any character sequence
        //print(TAG_QUANTIFIER, "q*");
        //print(TAG_QUANTIFIER, ".*");
    }

    public static void print(String tag, String regex) {
        System.out.println("<<<<< " + tag + ": " + regex);
        System.out.println(myString);
        System.out.println(myString.replaceAll(regex, "!"));
        System.out.println("<<<<<");
    }
}
