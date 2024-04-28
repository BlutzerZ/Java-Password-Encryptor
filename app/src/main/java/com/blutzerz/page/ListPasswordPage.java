package com.blutzerz.page;

import com.blutzerz.component.*;
import com.blutzerz.data.*;
import com.blutzerz.encryptor.PasswordStore;

public class ListPasswordPage extends BasePage {

    public ListPasswordPage(int width) {
        super("List Password", width);
    }

    @Override
    public void drawContent() {
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        new Label("Terdapat " + DataPassword.passData.size() + " tersimpan", this.width).draw();
        new Label("----- ----- -----", this.width);
        for (PasswordStore ps : DataPassword.passData) {
            new Label(String.format("| %-15s | %-15s | %-15s |", ps.name, ps.username, ps.getCategory()), this.width)
                    .draw();
        }
        new Space(this.width).draw();
        new HLine(this.width).draw();
        new MainPage(this.width).draw();
    }
}
