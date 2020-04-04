package com.example.monster_electricity;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment extends Fragment {


    public AppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app, container, false);

        Button mBtn_Standard_Saved = view.findViewById(R.id.規格省電試算);
        Button mBtn_Special_Standard_Saved = view.findViewById(R.id.特定規格搜尋);
        Button mBtn_Search_Saved = view.findViewById(R.id.掃圖搜尋);

        mBtn_Standard_Saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Standard_SavedActivity.class));
            }
        });

        mBtn_Special_Standard_Saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Special_Standard_SavedActivity.class));
            }
        });

        mBtn_Search_Saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Search_SavedActivity.class));
            }
        });
        return  view;
    }

}
