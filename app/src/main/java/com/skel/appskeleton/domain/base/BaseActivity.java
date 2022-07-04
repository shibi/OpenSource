package com.skel.appskeleton.domain.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skel.appskeleton.domain.interfaces.IActivity;

public abstract class BaseActivity extends AppCompatActivity implements IActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int mainLayout = setContentLayout();
        if(mainLayout == 0){
            showToast("PLEASE PROVIDE CONTENT LAYOUT");
        }
        setContentView(mainLayout);

        //init view
        init();

    }

    private void init(){
        try {

            initializeView();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
