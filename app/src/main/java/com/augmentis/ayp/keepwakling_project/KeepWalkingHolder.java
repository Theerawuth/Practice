package com.augmentis.ayp.keepwakling_project;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class KeepWalkingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private static final String TAG = "KeepWalking";
    private TextView titleShow;
    private TextView dateShow;
    KeepWalking _keepWalking;
    private FragmentActivity _fragmentactivity;

    public KeepWalkingHolder(View itemView, FragmentActivity fragmentactivity) {
        super(itemView);
        Log.d(TAG, "Show Title and Date");
        _fragmentactivity = fragmentactivity;
        titleShow = (TextView) itemView.findViewById(R.id.holder_title_text_view);
        dateShow = (TextView) itemView.findViewById(R.id.holder_date_text_view);

    }

    public  void bindKeepWalking(KeepWalking keepWalking, int position){
        Log.d(TAG, "Bind title and Date");
        _keepWalking = keepWalking;
        titleShow.setText(_keepWalking.getTitle());
        dateShow.setText(_keepWalking.getDate().toString());
    }

    @Override
    public void onClick(View v) {
        // Todo : Add onclick
    }
}
