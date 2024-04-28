package com.blutzerz.page;

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
    }

    @Override
    public void drawContent() {
        new HLine(this.width).draw();
        new Space(this.width).draw();
        new Label("Input Password", this.width).draw();

        new Space(this.width).draw();

        nameInput.draw();
        this.nameInput = new Input("Judul Password");
        usernameInput.draw();
        this.usernameInput = new Input("Username");
        passwordInput.draw();
        this.passwordInput = new Input("Password");

        String[] pilihan = { "Belum terkategori", "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya" };

        SelectInput catInput = new SelectInput("Inputan Password", pilihan, this.width);
        catInput.draw();
        new Space(this.width).draw();
        new HLine(this.width).draw();

        try {
            passStr = new PasswordStore(this.nameInput.getValue(), this.usernameInput.getValue(),
                    this.passwordInput.getValue(), this.catInput.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataPassword.passData.add(passStr);
            DataPassword.saveCSVData();

            new Label("----- -----", this.width);
            new Label("Password berhasil disimpan", this.width).draw();
            new Space(this.width).draw();
            new HLine(this.width).draw();
            new MainPage(this.width).draw();
        }
    }
}
