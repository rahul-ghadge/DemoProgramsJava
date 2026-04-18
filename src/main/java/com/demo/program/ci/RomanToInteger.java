package com.demo.program.ci;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        // Map to store the Roman numerals and their corresponding values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        // Loop through each character in the Roman numeral string
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            total = (currentValue < prevValue) ? total - currentValue : total + currentValue;

            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        // Test cases
        String roman1 = "III";    // 3
        String roman2 = "IV";     // 4
        String roman3 = "IX";     // 9
        String roman4 = "LVIII";  // 58
        String roman5 = "MCMXCIV"; // 1994

        System.out.println(roman1 + " -> " + romanToInt(roman1));
        System.out.println(roman2 + " -> " + romanToInt(roman2));
        System.out.println(roman3 + " -> " + romanToInt(roman3));
        System.out.println(roman4 + " -> " + romanToInt(roman4));
        System.out.println(roman5 + " -> " + romanToInt(roman5));
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        III -> 3
//        IV -> 4
//        IX -> 9
//        LVIII -> 58
//        MCMXCIV -> 1994