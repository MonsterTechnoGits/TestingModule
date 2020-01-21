package biz.roitech.testingmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import biz.roitech.commonlibrary.GetData;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        GetData getData = new GetData(this);
        getData.loadProfileUI(mAuth);


    }
}
