package com.example.parthvaishnavi.project.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parthvaishnavi.project.R;

public class gal2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gal2, container, false);
        return v;
    }

    public static gal2 newInstance() {
        gal2 f = new gal2();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }
}
