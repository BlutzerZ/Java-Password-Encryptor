package com.blutzerz.component;

public class Label implements Component {
    int width;
    public String text;

    public Label(String text, int width) {
        this.text = text;
        this.width = width;
    }

    public void draw() {
        System.out.print("|  " + this.text);
        for (int i = 0; i <= this.width - 2 - this.text.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|\n");
    }
}