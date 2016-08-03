package com.augmentis.ayp.keepwakling_project;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class KeepWalkingListFragment extends Fragment {

    private static final String TAG = "KeepWalking";
    private static final String DIALOG_ADD = "Dialog Add" ;

    Button addKeepWalkingButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"Create Fragment Page");
        View v = inflater.inflate(R.layout.activity_keep_walking_list_fragment, container, false);
        addKeepWalkingButton = (Button) v.findViewById(R.id.add_keep_walking_button);
        addKeepWalkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Click Add Button");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DialogKeepWalkingFragment dialogKeepWalkingFragment = DialogKeepWalkingFragment.newInstance();
                dialogKeepWalkingFragment.show(fm, DIALOG_ADD);

            }
        });

        return v;
    }
}
