package regexs;

import java.util.regex.*;

class regex {
    private static String digitPattern = "\\d+";

    private static String problemfirst = "\\\\";
    private static String prbloemsec = "[\\\\btnfr\'\"]";

    private static String level = "S|A|B|C|R|A\\+|S\\+|未知";
    private static String time = "(2[0-3]|[01]?[0-9]):([0-5][0-9])";

    private static String num = "0|1|0\\.\\d+|1\\.0+";

    private static String Aplus = "A\\+";

    public static void main(String[] args) {
        //matches 匹配全部
        String digitcontent = "00000000";

        System.out.println(Pattern.matches(num, "0."));

        System.out.println(Pattern.matches(time,"21:59"));

        System.out.println(Pattern.matches(level, "S"));

        System.out.println(Pattern.matches(digitPattern, digitcontent));

        digitcontent = "\\";

        System.out.println(Pattern.matches(problemfirst, digitcontent));

        digitcontent = "\\b";
        System.out.println(Pattern.matches(prbloemsec, digitcontent));
    }

}