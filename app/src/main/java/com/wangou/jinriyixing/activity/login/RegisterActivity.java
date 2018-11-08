package com.wangou.jinriyixing.activity.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.tong.library.bean.BaseBean;
import com.tong.library.bean.RegisterBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.utils.MessageEvent;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.base.RequestHelper;
import com.wangou.jinriyixing.db.account.UserAccount;
import com.wangou.jinriyixing.utils.MD5Utils;
import com.wangou.jinriyixing.utils.ParamUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.img_eyes)
    ImageView imgEyes;
    @BindView(R.id.img_eyesConfirm)
    ImageView imgEyesConfirm;
    private String smsid = "";
    private CountDownTimer mCountDownTimer;
    private boolean pwdIsVisiable;
    private boolean pwdConfirmIsVisiable;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.tv_getCode, R.id.btn_register, R.id.img_eyes, R.id.img_eyesConfirm})
    public void toDo(View view) {
        switch (view.getId()) {
            case R.id.tv_getCode:
                if (!tvGetCode.getText().toString().equals("获取验证码")) return;
                getCode(editPhone.getText().toString());
                break;
            case R.id.btn_register:
                register(editPhone.getText().toString(), editVerificationCode.getText()
                        .toString(), smsid, editPwd.getText().toString());
                break;
            case R.id.img_eyes:
                if (pwdIsVisiable) {
                    pwdIsVisiable = false;
                    imgEyes.setImageResource(R.mipmap.eyes_close);
                    editPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    pwdIsVisiable = true;
                    imgEyes.setImageResource(R.mipmap.eyes_open);
                    editPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                break;
            case R.id.img_eyesConfirm:
                if (pwdConfirmIsVisiable) {
                    pwdConfirmIsVisiable = false;
                    imgEyes.setImageResource(R.mipmap.eyes_close);
                    editConfirmPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    pwdConfirmIsVisiable = true;
                    imgEyes.setImageResource(R.mipmap.eyes_open);
                    editConfirmPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                break;
        }
    }

    private void register(String phone, String code, String smsid, String pwd) {

        if (smsid.equals("")) {
            show("请先获取验证码");
            return;
        }

        if (pwd.equals("")) {
            show("密码不能为空");
            return;
        }

        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> map = new HashMap<>();
        map.put("time", ParamUtils.TimeCurrent);
        map.put("mobile", phone);
        map.put("code", code);
        map.put("smsid", smsid);
        map.put("pwd", MD5Utils.md5(pwd));
        String param = ParamUtils.getParam(map);

        Api.getInstance()
                .register(headerMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean registerBean) {
                        show(registerBean.getMsg());
                        if (registerBean.getCode() == 0) {
                            RegisterBean.DataBean data = registerBean.getData();
                            UserAccount.getInstance().save(data);
                            EventBus.getDefault().post(new MessageEvent("finishActivity"));
                            EventBus.getDefault().post(new MessageEvent("updateLogin"));
                            finish();
                        }
                    }
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
                tvGetCode.setText("重新发送(" + millisUntilFinished / 1000 + "s)");
            }

            @Override
            public void onFinish() {
                tvGetCode.setText("发送验证码");
            }
        }.start();

        RequestHelper.getCode(phone, "register", o -> {
            BaseBean baseBean = (BaseBean) o;
            if (baseBean.getCode() == 0) {
                smsid = baseBean.getData().getSmsid();
            }
            show(baseBean.getMsg());
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
