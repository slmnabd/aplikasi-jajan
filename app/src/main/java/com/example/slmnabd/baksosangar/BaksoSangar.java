package com.example.slmnabd.baksosangar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BaksoSangar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakso_sangar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.admin:
                // do something
                Intent moveadmin = new Intent(getApplicationContext(),ManagementProduct.class);
                this.startActivity(moveadmin);
                this.finish();
                return true;
            case R.id.recordTransaksi:
                // do something
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
