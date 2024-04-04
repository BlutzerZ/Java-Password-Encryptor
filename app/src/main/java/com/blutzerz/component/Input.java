package com.blutzerz.component;

import java.util.Scanner;

public class Input {
    String label;
    Scanner input = new Scanner(System.in);
    String value;

    public Input(String label) {
        this.label = label;
    }

    public void draw() {
        System.out.print("|  " + label + " :");
        this.value = this.input.nextLine();
    }

    public String getValue() {
        return this.value;
    }

    public int getValueInt() {
        return Integer.parseInt(this.value);

    }

    public double getValueDouble() {
        return Double.parseDouble(this.value);
    }
}
