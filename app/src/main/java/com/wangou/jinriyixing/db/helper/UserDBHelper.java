package com.wangou.jinriyixing.db.helper;

import com.wangou.jinriyixing.base.APP;
import com.wangou.jinriyixing.db.bean.User;
import com.wangou.jinriyixing.db.gen.UserDao;

import java.util.List;

public class UserDBHelper {

    private static UserDBHelper mInstance;
    private final UserDao mReadUserDao;
    private final UserDao mWriteUserDao;

    private UserDBHelper() {
        mReadUserDao = APP.getmReadDaoSession().getUserDao();
        mWriteUserDao = APP.getmWriteDaoSession().getUserDao();
    }

    public static UserDBHelper getInstance() {
        if (mInstance == null) {
            synchronized (UserDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UserDBHelper();
                }
            }
        }
        return mInstance;
    }

    public void updateUserInfo(User user) {
        try {
            if (getUserInfo() != null) {
                mWriteUserDao.deleteAll();
            }
            mWriteUserDao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserInfo() {
        List<User> list = mReadUserDao.queryBuilder().list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
