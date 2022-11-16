package com.common;

import java.util.Arrays;

public enum Color {
    RED(0, "red", "#FF0000"),
    YELLOW(1, "red", "#FF0000"),
    BLUE(2, "red", "#FF0000");

    Color(int id, String name, String rgbValue) {
        this.id = id;
        this.name = name;
        this.rgbValue = rgbValue;
    }

    public final Integer id;

    public final String name;

    public final String rgbValue;

    public static Color getById(Integer id) {
        Color[] colors = Color.values();
        for (Color color : colors) {
            if (color.id.equals(id)) {
                return color;
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Color color = Color.getById(2);
        switch (color) {
            case RED:
                System.out.println("gaga");
            case YELLOW:
                System.out.println("haha");
            default:
                System.out.println("kaka");
                break;
        }
    }
}