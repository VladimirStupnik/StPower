package model;

import java.util.HashMap;
import java.util.TreeMap;

public class Converter {
    private HashMap<Character, Integer> romanMap = new HashMap<>();
    private TreeMap<Integer, String> arabicMap = new TreeMap<>();
    public Converter() {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        arabicMap.put(1, "I");
        arabicMap.put(4, "IV");
        arabicMap.put(5, "V");
        arabicMap.put(9, "IX");
        arabicMap.put(10, "X");
        arabicMap.put(40, "XL");
        arabicMap.put(50, "L");
        arabicMap.put(90, "XC");
        arabicMap.put(100, "C");
        arabicMap.put(400, "CD");
        arabicMap.put(500, "D");
        arabicMap.put(900, "CM");
        arabicMap.put(1000, "M");
    }

    public String arabicToRoman(int arabic){
        String res = "";
        int arabian;
        do{
            arabian = arabicMap.floorKey(arabic);
            res += arabicMap.get(arabian);
            arabic -= arabian;
        } while (arabic != 0);
            return res;
    }

    public  boolean isRoman(String number){
        return romanMap.containsKey(number.charAt(0));
    }

    public int romanToArabic(String roman) {
        int len = roman.length() - 1;
        char[] mass = roman.toCharArray();
        int arab;
        int res = romanMap.get(mass[len]);
        for (int i = len - 1; i >= 0 ; i--) {
            arab = romanMap.get(mass[i]);
            if(arab < romanMap.get(mass[i + 1])){
                res -= arab;
            } else {
                res += arab;
            }
        }
        return res;
    }
}
