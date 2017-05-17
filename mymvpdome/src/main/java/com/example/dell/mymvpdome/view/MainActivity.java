package com.example.dell.mymvpdome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dell.mymvpdome.Main2Activity;
import com.example.dell.mymvpdome.R;
import com.example.dell.mymvpdome.presenter.LoginPresenter;
import com.example.dell.mymvpdome.presenter.LoginPresenterImpl;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private Button button;
    private TextView password;
    private ProgressBar progress;
    private TextView username;
    private LoginPresenter mpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mpi = new LoginPresenterImpl(this);
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        password = (TextView) findViewById(R.id.password);
        progress = (ProgressBar) findViewById(R.id.progress);
        username = (TextView) findViewById(R.id.username);

        button.setOnClickListener(this);
    }

    @Override
    public void showPrshowProgress() {
       progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
      startActivity(new Intent(this, Main2Activity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
         mpi.validateCredentials(username.getText().toString(),password.getText().toString());
    }
}
