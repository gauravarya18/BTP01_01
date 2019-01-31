package com.example.gauravarya.btp_01_1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import io.paperdb.Paper;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Localhelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.tv1);

        Paper.init(this);
        String language=Paper.book().read("language");
        if(language==null)
            Paper.book().write("language","en");

        updateView((String)Paper.book().read("language"));

    }

    private void updateView(String lang){
        Context context = Localhelper.setLocale(this,lang);
        Resources resources =context.getResources();
        textView.setText(resources.getString(R.string.hello));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else
        if(item.getItemId()==R.id.language_bn)
        {
            Paper.book().write("language","bn");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId()==R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId()==R.id.language_gu)
        {
            Paper.book().write("language","gu");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
}
