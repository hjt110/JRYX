package com.wangou.jinriyixing.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.tong.library.bean.BaseBean;
import com.tong.library.bean.RegisterBean;
import com.tong.library.bean.ServiceBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.utils.MessageEvent;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.base.RequestHelper;
import com.wangou.jinriyixing.db.account.UserAccount;
import com.wangou.jinriyixing.utils.MD5Utils;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.zzhoujay.richtext.RichText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_forgetPwd)
    TextView tvForgetPwd;
    private CountDownTimer mCountDownTimer;
    private String smsid = "";
    private boolean pwdIsVisiable = false;


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.imgEyes, R.id.normal_login, R.id.sms_login, R.id.tv_yzm, R.id.btnLogin, R.id.tv_service,R.id.tv_forgetPwd})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.imgEyes:
                if (pwdIsVisiable) {
                    pwdIsVisiable = false;
                    imgEyes.setImageResource(R.mipmap.eyes_close);
                    editYzm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    pwdIsVisiable = true;
                    imgEyes.setImageResource(R.mipmap.eyes_open);
                    editYzm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                break;
            case R.id.normal_login:
                normalLogin.setTextColor(getResources().getColor(R.color.mainColor));
                lineLeft.setVisibility(View.VISIBLE);
                smsLogin.setTextColor(getResources().getColor(R.color.color_9));
                lineRight.setVisibility(View.INVISIBLE);
                editYzm.setHint("请输入密码");
                editPhone.setText("");
                editYzm.setText("");
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
                editPhone.setText("");
                editYzm.setText("");
                imgEyes.setVisibility(View.GONE);
                tvYzm.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_yzm:
                getSmsCode(editPhone.getText().toString());
                break;
            case R.id.btnLogin:
                if (lineLeft.getVisibility() == View.VISIBLE) {
                    normalLogin(editPhone.getText().toString(), editYzm.getText().toString());
                } else {
                    smsLogin(editPhone.getText().toString(), editYzm.getText().toString());
                }
                break;
            case R.id.tv_service:
                initServiceBean(getActivity());
                break;
            case R.id.tv_forgetPwd:
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                intent.putExtra("isForgetPwd",true);
                startActivity(intent);
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

    private void normalLogin(String phone, String pwd) {
        if (phone.equals("") || phone.length() != 11) {
            show("请输入正确的手机号");
            return;
        }
        if (pwd.equals("")) {
            show("密码不能为空");
            return;
        }
        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("time", ParamUtils.TimeCurrent);
        paramMap.put("mobile", phone);
        paramMap.put("pwd", MD5Utils.md5(pwd));
        String param = ParamUtils.getParam(paramMap);
        Api.getInstance()
                .pwdLogin(headerMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean registerBean) {
                        show(registerBean.getMsg());
                        if (registerBean.getCode() == 0) {
                            RegisterBean.DataBean data = registerBean.getData();
                            UserAccount.getInstance().save(data);
                            EventBus.getDefault().post(new MessageEvent("updateLogin"));
                            finish();
                        }
                    }
                });

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
        Api.getInstance()
                .smsLogin(headerMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean registerBean) {
                        show(registerBean.getMsg());
                        if (registerBean.getCode() == 0) {
                            RegisterBean.DataBean data = registerBean.getData();
                            UserAccount.getInstance().save(data);
                            EventBus.getDefault().post(new MessageEvent("updateLogin"));
                            finish();
                        }
                    }
                });

    }

    public void finish(View view) {
        finish();
    }

    public void register(View view) {
        startActivity(new Intent(getActivity(), RegisterActivity.class));
    }

    @Override
    protected boolean isUseEventBus() {
        return true;
    }

    /**
     * 获取服务bean
     *
     * @param context
     */
    public static void initServiceBean(Context context) {
        Api.getInstance()
                .getService(ParamUtils.getNormalHeaderMap())
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<ServiceBean>() {
                    @Override
                    public void onSuccess(ServiceBean serviceBean) {
                        if (serviceBean.getCode() == 0) {
                            showService(context, serviceBean);
                        }
                    }
                });
    }

    /**
     * 弹出服务协议框
     *
     * @param context
     * @param serviceBean
     */
    public static void showService(Context context, ServiceBean serviceBean) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_service, null);
        TextView tv_content = view.findViewById(R.id.tv_content);
        ImageView img_close = view.findViewById(R.id.img_close);
        RichText.from(serviceBean.getData().getProtocol_content()).singleLoad(false).into(tv_content);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(((Activity) context).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        img_close.setOnClickListener(v -> popupWindow.dismiss());
    }

    @Subscribe
    public void myMessagEvent(MessageEvent event) {
        if (event.getMsg().equals("finishActivity")) {
            finish();
        }
    }

    public static void goToLogin(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

}
