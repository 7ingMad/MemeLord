package com.example.soone.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BotPictureFragment extends Fragment {
    private static TextView topMemeText;
    private static TextView botMemeText;
    private static Integer imgid;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        RelativeLayout background = (RelativeLayout)view.findViewById(R.id.background);
        Bundle bundle = getActivity().getIntent().getExtras();
        imgid = bundle.getInt("imgid");
        background.setBackgroundResource(imgid);

        topMemeText = (TextView) view.findViewById(R.id.topText);
        botMemeText = (TextView) view.findViewById(R.id.botText);
        return view;
    }

    public void setMemeText(String top, String bot){
        topMemeText.setText(top);
        botMemeText.setText(bot);
    }

    public void setMemePic(Integer imgid){
        this.imgid = imgid;
    }
}
