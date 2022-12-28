package com.example.recyclerviewindetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ExtendedFloatingActionButton floatingActionButton;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingBtn);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       /* String url1="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMnkarzi0tR9mcKehojd3mEo8tPSes-zdIxg&usqp=CAU";
        //Picasso.get().load(url1).into(Image1);
        String url2="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgdNOxc-4OP722A7UOQOAJH7NOmKJRkOXfTi2wHZQZGMpaMbyHUDHa_0MLQrjjgyraXE0&usqp=CAU";
        String url3="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0hhSoPwHVREwo9mh7G3fpezNzqMbw6HhxzT-9rfenC7mwnV8mRcTitAWDGw5BKD7VKa4&usqp=CAU";
        String url4="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMnkarzi0tR9mcKehojd3mEo8tPSes-zdIxg&usqp=CAU";
        String url5="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV5Ye7JZQQyU_or_qTv0UQK9v5SayQ53WLj2Hfe5GV-3c-k2AFum-Uk84esVscMRAS604&usqp=CAU";
        String url6="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF-NFxucAbfsR8ranXzmUr952MOAfypy1PAQqXc0tYAhI64agBIGWo9Q4BC1oJXwfFPCc&usqp=CAU";
        String url7="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRi5PHUmbuMBFn0Wa0TM9sPL7xWkCv3GbZsQtzizxUrChMKkLjgFjzIbZaqn3lPszWYDzo&usqp=CAU";
        MyDramasData[]myDramasData=new MyDramasData[]{
                new MyDramasData("Khuda Or Mohbat", "2021 Drama",url1),
                new MyDramasData("DoBol", "2019 Drama",url2),
                new MyDramasData("Paarizaad", "2022 Drama", url3),
                new MyDramasData("Laptaa", "2020 Drama",url4),
                new MyDramasData("doll", "2020 Drama", url5),
                new MyDramasData("Laptaa", "2020 Drama", url6),
                new MyDramasData("Ishqa Ha", "2022 Drama", url7),
        };
*/
        ArrayList<MyDramasData>List=new ArrayList<>();
        List.add(new MyDramasData("Khuda Or Mohbat", "2021 Drama",R.drawable.khudaormohbat,"#F8522F"));
        List.add(new MyDramasData("DoBol", "2019 Drama",R.drawable.dobol,"#83F7DE"));
        List.add(new MyDramasData("Paarizaad", "2022 Drama",R.drawable.paarizaad,"#FAE362"));
        List.add(new MyDramasData("Laptaa", "2020 Drama",R.drawable.lapta,"#C7F819"));
        List.add(new MyDramasData("Ishqa Ha", "2022 Drama",R.drawable.ishqha,"#917DDF"));
        List.add(new MyDramasData("Ishqa Ha", "2022 Drama",R.drawable.ishqelaa,"#DAF7A6"));
        MyDramasAdapter myDramasAdapter=new MyDramasAdapter(List,MainActivity.this);
        recyclerView.setAdapter(myDramasAdapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialogbox);
                EditText editName=dialog.findViewById(R.id.etname);
                EditText editDept=dialog.findViewById(R.id.etdept);
                Button btnADD=dialog.findViewById(R.id.btnAdd);
                btnADD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="";
                        String dept="";
                        if (editName.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "file edit text", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            name=editName.getText().toString();
                        }
                        if (editDept.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "file edit text", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            dept=editDept.getText().toString();
                        }
                        List.add(new MyDramasData(name,dept,R.drawable.dobol,"#4CAF50"));
                        myDramasAdapter.notifyItemInserted(List.size()-1);
                        recyclerView.scrollToPosition(List.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });




    }
}