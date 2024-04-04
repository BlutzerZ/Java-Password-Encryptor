package com.blutzerz.component;

import java.util.Scanner;

public class SelectInput {
    String[] selection;
    int width;
    String label;
    int value;
    Scanner input = new Scanner(System.in);

    public SelectInput(String label, String[] selection, int width) {
        this.label = label;
        this.selection = selection;
        this.width = width;
    }

    public void draw() {
        new Label(this.label, 50).draw();
        int i = 1;
        for (String s : selection) {
            new Label("  [" + i + "] " + s, 50).draw();
            i++;
        }
        System.out.print("|  Pilihan: ");
        this.value = this.input.nextInt();
    }

    public int getValue() {
        return value;
    }
}