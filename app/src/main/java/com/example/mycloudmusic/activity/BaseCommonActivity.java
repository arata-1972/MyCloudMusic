package com.example.mycloudmusic.activity;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.example.mycloudmusic.util.PreferenceUtil;

/**
 * 通用界面逻辑
 */
public class BaseCommonActivity extends BaseActivity {

    /**
     * 偏好设置实例
     */
    protected PreferenceUtil sp;

    @Override
    protected void initDatum() {
        super.initDatum();
        //初始化偏好设置
        sp = PreferenceUtil.getInstance(getMainActivity());
    }

    /**
     * 设置界面全屏
     */
    protected void fullScreen(){
        //获取decorView
        View decorView = getWindow().getDecorView();
        //判断版本
        if(Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19){
            //1~18版本
            decorView.setSystemUiVisibility(View.GONE);
        }else if(Build.VERSION.SDK_INT >= 19){
            //19及以上版本
            //SYSTEM_UI_FLAG_HIDE_NAVIGATION:隐藏导航栏,隐藏下面
            //SYSTEM_UI_FLAG_IMMERSIVE_STICKY:从状态栏下拉会半透明悬浮显示一会儿状态栏和导航栏
            //SYSTEM_UI_FLAG_FULLSCREEN:全屏，隐藏上面
            int options = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                    View.SYSTEM_UI_FLAG_FULLSCREEN;
            //设置到控件
            decorView.setSystemUiVisibility(options);
        }
    }

    /**
     * 隐藏状态栏
     */
    protected void hideStatusBar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    /**
     * 启动界面
     * @param clazz
     */
    protected void startActivity(Class<?> clazz){
        Intent intent = new Intent(getMainActivity(), clazz);
        startActivity(intent);
    }
    /**
     * 启动界面并关闭当前界面
     * @param clazz
     */
    protected void startActivityAfterFinnishThis(Class<?> clazz){
        startActivity(clazz);
        //关闭当前界面，就是跳转之后按导航栏的返回回不到当前界面了
        finish();
    }
    /**
     * 获取界面
     * @return
     */
    protected BaseCommonActivity getMainActivity(){
        return this;
    }
}