package com.augmentis.ayp.keepwakling_project;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by TRW on 8/6/2016.
 */
public class KeepWalkingAdapter extends RecyclerView.Adapter<KeepWalkingHolder> {

    private static final String TAG = "KeepWalking";
    private List<KeepWalking> _keepWalkingList;
    private FragmentActivity _fragmentActivity;


    public KeepWalkingAdapter(List<KeepWalking> keepWalkingList, FragmentActivity fragmentactivity) {
        Log.d(TAG, "KeepWalkingAdapter");
        _keepWalkingList = keepWalkingList;
        _fragmentActivity = fragmentactivity;
    }

    @Override
    public KeepWalkingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "View KeepWalkingHolder");
        LayoutInflater layoutInflater = LayoutInflater.from(_fragmentActivity);
        View v = layoutInflater.inflate(R.layout.activity_keep_walking_holder, parent, false);

        return new KeepWalkingHolder(v, _fragmentActivity);
    }

    @Override
    public void onBindViewHolder(KeepWalkingHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");
        KeepWalking keepWalking = _keepWalkingList.get(position);
        holder.bindKeepWalking(keepWalking, position);
    }

    @Override
    public int getItemCount() {
        return _keepWalkingList.size();
    }
}
