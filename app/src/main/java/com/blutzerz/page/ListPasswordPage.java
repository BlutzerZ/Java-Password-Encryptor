package com.blutzerz.page;

import java.util.ArrayList;
import java.util.Iterator;

import com.blutzerz.component.*;
import com.blutzerz.data.*;
import com.blutzerz.encryptor.PasswordStore;

public class ListPasswordPage extends BasePage {
    Input optionInput;

    public ListPasswordPage(int width) {
        super("List Password", width);
        int totalPasswords = DataPassword.passData.size();
        this.components.add(new Label("Terdapat " + totalPasswords + " tersimpan.", this.width));
        this.components.add(new Space(this.width));

        // Print list password
        this.components.add(new Label("----- ----- -----", this.width));
        for (PasswordStore pass : DataPassword.passData) {
            this.components.add(new Label(String.format("| %-1s | %-20s | %-30s | %-30s |", pass.id, pass.name,
                    pass.username, pass.getCategory()), this.width));
        }

        this.components.add(new Space(this.width));
        this.components.add(new HLine(this.width));

        this.optionInput = new Input("Pilih index detail / [X - kembali ke main]");
        this.components.add(this.optionInput);
    }

    @Override
    public void drawContent() {
        Iterator loop = this.components.iterator();
        ArrayList<PasswordStore> dataPass = DataPassword.passData;

        while (loop.hasNext()) {
            Component widget = (Component) loop.next();
            widget.draw();
        }

        String option = this.optionInput.getValue();
        if (option.equals("X")) {
            new MainPage(this.width).draw();
        } else {
            try {
                int index = Integer.parseInt(option) - 1;
                if (index >= 0 && index < dataPass.size()) {
                    new DetailPage(this.width, (PasswordStore) dataPass.get(index)).draw();
                } else {
                    new Label("Pilihan Tidak Tersedia!", this.width).draw();
                    new ListPasswordPage(this.width).draw();
                }
            } catch (NumberFormatException e) {
                new Label("Invalid option. Please select a valid index or 'X' to return to the main page.", this.width)
                        .draw();
                new HLine(this.width).draw();
            }
        }
    }
}