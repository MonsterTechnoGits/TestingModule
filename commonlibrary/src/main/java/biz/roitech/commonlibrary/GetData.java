package biz.roitech.commonlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GetData {

    static String email = "suman.dey@roitech.biz";
    static String password = "123456";

    static Context context;

    public GetData(Context context) {
        this.context = context;
    }

    public static int sum() {
        return 1;
    }

    public static void getData() {

    }

    public static int loadLayout(String activity) {

        return R.layout.profile_activity;
    }

    public static boolean loginUser(String email_text, String password_text) {

        if (email_text.equals(email) && password_text.equals(password)) {
            return true;
        } else {
            return false;
        }


    }

    public static void checkUser(FirebaseAuth mAuth) {
        FirebaseUser user = mAuth.getCurrentUser();
        final Activity activity = (Activity) context;

        if (user!=null){
            try {
                activity.startActivity(new Intent(activity,Class.forName(activity.getPackageName()+".ProfileActivity")));
                activity.finish();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadLoginPage(final FirebaseAuth mAuth) {
        final Activity activity = (Activity) context;

        activity.setContentView(R.layout.activity_main_l);

        final EditText email = activity.findViewById(R.id.email), password = activity.findViewById(R.id.password);

        email.setBackground(activity.getResources().getDrawable(R.drawable.edit_text_background_one));
        activity.findViewById(R.id.go_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(email.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())){
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                try {
                                    activity.startActivity(new Intent(activity,Class.forName(activity.getPackageName()+".ProfileActivity")));
                                    activity.finish();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                Toast.makeText(activity, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });

    }

    public void loadProfileUI(final FirebaseAuth mAuth) {
        final Activity activity = (Activity) context;

        activity.setContentView(R.layout.profile_activity);

        TextView email = activity.findViewById(R.id.email_text);

        email.setText(mAuth.getCurrentUser().getEmail());
        activity.findViewById(R.id.signout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                try {
                    activity.startActivity(new Intent(activity,Class.forName(activity.getPackageName()+".MainActivity")));
                    activity.finish();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
