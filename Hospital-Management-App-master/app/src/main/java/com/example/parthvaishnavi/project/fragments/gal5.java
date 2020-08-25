package com.example.parthvaishnavi.project.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parthvaishnavi.project.R;

public class gal5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gal5, container, false);
        return v;
    }

    public static gal5 newInstance() {
        gal5 f = new gal5();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }
}
