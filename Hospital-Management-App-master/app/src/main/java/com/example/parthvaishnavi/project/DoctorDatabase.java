package com.example.parthvaishnavi.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorDatabase extends AppCompatActivity {
    DBHelper myDb;
    EditText Fname, Lname, Age, department, fees, phone_number;
    Button submit,btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_database);
        myDb = new DBHelper(this);

        Fname = (EditText) findViewById(R.id.fname);
        Lname = (EditText) findViewById(R.id.last_name);
        Age = (EditText) findViewById(R.id.age);
        department = (EditText) findViewById(R.id.dept);
        fees = (EditText) findViewById(R.id.fees);
        phone_number=(EditText) findViewById(R.id.phone);

        submit = (Button) findViewById(R.id.submit);
        btnViewAll=(Button) findViewById(R.id.btnViewAll);
        AddData();
        viewAll();
//        UpdateData();

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        DoctorDatabase.super.onBackPressed();
                    }
                }).create().show();
    }

//    public void UpdateData() {
//        btnviewUpdate.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
//                                editName.getText().toString(),
//                                editSurname.getText().toString(), editMarks.getText().toString(), editName.getText().toString(),
//                                editSurname.getText().toString(), editSex.getText().toString());
//                        if (isUpdate == true)
//                            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }

    public void AddData() {
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(Fname.getText().toString(),
                                Lname.getText().toString(),
                                Age.getText().toString(), fees.getText().toString(),
                                department.getText().toString(), phone_number.getText().toString()  );
                        if (isInserted == true)
                            Toast.makeText(DoctorDatabase.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DoctorDatabase.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Surname :" + res.getString(4) + "\n");
                            buffer.append("Marks :" + res.getString(5) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}




