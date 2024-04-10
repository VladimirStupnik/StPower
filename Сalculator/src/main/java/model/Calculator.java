package model;

import java.util.HashMap;

public class Calculator {

    public static String calculator(String input) {
        Converter converter = new Converter();
        String[] actions = {" + "," - "," * "," / "};
        String[] regIndex = {" \\+ "," - ", " \\* "," / "};
        int actionIndex = -1;
        int res = 0;
        for (int i = 0; i < actions.length; i++) {
            if(input.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex == -1){
            throw new IllegalArgumentException("Incorrect expression");
        }
        String[] split = input.split(regIndex[actionIndex]);
        if(converter.isRoman(split[0]) == converter.isRoman(split[1])){
            int a,b;
            boolean roman = converter.isRoman(split[0]);
            if(roman){
                a = converter.romanToArabic(split[0]);
                b = converter.romanToArabic(split[1]);
            } else {

                a = Integer.parseInt(split[0]);
                b = Integer.parseInt(split[1]);
            }
            if(a > 10 || b > 10){
                throw new IllegalArgumentException("Number is greater than 10");
            }
            switch (actions[actionIndex]){
                case " + ":
                    res = a+b;
                    break;
                case " - ":
                    res = a-b;
                    break;
                case " * ":
                    res = a * b;
                    break;
                default:
                    res = a / b;
                    break;
            }
            if(roman){
                return converter.arabicToRoman(res);
            }
        } else {
            throw new IllegalArgumentException("Numbers must be in the same format");
        }
        return String.valueOf(res);
    }
}

