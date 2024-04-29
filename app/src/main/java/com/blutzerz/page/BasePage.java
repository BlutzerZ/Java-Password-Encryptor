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
    protected ArrayList<Component> components = new ArrayList<>();

    public BasePage(String title, int width) {
        this.title = title;
        this.width = width;
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }

    public abstract void drawContent();

}
