package com.example.ayush.customdialogapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    ArrayList<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar();

        customAdapter adapter = new customAdapter(this,list);
        ListView listView = (ListView) findViewById(R.id.myListView);
        listView.setAdapter(adapter);
        //Adapter is attached to the listview and the list

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //inflates menu
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //calls dialog on option selection
        fillDialog();
        return super.onOptionsItemSelected(item);
    }

    public void fillDialog(){
        dialog = new Dialog(MainActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.show();
        Button bt_save = (Button) dialog.findViewById(R.id.button);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et1 = (EditText) dialog.findViewById(R.id.et_nameew);
                final EditText et2 = (EditText) dialog.findViewById(R.id.et_email);
                final EditText et3 = (EditText) dialog.findViewById(R.id.et_dateOfBirth);
                //gets text from each edittext
                String name = et1.getText().toString();
                String email = et2.getText().toString();
                String dob = et3.getText().toString();
                if(name.equals("")|| email.equals("")||dob.equals("")){
                    //if user hasnt entered all info
                    Toast.makeText(MainActivity.this, "Please enter all the details", Toast.LENGTH_LONG).show();
                }
                else {
                    //adds data to an arraylist
                    Data data = new Data();
                    data.setName(name);
                    data.setEmail(email);
                    data.setDate(dob);
                    list.add(data);
                }
                //the dialog is then dismissed
                dialog.dismiss();
            }
        });
        Button bt_cancel = (Button) dialog.findViewById(R.id.button2);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //automatically dismisses the dialog on pressing the cancel button
                dialog.dismiss();
            }
        });
    }

}
