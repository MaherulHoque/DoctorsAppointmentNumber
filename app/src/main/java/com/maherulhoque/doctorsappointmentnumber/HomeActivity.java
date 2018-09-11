package com.maherulhoque.doctorsappointmentnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    ListView listView;

    String categories[]={"Audiologist","Cardiologist","Cardiothoracic surgeon","Dentist","Endocrinologist","ENT specialist","Gynaecologist","Neurologist","Oncologist","Orthopaedic surgeon","Paediatrician","Psychiatrists","Pulmonologist","Radiologist","Veterinarian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=findViewById(R.id.listView);

        ArrayAdapter adapter=new ArrayAdapter(HomeActivity.this,R.layout.support_simple_spinner_dropdown_item,categories);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(HomeActivity.this,DoctorsListActivity.class);
                intent.putExtra("name",categories[position]);
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "Doctors' List of "+categories[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
