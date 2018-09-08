package com.wangou.jinriyixing.activity.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.tong.library.bean.BaseBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.AesEncryptionUtil;
import com.wangou.jinriyixing.utils.DeviceUtils;
import com.wangou.jinriyixing.utils.LogUtils;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.wangou.jinriyixing.utils.RsaUtils;
import com.wangou.jinriyixing.utils.UsefulUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_verificationCode)
    EditText editVerificationCode;
    @BindView(R.id.tv_getCode)
    TextView tvGetCode;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.edit_confirmPwd)
    EditText editConfirmPwd;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private String smsid = "";
    private CountDownTimer mCountDownTimer;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.tv_getCode, R.id.btn_register})
    public void toDo(View view) {
        switch (view.getId()) {
            case R.id.tv_getCode:
                if (!tvGetCode.getText().toString().equals("发送验证码")) return;
                getCode(editPhone.getText().toString());
                break;
            case R.id.btn_register:
                register(editPhone.getText().toString(), editVerificationCode.getText()
                        .toString(), smsid, editPwd.getText().toString());
                break;
        }
    }

    private void register(String phone, String code, String smsid, String pwd) {

        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> map = new HashMap<>();
        map.put("time", ParamUtils.TimeCurrent);
        map.put("mobile", phone);
        map.put("code", code);
        map.put("smsid", smsid);
        map.put("pwd", pwd);
        String param = ParamUtils.getParam(map);

        Api.getInstance().getCode(headerMap, param).compose(RxSchedulers.io_main()).subscribe(baseBean -> {
            LogUtils.e("baseBean", baseBean.getMsg());
            LogUtils.e("baseBean", baseBean.getData().toString());
        });

    }

    /**
     * 获取短信验证码
     *
     * @param phone
     */
    private void getCode(String phone) {
        if (phone.equals("") || phone.length() != 11) {
            show("请输入正确的手机号");
            return;
        }

        mCountDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvGetCode.setClickable(false);
                tvGetCode.setText("重新发送(" + millisUntilFinished / 1000 + "s)");
            }

            @Override
            public void onFinish() {
                tvGetCode.setClickable(true);
                tvGetCode.setText("发送验证码");
            }
        }.start();

        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> map = new HashMap<>();
        map.put("time", ParamUtils.TimeCurrent);
        map.put("type", "register");
        map.put("mobile", phone);
        String param = ParamUtils.getParam(map);
        Api.getInstance()
                .getCode(headerMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        if (baseBean.getCode() == 0) {
                            smsid = baseBean.getData().getSmsid();
                        }
                        show(baseBean.getMsg());
                    }
                });
    }

    public void finish(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
