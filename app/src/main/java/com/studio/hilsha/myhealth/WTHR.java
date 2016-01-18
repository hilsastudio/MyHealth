package com.studio.hilsha.myhealth;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class WTHR extends Fragment {



    public WTHR() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_wthr, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Activity context) {

        super.onAttach(context);

    }

    @Override
    public void onDetach() {
         super.onDetach();

    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity())
                .setTitle("Weist to height ratio");
    }



}
