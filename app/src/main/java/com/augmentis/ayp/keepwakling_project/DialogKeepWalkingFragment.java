package com.augmentis.ayp.keepwakling_project;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DialogKeepWalkingFragment extends DialogFragment {

    private static final String TAG = "KeepWalking";

    //step1: Create new Constructor by Singleton
    public static DialogKeepWalkingFragment newInstance() {
        DialogKeepWalkingFragment df = new DialogKeepWalkingFragment();
        return df;
    }

    //step2: Build onCreate for Dialog

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(TAG, "Create Dialog");
        //Build View for Dialog
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.activity_dialog_keep_walking_fragment, null);

        //Show Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setTitle("ADD TITLE");
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "Save Title");

            }
        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "Cancel Title");

                    }
                });

        return builder.create();
    }
}
