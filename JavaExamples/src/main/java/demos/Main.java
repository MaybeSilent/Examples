package demos;

import java.util.*;

public class Main
{

    private static int whiteMax = Integer.MIN_VALUE;
    private static int whitesecond = Integer.MIN_VALUE;

    private static int blackMax = Integer.MIN_VALUE;
    private static int blacksecond = Integer.MIN_VALUE;
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n, m;
        n = cin.nextInt();
        m = cin.nextInt();

        HashMap<Integer,Integer> white = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> black = new HashMap<Integer,Integer>();
        int blackCount = 0;
        int whiteCount = 0;

        for (int i = 0; i < n; i++) {
            boolean whiteFlag = (i % 2 == 0);
            for(int j = 0; j < m; j++) {
                int num = cin.nextInt();
                if (whiteFlag) {
                    if (!white.containsKey(num)) {
                        white.put(num,1);
                    } else {
                        white.put(num,white.get(num) + 1);
                    }
                    whiteCount ++;
                } else {
                    if (!black.containsKey(num)) {
                        black.put(num,1);
                    } else {
                        black.put(num,black.get(num) + 1);
                    }
                    blackCount ++;
                }
                whiteFlag = !whiteFlag;
            }
        }

        for (int i : white.keySet()) {
            if (white.get(i) >= whiteMax) {
                whitesecond = whiteMax;
                whiteMax = i;
            } else if (white.get(i) > whitesecond) {
                whitesecond = white.get(i);
            }
        }

        for (int i : black.keySet()) {
            if (black.get(i) >= blackMax) {
                blacksecond = blackMax;
                blackMax = i;
            } else if (black.get(i) > blacksecond) {
                blacksecond = black.get(i);
            }
        }

        int ans = 0;
        if (whiteMax != blackMax) {
            int changewhite = white.containsKey(whiteMax) ? whiteCount - white.get(whiteMax) : 0;
            int changeblack = black.containsKey(blackMax) ? blackCount - black.get(blackMax) : 0;
            ans = changewhite + changeblack;
        }

        else {
            int ans1 = 0;
            int changewhite1 = white.containsKey(whiteMax) ? whiteCount - white.get(whiteMax) : 0;
            int changeblack1 = black.containsKey(blacksecond) ? blackCount - black.get(blacksecond) : blackCount;
            ans1 = changewhite1 + changeblack1;

            int ans2 = 0;
            int changewhite2 = white.containsKey(whitesecond) ? whiteCount - white.get(whitesecond) : whiteCount;
            int changeblack2 = black.containsKey(blackMax) ? blackCount - black.get(blackMax) : 0;
            ans2 = changewhite2 + changeblack2;

            ans = Math.min(ans1,ans2);
        }

        System.out.println(ans);

    }

}
