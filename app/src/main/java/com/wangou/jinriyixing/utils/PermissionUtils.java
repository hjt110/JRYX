package com.wangou.jinriyixing.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class PermissionUtils {


//    checkBoolean = true; 默认为true
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (checkBoolean) {
//            checkPermissions(PERMISSIONS_STRING_ARRAY);
//        }
//    }

    private void checkPermissions(Activity activity, String... strings) {

        List<String> list = findPermissions(activity,strings);

        if (null != list && list.size() > 0) {
            ActivityCompat.requestPermissions(activity, list.toArray(new String[list.size()]), 0);
        } else {
            startMain();
        }

    }

    private List<String> findPermissions(Activity activity,String[] strings) {

        List<String> list = new ArrayList<>();

        for (String perm : strings) {
            if (ContextCompat.checkSelfPermission(activity, perm) != PackageManager.PERMISSION_GRANTED) {
                list.add(perm);
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, perm)) {
                    list.add(perm);
                }
            }
        }

        return list;
    }

    private boolean verifyPermissions(int[] results) {

        for (int result : results) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;

    }

//    @Override
//    public void onRequestPermissionsResult(int code, @NonNull String[] per, @NonNull int[] param) {
//
//        if (code == RESULT_OK || verifyPermissions(param)) {
//            checkBoolean = false;
//            startMain();
//            return;
//        }
//
//        checkBoolean = true;
//        BaseToast.get().show("缺少运行时权限");
//        startApplicationSetting(getActivity(), getPackageName());
//
//    }

    public void startSetting(Activity activity, String packageName) {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", packageName, null));
        activity.startActivity(intent);

    }

    /**
     * what are you todo
     */
    private void startMain(){

    }

}
