package com.example.helloappwithfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloFragment extends Fragment {

    private Button moreButton;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moreButton = view.findViewById(R.id.button);
        moreButton.setOnClickListener(this::moreButtonClick);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hello, container, false);
    }

    private void moreButtonClick(View view) {
        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.helloFragment, HelloAppMoreFragment.class, null, "")
                .addToBackStack("")
                .commit();
    }
}