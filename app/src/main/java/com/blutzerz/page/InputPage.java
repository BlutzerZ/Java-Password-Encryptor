package com.blutzerz.page;

import java.util.Iterator;

import com.blutzerz.component.*;
import com.blutzerz.data.*;
import com.blutzerz.encryptor.PasswordStore;

public class InputPage extends BasePage {
    private Input nameInput;
    private Input usernameInput;
    private Input passwordInput;
    private SelectInput catInput;
    private PasswordStore passStr;

    public InputPage(int width) {
        super("Input Password", width);

        this.nameInput = new Input("Judul Password");
        this.components.add(nameInput);

        this.usernameInput = new Input("Username");
        this.components.add(usernameInput);

        this.passwordInput = new Input("Password");
        this.components.add(passwordInput);

        String[] kategori = { "Belum terkategori", "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya" };
        this.catInput = new SelectInput("Kategori", kategori, this.width);
        this.components.add(catInput);

        this.components.add(new Label("---- ----", this.width));
        this.components.add(new Label("Input password berhasil dibuat!", this.width));
    }

    @Override
    public void drawContent() {
        Iterator loop = this.components.iterator();

        while (loop.hasNext()) {
            Component widget = (Component) loop.next();
            widget.draw();
        }

        int id = DataPassword.passData.size() + 1;
        String name = this.nameInput.getValue();
        String username = this.usernameInput.getValue();
        String password = this.passwordInput.getValue();
        int select = this.catInput.getValue() - 1;

        this.passStr = new PasswordStore(id, name, username, password, select);
        DataPassword.passData.add(passStr);
        DataPassword.saveCSVData();

        drawFooter();
        new MainPage(this.width).draw();
    }
}
