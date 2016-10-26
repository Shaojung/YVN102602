package com.example.yvtc.yvn102602;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    Spinner spinner, spinner2;
    ArrayAdapter<String> adapter;
    ArrayList<Map<String, String>> mylist2;
    SimpleAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mylist = new ArrayList<>();
        mylist.add("芭樂");
        mylist.add("芒果");
        mylist.add("荔枝");
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item,
                            mylist);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        mylist2 = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        mylist2.add(m1);
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        mylist2.add(m2);
        HashMap<String, String> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");
        mylist2.add(m3);

        adapter2 = new SimpleAdapter(MainActivity.this, mylist2, R.layout.myitem,
                new String[]{"city", "code"}, new int[] {R.id.textView3, R.id.textView4});

        spinner2.setAdapter(adapter2);

    }
    public void clickAdd(View v)
    {
        EditText ed = (EditText) findViewById(R.id.editText);
        String str = ed.getText().toString();
        mylist.add(str);
        adapter.notifyDataSetChanged();
    }
    public void clickDelete(View v)
    {
        mylist.remove(spinner.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }
}
