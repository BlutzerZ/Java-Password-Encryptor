package com.blutzerz.component;

public class HLine implements Component {
    int width;

    public HLine(int width) {
        this.width = width;
    }

    public void draw() {
        System.out.print("+");
        for (int i = 0; i <= this.width; i++) {
            System.out.print("=");
        }
        System.out.print("+\n");
    }
}
