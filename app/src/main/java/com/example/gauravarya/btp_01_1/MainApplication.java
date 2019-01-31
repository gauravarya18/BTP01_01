package com.example.gauravarya.btp_01_1;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(Localhelper.onAttach(base,"en"));

    }
}
