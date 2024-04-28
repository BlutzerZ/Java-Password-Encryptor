package com.blutzerz.uicsv;

import com.blutzerz.data.DataPassword;
import com.blutzerz.page.MainPage;

public class App {
    public static void main(String[] args) throws Exception {
        DataPassword.loadCSVData();
        new MainPage(70).draw();
    }
}
