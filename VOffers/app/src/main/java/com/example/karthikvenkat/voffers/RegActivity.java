package com.example.karthikvenkat.voffers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class RegActivity extends ActionBarActivity implements View.OnClickListener{

    Button Submit;
    EditText tx1,tx2,tx3;
    String CardNum,Name,CVV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        tx1=(EditText) findViewById(R.id.t1);
        tx2=(EditText) findViewById(R.id.t2);
        tx3=(EditText) findViewById(R.id.t3);


        Submit=(Button)findViewById(R.id.submit);
        Submit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reg, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        CardNum=tx1.getText().toString().trim();
        Name=tx2.getText().toString().trim();
        CVV=tx3.getText().toString().trim();

        if(Valid())startActivity(new Intent("com.example.karthikvenkat.voffers.MapsActivity"));
        else{
            Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean Valid() {
        boolean valid=true;
        if(CardNum.isEmpty() || CardNum.length() !=18) {tx1.setError("Invalid Card Number");valid=false;}
        else if(Name.isEmpty() || Name.length()>32){
            tx2.setError("Enter a Valid Name");
            valid=false;
        }
        else if(CVV.isEmpty()){tx3.setError("Invalid CVV");valid=false;}
        return valid;
    }
}
