package biz.roitech.testingmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import biz.roitech.commonlibrary.GetData;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(GetData.loadLayout("profile"));
    }
}
