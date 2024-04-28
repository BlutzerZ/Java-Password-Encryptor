package com.blutzerz.page;

import com.blutzerz.component.HLine;
import com.blutzerz.component.Label;
import com.blutzerz.component.Space;
import com.blutzerz.data.DataPassword;
import com.blutzerz.encryptor.PasswordStore;

public class DetailPage extends BasePage {
    private PasswordStore passStr;

    public DetailPage(int width) {
        super("Detail Page", width);
    }

    @Override
    public void drawContent() {
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        new Label("Terdapat " + DataPassword.passData.size() + " tersimpan", this.width).draw();
        new Label("----- ----- -----", this.width);
        for (PasswordStore ps : DataPassword.passData) {
            try {
                new Label(String.format("| %-15s | %-15s | %-15s | %-15s | %-15s", ps.name, ps.username,
                        ps.getCategory(), ps.getPassword(), ps.getScore()), this.width)
                        .draw();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        new Space(this.width).draw();
        new HLine(this.width).draw();
        new MainPage(this.width).draw();
    }
}
