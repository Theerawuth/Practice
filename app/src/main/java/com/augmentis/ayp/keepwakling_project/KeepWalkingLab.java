package com.augmentis.ayp.keepwakling_project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theerawuth on 8/3/2016.
 */
public class KeepWalkingLab {

    List<KeepWalkingLab> keepWalkingList = new ArrayList<>();

    private static KeepWalkingLab instance;

    public static KeepWalkingLab getInstance(){
        if(instance == null){
            instance = new KeepWalkingLab();
        }
        return instance;
    }




}
