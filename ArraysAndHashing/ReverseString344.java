package ArraysAndHashing;

public class ReverseString344 {
    public static void reverseString(char[] s) {
        char p;
        for (int i = 0; i < s.length/2;i++){
            p = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = p;
        }
        System.out.println(s);
    }
}
