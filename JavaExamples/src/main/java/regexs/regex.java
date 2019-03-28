package regexs;

import java.util.regex.*;

class regex {
    private static String digitPattern = "\\d+";

    private static String problemfirst = "\\\\";
    private static String prbloemsec = "[\\\\btnfr\'\"]";

    public static void main(String[] args) {
        //matches 匹配全部
        String digitcontent = "00000000";

        System.out.println(Pattern.matches(digitPattern, digitcontent));

        digitcontent = "\\";

        System.out.println(Pattern.matches(problemfirst, digitcontent));

        digitcontent = "\\b";
        System.out.println(Pattern.matches(prbloemsec, digitcontent));
    }

}