package com.example.mycloudmusic.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycloudmusic.R;
import com.example.mycloudmusic.util.LogUtil;
import com.example.mycloudmusic.util.StringUtil;
import com.example.mycloudmusic.util.ToastUtil;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActivity extends BaseTitleActivity {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 登录按钮点击
     * @param button
     */
    @OnClick(R.id.bt_login)
    public void onLoginClick(Button button){
        LogUtil.d(TAG, "onLoginClick");

        //获取用户名
        String username = et_username.getText().toString().trim();
        if(StringUtils.isBlank(username)){
            LogUtil.w(TAG, "onLoginClick username empty");
//            Toast.makeText(getMainActivity(), R.string.enter_username, Toast.LENGTH_SHORT).show();
            ToastUtil.errorShortToast(R.string.enter_username);
            return;
        }
        //如果用户名
        //不是手机号也不是邮箱
        //就是格式错误
        if(!(StringUtil.isPhone(username) || StringUtil.isEmail(username))){
            ToastUtil.errorShortToast( R.string.error_username_format);
            return;
        }
        //获取密码
        String password = et_password.getText().toString().trim();
        if(StringUtils.isBlank(password)){
            LogUtil.w(TAG, "onLoginClick password empty");
//            Toast.makeText(getMainActivity(), R.string.enter_password, Toast.LENGTH_SHORT).show();
            ToastUtil.errorShortToast( R.string.enter_password);
            return;
        }
        //判断密码格式
        if(!(StringUtil.isPassword(password))){
            ToastUtil.errorShortToast(R.string.error_password_format);
            return;
        }
        // TODO: 20-5-18 调用登录方法
        ToastUtil.successShortToast(R.string.login_success);
    }
    /**
     * 忘记密码按钮点击了
     */
    @OnClick(R.id.bt_forget_password)
    public void onForgetPasswordClick() {
        LogUtil.d(TAG, "onForgetPasswordClick");
    }
}
