package com.augmentis.ayp.keepwakling_project;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class DialogKeepWalkingFragment extends DialogFragment {

    private static final String TAG = "KeepWalking";
    EditText inputTitle;
    TextView dateText;
    Date dateKeepWalking;

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
        inputTitle = (EditText) v.findViewById(R.id.dialog_title_edit_text);
        dateText = (TextView) v.findViewById(R.id.dialog_date_text);
        dateKeepWalking = new Date(); // set date now

        //Show Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setTitle("ADD TITLE");
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "Save Title");
                KeepWalking keepWalking = new KeepWalking();
                keepWalking.setTitle(inputTitle.getText().toString());
                keepWalking.setDate(dateKeepWalking);
                KeepWalkingLab.getInstance(getActivity()).addKeepWalking(keepWalking);
                Intent intent = new Intent(getActivity(), KeepWalkingMain.class);
                startActivity(intent);

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
