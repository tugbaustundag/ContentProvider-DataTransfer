package com.myuser;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    TextView resultView=null;
    CursorLoader cursorLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView= (TextView) findViewById(R.id.res);
    }


    public void onClickDisplayNames(View view) {
        getSupportLoaderManager().initLoader(1, null, this);
    }
    //MyProvider uygulamadaki Content Provider URI'sını tanımladım ve datayı yükledim
    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        cursorLoader= new CursorLoader(this, Uri.parse("content://com.myprovider.MyProvider/cte"), null, null, null, null);
        return cursorLoader;
    }
    //URI'sını kullandıgım Content Provider'a ait databaseden aldığım verileri listeledim
    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            StringBuilder res=new StringBuilder();
            while (!cursor.isAfterLast()) {
                res.append("\n"+cursor.getString(cursor.getColumnIndex("id"))+ "-"+ cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }

            resultView.setText(res);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
