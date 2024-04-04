package com.blutzerz.page;

import com.blutzerz.component.*;
import com.blutzerz.data.*;
import com.blutzerz.encryptor.PasswordStore;

public class ListPasswordPage {
    String label;
    int width;

    public ListPasswordPage(String label, int width) {
        this.label = label;
        this.width = width;
    }

    public void draw() throws Exception {
        new HLine(this.width).draw();
        new Space(this.width).draw();
        new Label(this.label, this.width).draw();
        ;
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        new Label("Terdapat " + DataPassword.passData.size() + " tersimpan", this.width).draw();
        new Label("----- ----- -----", this.width);
        for (PasswordStore ps : DataPassword.passData) {
            // new Label("| " + ps.name + "\t| " + ps.username + "\t| " + ps.getCategory() +
            // "\t|", this.width).draw();
            new Label(String.format("| %-15s | %-15s | %-15s |", ps.name, ps.username, ps.getCategory()), this.width)
                    .draw();
        }
        new Space(this.width).draw();
        new HLine(this.width).draw();
        new MainPage("Encrypted Password Store", this.width).draw();
    }
}
