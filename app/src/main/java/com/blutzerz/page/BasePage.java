package com.blutzerz.page;

import java.util.ArrayList;

import com.blutzerz.component.Component;
import com.blutzerz.component.HLine;
import com.blutzerz.component.Label;
import com.blutzerz.component.Space;

public abstract class BasePage {
    public String title;
    public int width;
    protected HLine hline;
    protected Space space;
    protected Label label;
    protected ArrayList<Component> components;

    public BasePage(String title, int width) {
        this.title = title;
        this.width = width;
    }

    public void draw() {
        this.drawHeader();
        new Label("Input Password", this.width).draw();
        this.drawFooter();
    }

    public void drawHeader() {
        new HLine(this.width).draw();
        new Space(this.width).draw();
    }

    public void drawFooter() {
        new Space(this.width).draw();
        new HLine(this.width).draw();
    }

    public abstract void drawContent();

}
