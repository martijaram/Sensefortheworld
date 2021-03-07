package com.example.sense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.sense.HelperClasses.BaseActivity;



public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToHomeActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BottomNavigationActivity.class);
        startActivity(intent);
        finish();
    }

}
