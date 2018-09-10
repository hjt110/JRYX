package com.wangou.jinriyixing.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.tong.library.bean.BaseBean;
import com.tong.library.bean.LoginBean;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.base.RequestHelper;
import com.wangou.jinriyixing.utils.LogUtils;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.normal_login)
    TextView normalLogin;
    @BindView(R.id.lineLeft)
    View lineLeft;
    @BindView(R.id.sms_login)
    TextView smsLogin;
    @BindView(R.id.lineRight)
    View lineRight;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_yzm)
    EditText editYzm;
    @BindView(R.id.tv_yzm)
    TextView tvYzm;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.imgEyes)
    ImageView imgEyes;
    private CountDownTimer mCountDownTimer;
    private String smsid = "";

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.normal_login, R.id.sms_login, R.id.tv_yzm, R.id.btnLogin})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.normal_login:
                normalLogin.setTextColor(getResources().getColor(R.color.mainColor));
                lineLeft.setVisibility(View.VISIBLE);
                smsLogin.setTextColor(getResources().getColor(R.color.color_9));
                lineRight.setVisibility(View.INVISIBLE);
                editYzm.setHint("请输入密码");
                imgEyes.setVisibility(View.VISIBLE);
                tvYzm.setVisibility(View.GONE);
                if (mCountDownTimer != null) {
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.sms_login:
                normalLogin.setTextColor(getResources().getColor(R.color.color_9));
                lineLeft.setVisibility(View.INVISIBLE);
                smsLogin.setTextColor(getResources().getColor(R.color.mainColor));
                lineRight.setVisibility(View.VISIBLE);
                editYzm.setHint("请输入验证码");
                imgEyes.setVisibility(View.GONE);
                tvYzm.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_yzm:
                getSmsCode(editPhone.getText().toString());
                break;
            case R.id.btnLogin:
                if (lineLeft.getVisibility() == View.VISIBLE) {
                    normalLogin();
                } else {
                    smsLogin(editPhone.getText().toString(), editYzm.getText().toString());
                }
                break;
        }
    }

    /**
     * 获取验证码
     *
     * @param phone
     */
    private void getSmsCode(String phone) {
        if (phone.equals("") || phone.length() != 11) {
            show("请输入正确的手机号");
            return;
        }
        if (!tvYzm.getText().toString().equals("获取验证码")) {
            return;
        }
        mCountDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvYzm.setText("重新发送(" + millisUntilFinished / 1000 + "s)");
            }

            @Override
            public void onFinish() {
                tvYzm.setText("获取验证码");
            }
        }.start();
        RequestHelper.getCode(phone, "login", o -> {
            BaseBean baseBean = (BaseBean) o;
            if (baseBean.getCode() == 0) {
                smsid = baseBean.getData().getSmsid();
            }
            show(baseBean.getMsg());
        });
    }

    private void normalLogin() {

    }

    private void smsLogin(String phone, String sms) {
        if (phone.equals("") || phone.length() != 11) {
            show("请输入正确的手机号");
            return;
        }
        if (sms.equals("")) {
            show("验证码不能为空");
            return;
        }
        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("time", ParamUtils.TimeCurrent);
        paramMap.put("mobile", phone);
        paramMap.put("code", sms);
        paramMap.put("smsid", smsid);
        String param = ParamUtils.getParam(paramMap);
        RequestHelper.normalRequest("Login/smsloginrun", headerMap, param, o -> {
            LogUtils.e("bean",o.toString());
        });
    }

    public void finish(View view) {
        finish();
    }

    public void register(View view) {
        startActivity(new Intent(getActivity(), RegisterActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
