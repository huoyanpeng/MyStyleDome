package test.bwie.com.exercisemvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import test.bwie.com.exercisemvp.presenter.LoginPesenterImpl;

public class MainActivity extends AppCompatActivity implements LoginView{

    private EditText name;
    private EditText pass;
    private ProgressBar bar;
    private Button butt;
    private LoginPesenterImpl ipml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ipml = new LoginPesenterImpl(this);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ipml.validateCredentials(name.getText().toString(),pass.getText().toString());
            }
        });
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        bar = (ProgressBar) findViewById(R.id.bar);
        butt = (Button) findViewById(R.id.butt);

    }

    @Override
    public void showProgressBar() {
        bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hintProgressBar() {
        bar.setVisibility(View.GONE);
    }

    @Override
    public void nameEorro() {
        Toast.makeText(this, "用户名输入错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passEorro() {
        Toast.makeText(this, "密码输入错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucceed() {
         startActivity(new Intent(this,Main2Activity.class));
         finish();
    }
}
