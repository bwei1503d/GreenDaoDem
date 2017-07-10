package com.bwei.greendaodem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bwei.dao.DaoMaster;
import com.bwei.dao.DaoSession;

/**
 * Created by muhanxi on 17/6/11.
 */

public class DBManager {

    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;
    private final SQLiteDatabase database;
    public final DaoSession daoSession;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        database = openHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }









}
