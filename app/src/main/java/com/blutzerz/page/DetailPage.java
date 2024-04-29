package com.blutzerz.page;

import com.blutzerz.component.Component;
import com.blutzerz.component.HLine;
import com.blutzerz.component.Label;
import com.blutzerz.component.SelectInput;
import com.blutzerz.component.Space;
import com.blutzerz.data.DataPassword;
import com.blutzerz.encryptor.PasswordStore;
import java.util.Iterator;

public class DetailPage extends BasePage {
    PasswordStore passStr;
    SelectInput actionSelect;

    public DetailPage(int width, PasswordStore passStr) {
        super("AKUN: " + passStr.name, width);
        this.passStr = passStr;

        this.components.add(new Label("Kategori     : " + passStr.getCategory(), this.width));
        this.components.add(new Label("Username     : " + passStr.username, this.width));
        this.components.add(new Label("Password     : " + passStr.getPassword(), this.width));
        this.components.add(new Label("Encrypt      : " + passStr.getEncPassword(), this.width));
        this.components.add(new Label("Score        : " + passStr.getScore(), this.width));

        this.components.add(new Space(this.width));
        this.components.add(new HLine(this.width));
        this.components.add(new Space(this.width));

        String[] action = { "Hapus Password", "Kembali ke List Password", "Kembali ke Halaman Utama" };
        this.actionSelect = new SelectInput("Pilih aksi", action, this.width);
        this.components.add(this.actionSelect);
    }

    @Override
    public void drawContent() {
        Iterator loop = this.components.iterator();

        while (loop.hasNext()) {
            Component widget = (Component) loop.next();
            widget.draw();
        }

        int select = this.actionSelect.getValue();
        switch (select) {
            case 1:
                Iterator<PasswordStore> iterator = DataPassword.passData.iterator();

                while (iterator.hasNext()) {
                    PasswordStore pass = iterator.next();
                    if (pass.username.equals(passStr.username)) {
                        iterator.remove();
                    }
                }

                DataPassword.saveCSVData();

                new ListPasswordPage(this.width).draw();
                break;
            case 2:
                new ListPasswordPage(this.width).draw();
                break;
            case 3:
                new MainPage(this.width).draw();
                break;
            default:
                new DetailPage(this.width, this.passStr).draw();
        }

        drawFooter();
    }
}