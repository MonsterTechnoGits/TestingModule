package biz.roitech.commonlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GetData {

    static String email = "suman.dey@roitech.biz";
    static String password = "123456";

    Context context;

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

    public void loadLoginPage() {
        final Activity activity = (Activity) context;

        activity.setContentView(R.layout.activity_main_l);

        final EditText email = activity.findViewById(R.id.email), password = activity.findViewById(R.id.password);

        activity.findViewById(R.id.go_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You are log in " + email, Toast.LENGTH_SHORT).show();
                try {
                    activity.startActivity(new Intent(activity,Class.forName(activity.getPackageName()+".ProfileActivity")));
                    activity.finish();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
