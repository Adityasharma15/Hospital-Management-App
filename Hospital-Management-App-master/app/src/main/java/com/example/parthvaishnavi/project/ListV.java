package com.example.parthvaishnavi.project;

/**
 * Created by Anant Kedia on 15-08-2018.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListV extends AppCompatActivity {
    android.widget.ListView listView;
    ArrayList arrayList;
    Dialog listDialog;
    String[] val={"\"Aditya Sharma \\n Your Appointment has been Booked\",Anant Kedia \n Your Appointment has been Booked","Parth Vaishnavi \n Your Appointment has been Booked","Akshat Kishore \n Your Appointment has been Booked","Kaushal Gupta \n Your Appointment has been Booked","Shubham \n Your Appointment has been Booked","Piyush \n Your Appointment has been Booked"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Bundle extras = getIntent().getExtras();
        String value1 = null;
        if (extras != null) {
            value1 = extras.getString("value");
        }

        Toast.makeText(this, value1, Toast.LENGTH_SHORT).show();
        listView = findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListV.this, String.valueOf(position) + " " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
//
//                String name = arrayAdapter.getItem(position);
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListV.this);
//                alertDialogBuilder.setTitle("Doctor Details");
//                alertDialogBuilder.setMessage(name);
//
//
//                alertDialogBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();
//            }
//        });
//
//                AlertDialog.Builder adb = new AlertDialog.Builder(ListV.this);
//                adb.setTitle("List");
//                adb.setMessage(" selected Item is=" + parent.getItemAtPosition(position));
//                adb.setNegativeButton(android.R.string.no, null)
//                   .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        ListV.super.onBackPressed();
//                    }
//                }).create().show();
//
                showdialog();
            }
        });
    }

    private void showdialog() {
        listDialog = new Dialog(this);
        listDialog.setTitle("Select Item");
        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.list, null, false);
        listDialog.setContentView(v);
        listDialog.setCancelable(true);

        ListView list1 = listDialog.findViewById(R.id.listView);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListV.this);
                builder.setMessage("Delete item " + view)
                        .setPositiveButton("OK ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.out.println("OK CLICKED");

                            }
                        });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        listDialog.cancel();

                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Information");
                alert.show();
            }
        });
        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, val));
        listDialog.show();
    }
}
