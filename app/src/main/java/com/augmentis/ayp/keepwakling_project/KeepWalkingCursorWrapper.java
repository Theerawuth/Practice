package com.augmentis.ayp.keepwakling_project;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.augmentis.ayp.keepwakling_project.KeepWalkingDbSchema.KeepWalkingTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Theerawuth on 8/3/2016.
 */
public class KeepWalkingCursorWrapper extends CursorWrapper {

    //Bulid Constructor
    public KeepWalkingCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public KeepWalking getKeepWalking(){

        String uuidStr = getString(getColumnIndex(KeepWalkingTable.Cols.UUID));
        String title = getString(getColumnIndex(KeepWalkingTable.Cols.TITLE));
        Long date = getLong(getColumnIndex(KeepWalkingTable.Cols.DATE));

        KeepWalking keepWalking = new KeepWalking(UUID.fromString(uuidStr));
        keepWalking.setTitle(title);
        keepWalking.setDate(new Date(date));

        return keepWalking;
    }
}
