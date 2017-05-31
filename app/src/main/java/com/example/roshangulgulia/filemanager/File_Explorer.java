package com.example.roshangulgulia.filemanager;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

import org.w3c.dom.Text;

import java.io.File;

public class File_Explorer extends AppCompatActivity {
    Button b1;
    ArrayList<String> al=new ArrayList<String>();
    public void pdf(File ptr,String name)
    {
        File[] ptr1=ptr.listFiles();
        for(int i=0;i<ptr1.length;i++)
        {
            if(ptr1[i].getName().endsWith(name))
            {
                al.add(ptr1[i].getName());
            }
            else if(ptr1[i].isDirectory())
            {
                pdf(ptr1[i].getAbsoluteFile(),name);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file__explorer);

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String we="//storage//sdcard0//Download";
                String qw=".pdf";
                File dir=new File(we);
                pdf(dir,qw);

            }
        });
        String[] roshan=al.toArray(new String[al.size()]);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,roshan);
        ListView list= (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

    }
}
