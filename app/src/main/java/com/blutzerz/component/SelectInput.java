package com.blutzerz.component;

public class SelectInput implements Component {
    private String[] selection;
    private int value;
    private Label label;
    private Input input;

    public SelectInput(String label, String[] selection, int width) {
        this.selection = selection;
        this.label = new Label(label, width);
        this.input = new Input("Pilihan");
    }

    @Override
    public void draw() {
        this.label.draw();

        for (int i = 0; i < this.selection.length; ++i) {
            this.label.text = "  [" + (i + 1) + "] " + this.selection[i];
            this.label.draw();
        }

        this.input.draw();
        this.value = this.input.getValueInt();
    }

    public int getValue() {
        return this.value;
    }
}