package com.ascend.assetcheck_jinhua.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ascend.assetcheck_jinhua.R;
import com.ascend.assetcheck_jinhua.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.psw)
    EditText psw;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void findViews(Bundle savedInstanceState) {
        super.findViews(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 登录
     */
    private void Login(String phone, String psw) {


    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        if (phone.getText().toString().trim().equals("")) {
            Toast.makeText(LoginActivity.this, "请输入手机号码或通用码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (psw.getText().toString().trim().length() < 6) {
            Toast.makeText(LoginActivity.this, "密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}

