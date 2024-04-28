package com.blutzerz.component;

import java.util.Scanner;

public class SelectInput implements Component {
    String[] selection;
    int width;
    String label;
    int value;
    Input input;

    public SelectInput(String label, String[] selection, int width) {
        this.label = label;
        this.selection = selection;
        this.width = width;
    }

    public void draw() {
        new Label(this.label, this.width).draw();
        int i = 1;
        for (String s : selection) {
            new Label("  [" + i + "] " + s, 50).draw();
            i++;
        }
        System.out.print("|  Pilihan: ");
        this.input.draw();
        this.value = this.input.getValueInt();
    }

    public int getValue() {
        return value;
    }
}