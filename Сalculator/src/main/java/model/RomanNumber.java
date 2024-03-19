package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumber {
    /**
     * Напомним, что в римской системе счисления I обозначает 1, V обозначает 5, X — 10, L — 50, C — 100, D — 500, M — 1000.
     * Например, число 3 в римской системе счисления будет обозначаться как III.
     */
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private int value;

    RomanNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public static List<RomanNumber> getReverseSortedValues() {
        return Arrays.stream(values()).sorted(Comparator.comparing((RomanNumber e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumber> romanNumerals = RomanNumber.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumber symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        List<RomanNumber> romanNumbers = RomanNumber.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((number > 0) && (i < romanNumbers.size())) {
            RomanNumber currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }


}










