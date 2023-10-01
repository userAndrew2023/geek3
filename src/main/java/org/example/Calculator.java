package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static float sum(List<? extends Number> list) {
        float result = 0;
        for (Number number : list) {
            result += number.floatValue();
        }
        return result;
    }

    public static int binaryToInt(String binary) {
        try {
            return Integer.parseInt(binary, 2);
        } catch (NumberFormatException e) {
            System.err.println("Invalid binary input: " + binary);
            return 0; // Return a default value or handle the error as needed
        }
    }

    public static String intToBinary(int value) {
        return Integer.toBinaryString(value);
    }

    public static int roundToNearestInt(double value) {
        return (int) Math.round(value);
    }

    public static int roundToNearestInt(float value) {
        return Math.round(value);
    }

    public static float mul(List<? extends Number> list) {
        float result = 1;
        for (Number number : list) {
            result *= number.floatValue();
        }
        return result;
    }

    public static float div(List<? extends Number> list) {
        float result = list.get(0).floatValue();
        var first = true;
        for (Number number : list) {
            if (first) {
                first = false;
                continue;
            }
            result /= number.floatValue();
        }
        return result;
    }

    public static List<Object> toBinaryString(List<Object> values) {
        var newValues = new ArrayList<>();
        for (var value : values) {
            if (value instanceof Integer) {
                newValues.add(Integer.toBinaryString((Integer) value));
            } else if (value instanceof Double) {
                newValues.add(Long.toBinaryString(Math.round((Double) value)));
            } else if (value instanceof Float) {
                newValues.add(Integer.toBinaryString(Math.round((Float) value)));
            } else if (value instanceof String) {
                newValues.add(Integer.toBinaryString((int) Float.parseFloat((String) value)));
            }
        }
        return newValues;
    }
    public static void main(String[] args) {
        System.out.println(toBinaryString(List.of("3.0")));
    }
}
