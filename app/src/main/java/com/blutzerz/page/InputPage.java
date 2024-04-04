package com.blutzerz.page;

import com.blutzerz.component.*;
import com.blutzerz.data.*;
import com.blutzerz.encryptor.PasswordStore;

public class InputPage {
    String label;
    int width;
    String nama;
    String username;
    String password;
    int category;

    public InputPage(String label, int width) {
        this.label = label;
        this.width = width;
    }

    public void draw() throws Exception {
        new HLine(this.width).draw();
        new Space(this.width).draw();
        new Label("Input Password", this.width).draw();
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        Input nama = new Input("Judul Password");
        Input username = new Input("Username");
        Input password = new Input("Password");
        nama.draw();
        this.nama = nama.getValue();
        username.draw();
        this.username = username.getValue();
        password.draw();
        this.password = password.getValue();

        String[] pilihan = { "Belum terkategori", "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya" };

        SelectInput pilSelect = new SelectInput(this.label, pilihan, this.width);
        pilSelect.draw();
        this.category = pilSelect.getValue();
        new Space(this.width).draw();
        new HLine(this.width).draw();

        PasswordStore passwordStore = new PasswordStore(this.nama, this.username, this.password, this.category);
        DataPassword.passData.add(passwordStore);
        DataPassword.saveCSVData();

        new Label("----- -----", this.width);
        new Label("Password berhasil disimpan", this.width).draw();
        new Space(this.width).draw();
        new HLine(this.width).draw();
        new MainPage("Encrypted Password Store", this.width).draw();
    }
}
