package com.myprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Content Provider'a EditText'den verileri ekledim
    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(MyProvider.name, ((EditText) findViewById(R.id.txtName)).getText().toString());
        getContentResolver().insert(MyProvider.CONTENT_URI, values);
        //String[] arg={String.valueOf(1)};
        //getContentResolver().delete(MyProvider.CONTENT_URI, "id=?", arg);

        Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG).show();
    }
}
