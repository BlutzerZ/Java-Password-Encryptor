package com.blutzerz.component;

import java.util.Scanner;

public class Input implements Component {
    protected String label;
    private Scanner input;
    private String value;

    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    @Override
    public void draw() {
        System.out.print("|  " + this.label + " : ");
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