package vn.hungpham.app.visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created SeesaaVN on 10/2/17.
 */

public class Codiliti {
    public static int solution(int N) {
        // write your code in Java SE 8
        String binary = Integer.toBinaryString(N);
        int count  = 0;
        String str = "0";
        while (str.length()<binary.length()){
            String regex = "1"+str+"1";
            if (binary.contains(regex)){
                count = str.length();
            }
            str += "0";
        }
        return count;
    }
}
