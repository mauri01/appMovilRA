package com.vuforia.samples.VideoPlayback.ui.ActivityList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vuforia.samples.VideoPlayback.R;
import com.vuforia.samples.VideoPlayback.app.VideoPlayback.VideoPlayback;

public class FragmentUno extends Fragment {
    View view;

    public FragmentUno() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_uno,container,false);
        Button btnOpen = (Button) view.findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), VideoPlayback.class);
                startActivity(in);
            }
       });
        return view;
    }
}
