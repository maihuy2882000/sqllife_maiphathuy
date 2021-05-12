package com.example.sql_life_demo_maiphathuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public DatabaseHandler db;
    public ListView lv;
    public List<Student>list;
    ArrayAdapter adt;
    public Button btntim;
    public Button btnXoa;
    public Button btnAdd;
    private String idItem;
    private lvApdapter lvApdapters;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
//        Student s = new Student(124, "hai");
//        Student s1 = new Student(125, "long");
//        Student s2 = new Student(126, "lan");
//        Student s3 = new Student(127, "thu");
//        db.addStudent(s);
//        db.addStudent(s1);
//        db.addStudent(s2);
//        db.addStudent(s3);
        Log.d("tag","oncreate");
        lv = (ListView)findViewById(R.id.listview);
        list = db.getAllStudents();
        lvApdapters = new lvApdapter(this,R.layout.itemlayout,list);
       // adt = new ArrayAdapter(MainActivity.this, R.layout.itemlayout,list)
        lv.setAdapter(lvApdapters);

        btntim = (Button)findViewById(R.id.btntim);
        btntim.setOnClickListener(this);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                idItem = String.valueOf((TextView) view.findViewById(R.id.tvid));

            }
        });
//        Intent intent = new Intent(MainActivity.this, listviewListenner.class);
//        intent.putExtra("id",idItem);
//        this.startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btntim:
                Student s1 ;
                int ma;
                EditText ed;
                ed = (EditText)findViewById(R.id.editText);
                ma = Integer.parseInt(ed.getText().toString());
                s1 = db.getStudent(ma);
                List<Student> list1 = new ArrayList<>();
                list1.add(s1);
                lvApdapters = new lvApdapter(this,R.layout.itemlayout,list1);
                lv.setAdapter(lvApdapters);
                break;

            case R.id.btnAdd:

                TextView tvname = findViewById(R.id.edittextname);
                String name = tvname.getText().toString();
                Student s = new Student(name);
                db.addStudent(s);
                lv = (ListView)findViewById(R.id.listview);
                list = db.getAllStudents();
                lvApdapters = new lvApdapter(this,R.layout.itemlayout,list);
                // adt = new ArrayAdapter(MainActivity.this, R.layout.itemlayout,list)
                lv.setAdapter(lvApdapters);
                break;
        }
    }
}