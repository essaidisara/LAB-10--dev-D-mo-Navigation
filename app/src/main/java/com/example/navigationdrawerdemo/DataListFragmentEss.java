package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

public class DataListFragmentEss extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        String[] values = {

                "Android",
                "Java",
                "Navigation",
                "Drawer",
                "Fragment",
                "Interface",
                "Mobile",
                "Studio",
                "ESS",
                "Development"

        };

        ArrayAdapter<String> customAdapter =
                new ArrayAdapter<>(

                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        values
                );

        setListAdapter(customAdapter);
    }
}