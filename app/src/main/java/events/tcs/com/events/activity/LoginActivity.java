package events.tcs.com.events.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import events.tcs.com.events.R;
import events.tcs.com.events.constant.ApplicationData;
import events.tcs.com.events.utils.SharedPreferencesManager;


/**
 * Created by arun on 5/30/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginButton;
    private RelativeLayout relativeUserOne;
    private RelativeLayout relativeUserTwo;
    private String selectedUser;
    private Activity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        getExistingUser();
    }


    private void initView(){
        mActivity = this;
        loginButton = (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);
        relativeUserOne = (RelativeLayout) findViewById(R.id.rl_user1);
        relativeUserTwo = (RelativeLayout) findViewById(R.id.rl_user2);
        relativeUserTwo.setOnClickListener(this);
        relativeUserOne.setOnClickListener(this);
    }


    private void getExistingUser() {
        selectedUser = SharedPreferencesManager.readSharedPref(mActivity, ApplicationData.USER_KEY);
        setSelectedUserBackground();
    }

    private void setSelectedUserBackground() {
        relativeUserOne.setBackgroundResource(R.drawable.rect_selected);
        relativeUserTwo.setBackgroundResource(R.drawable.rect_selected);
        if (selectedUser.equals("David")) {
            relativeUserTwo.setBackgroundResource(R.drawable.rect_login);
        } else if (selectedUser.equals("Stephane")) {
            relativeUserOne.setBackgroundResource(R.drawable.rect_login);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                if (selectedUser.equals("")) {
                    Toast.makeText(mActivity, "Please select a user", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferencesManager.saveSharedPref(mActivity, ApplicationData.USER_KEY, selectedUser);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.rl_user1:
                selectedUser = "Stephane";
                setSelectedUserBackground();
                break;
            case R.id.rl_user2:
                selectedUser = "David";
                setSelectedUserBackground();
                break;
            default:
                break;
        }
    }
}