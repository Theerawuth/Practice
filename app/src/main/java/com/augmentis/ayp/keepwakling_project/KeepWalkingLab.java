package com.augmentis.ayp.keepwakling_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.augmentis.ayp.keepwakling_project.KeepWalkingDbSchema.KeepWalkingTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theerawuth on 8/3/2016.
 */
public class KeepWalkingLab {

    private static final String TAG = "KeepWalking";
    private Context context;

    private SQLiteDatabase database;

    private static KeepWalkingLab instance;

    public static KeepWalkingLab getInstance(Context context){
        if(instance == null){
            instance = new KeepWalkingLab(context);
        }
        return instance;
    }

    private KeepWalkingLab(Context context){
        this.context = context.getApplicationContext();

        KeepWalkingBaseHelper keepWalkingBaseHelper = new KeepWalkingBaseHelper(context);
        database = keepWalkingBaseHelper.getWritableDatabase();
    }

    private static ContentValues getContentValues(KeepWalking keepWalking){
        Log.d(TAG, "put into database");
        ContentValues contentValues = new ContentValues();
        contentValues.put(KeepWalkingTable.Cols.UUID, keepWalking.getId().toString());
        contentValues.put(KeepWalkingTable.Cols.TITLE, keepWalking.getTitle());
        contentValues.put(KeepWalkingTable.Cols.DATE, keepWalking.getDate().toString());

        return contentValues;

    }

    //Cursor คือ ตัวชี้ข้อมูลเพื่อจัดการกับข้อมูล
    public KeepWalkingCursorWrapper queryKeepWalking(String whereCause, String[] whereArgs){
        Cursor cursor = database.query(KeepWalkingTable.NAME,
                null,
                whereCause,
                whereArgs,
                null,
                null,
                null);
        Log.d(TAG, "Query database");
        return new KeepWalkingCursorWrapper(cursor);
    }

    public List<KeepWalking> getKeepWalkingList(){

        List<KeepWalking> keepWalkingList = new ArrayList<>();
        KeepWalkingCursorWrapper cursorWrapper = queryKeepWalking(null, null);

        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                keepWalkingList.add(cursorWrapper.getKeepWalking());
                cursorWrapper.moveToNext();
                }
            }
            finally
            {
                cursorWrapper.close();
            }
        Log.d(TAG, "get database to List");
        return keepWalkingList;
        }

    public void addKeepWalking(KeepWalking keepWakling) {
        Log.d(TAG, "Add database");
        ContentValues contentValues = getContentValues(keepWakling);
        database.insert(KeepWalkingTable.NAME, null, contentValues);
    }









}
