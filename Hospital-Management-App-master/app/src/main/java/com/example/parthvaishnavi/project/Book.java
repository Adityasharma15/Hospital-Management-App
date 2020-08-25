package com.example.parthvaishnavi.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Book extends AppCompatActivity {
    ArrayList<String> titlearray, department, fee;
    ArrayList imagearray;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listView = findViewById(R.id.listView);
        initArray();
        MyCustomListAdapter aa = new MyCustomListAdapter(Book.this, titlearray, department, imagearray, fee);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                titlearray.get(position);
                Toast.makeText(Book.this, "kedpar", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(Book.this);
                alertDialog2.setTitle("Confirm");
                alertDialog2.setMessage("Do you want to Book an Appointment ?");
//                alertDialog2.setIcon(R.drawable.delete);
                alertDialog2.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent();
                                intent.setData(Uri.parse("sms:"));
                                Intent.createChooser(intent, "Send SMS");
                                intent.putExtra("sms_body", "");
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                            }
                        });

                alertDialog2.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                alertDialog2.show();
            }
        });

    }

    private void initArray() {
        titlearray = new ArrayList<String>();
        titlearray.add("Aditya Sharma");
        titlearray.add("Anant Kedia");
        titlearray.add("Parth Vaishnavi");
        titlearray.add("Akshat Kishore");
        titlearray.add("Kaushal Gupta");
        titlearray.add("Shubham Upadhyaya");
        titlearray.add("Piyush Gupta");

        department = new ArrayList<String>();
        department.add("Neurologist");
        department.add("Cardiologist");
        department.add("Dentist");
        department.add("General Physician");
        department.add("Radiologist");
        department.add("Eye Doctor");
        department.add("Surgeon");

        imagearray = new ArrayList<>();
        imagearray.add(R.drawable.neurologist);
        imagearray.add(R.drawable.cardiologist);
        imagearray.add(R.drawable.dentist);
        imagearray.add(R.drawable.gp);
        imagearray.add(R.drawable.radiologist);
        imagearray.add(R.drawable.eye);
        imagearray.add(R.drawable.surgeon);

        fee = new ArrayList<String>();
        fee.add("2500");
        fee.add("1800");
        fee.add("1700");
        fee.add("1900");
        fee.add("2500");
        fee.add("1800");
        fee.add("1900");

    }
}
