package model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Calculator {

    public static String calculator(String input) {
        String res = "";

        String[] split1 = input.split("[+*/\\-]");
        if (StringUtils.isNumeric(split1[0]) && StringUtils.isNumeric(split1[1]))  {
            if (input.contains("-")) {
                int digit = Integer.parseInt(split1[0]);
                int digit2 = Integer.parseInt(split1[1]);
                res = String.valueOf(digit - digit2);
            } else if (input.contains("+")) {
                int digit = Integer.parseInt(split1[0]);
                int digit2 = Integer.parseInt(split1[1]);
                res = String.valueOf(digit + digit2);
            } else if (input.contains("*")) {
                int digit = Integer.parseInt(split1[0]);
                int digit2 = Integer.parseInt(split1[1]);
                res = String.valueOf(digit * digit2);
            } else if (input.contains("/")) {
                int digit = Integer.parseInt(split1[0]);
                int digit2 = Integer.parseInt(split1[1]);
                res = String.valueOf(digit / digit2);
            }
        } else if(Arrays.stream(RomanNumber.values()).anyMatch(romanNumber -> romanNumber.toString().equals(split1[0])) &&
                Arrays.stream(RomanNumber.values()).anyMatch(romanNumber -> romanNumber.toString().equals(split1[1]))){
            if (input.contains("-")) {
                int digit = RomanNumber.romanToArabic(split1[0]);
                int digit2 = RomanNumber.romanToArabic(split1[1]);
                res = RomanNumber.arabicToRoman(digit - digit2);
            } else if (input.contains("+")) {
                int digit = RomanNumber.romanToArabic(split1[0]);
                int digit2 = RomanNumber.romanToArabic(split1[1]);
                res = RomanNumber.arabicToRoman(digit + digit2);
            } else if (input.contains("*")) {
                int digit = RomanNumber.romanToArabic(split1[0]);
                int digit2 = RomanNumber.romanToArabic(split1[1]);
                res = RomanNumber.arabicToRoman(digit * digit2);
            } else if (input.contains("/")) {
                int digit = RomanNumber.romanToArabic(split1[0]);
                int digit2 = RomanNumber.romanToArabic(split1[1]);
                res = RomanNumber.arabicToRoman(digit/digit2);
            }
        } else {
            throw new IllegalArgumentException(input + " wrong argument");
        }
        return res;
    }
}






