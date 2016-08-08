package com.augmentis.ayp.keepwakling_project;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class KeepWalkingListFragment extends Fragment {

    private static final String TAG = "KeepWalking";
    private static final String DIALOG_ADD = "Dialog Add" ;

    private Button addKeepWalkingButton;
    private KeepWalkingAdapter adapter;
    private RecyclerView _recycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"Create Fragment Page");
        View v = inflater.inflate(R.layout.activity_keep_walking_list_fragment, container, false);
        Log.d(TAG, "Show on RecycleView");
        _recycleView = (RecyclerView) v.findViewById(R.id.recycle_view_keep_walking_list);
        _recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

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

    private void updateUI(){
        KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());
        Log.d(TAG, "updateUI");
        if(!keepWalkingLab.getKeepWalkingList().isEmpty()){
            Log.d(TAG, "Have list in database");
            List<KeepWalking> keepWalkingsList = keepWalkingLab.getKeepWalkingList();
            if(adapter == null){
                adapter = new KeepWalkingAdapter(keepWalkingsList, getActivity());
                _recycleView.setAdapter(adapter);
            }
            else
            {
                _recycleView.setAdapter(adapter);
            }
        }
    }
}
