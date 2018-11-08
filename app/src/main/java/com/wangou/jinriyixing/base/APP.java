package com.wangou.jinriyixing.base;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.tong.library.utils.SPUtils;
import com.tong.library.utils.Utils;
import com.wangou.jinriyixing.db.account.UserAccount;
import com.wangou.jinriyixing.db.gen.DaoMaster;
import com.wangou.jinriyixing.db.gen.DaoSession;

public class APP extends Application {

    private static Context context;
    private static DaoSession mReadDaoSession;
    private static DaoSession mWriteDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Utils.init(this);
        SPUtils.init(this);
        initDB();
        UserAccount.getInstance().init();

    }

    private void initDB() {
        try {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
            SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
            SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
            mReadDaoSession = new DaoMaster(readableDatabase).newSession();
            mWriteDaoSession = new DaoMaster(writableDatabase).newSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLogin() {
        if (UserAccount.getInstance().getToken().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static Context getContext() {
        return context;
    }

    public static DaoSession getmReadDaoSession() {
        return mReadDaoSession;
    }

    public static DaoSession getmWriteDaoSession() {
        return mWriteDaoSession;
    }
}
