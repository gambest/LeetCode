package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
    public static boolean validAnagram1(String s, String t){
        if (s.length() != t.length()) return false;
        Map<Character, Integer> characterIntegerMapS = new HashMap<>();
        char[] analysedChar = {'a'};
        for (int i = 0; i < s.length(); i++){
            s.getChars(i,i+1,analysedChar,0);
            System.out.println(analysedChar[0]);
            if (characterIntegerMapS.containsKey(analysedChar[0])){
                characterIntegerMapS.put(analysedChar[0],characterIntegerMapS.get(analysedChar[0])+1);
            } else{
                characterIntegerMapS.put(analysedChar[0],1);
            }
        }
        Map<Character, Integer> characterIntegerMapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            t.getChars(i,i+1,analysedChar,0);
            System.out.println(analysedChar[0]);
            if (characterIntegerMapT.containsKey(analysedChar[0])){
                characterIntegerMapT.put(analysedChar[0],characterIntegerMapT.get(analysedChar[0])+1);
            } else{
                characterIntegerMapT.put(analysedChar[0],1);
            }
        }
        System.out.println(characterIntegerMapS);
        System.out.println(characterIntegerMapT);
        return characterIntegerMapS.equals(characterIntegerMapT);
    }
    public static boolean validAnagram2(String s, String t){
        if (s.length() != t.length()) return false;
        char[] chars = new char[s.length()];

        int hashcodeS = 0;
        int hashcodeT = 0;

        s.getChars(0,s.length(),chars,0);

        for (char chara:chars){
            System.out.println(chara-96);
            hashcodeS += (chara-96)^(chara-95)+(chara-94)+(chara-93);
        }
        System.out.println(hashcodeS);

        t.getChars(0,s.length(),chars,0);

        for (char chara:chars){
            System.out.println(chara-96);
            hashcodeT += (chara-96)^(chara-95)+(chara-94)+(chara-93);
        }

        System.out.println(hashcodeT);

        return hashcodeS == hashcodeT;
    }
}
