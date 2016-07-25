package com.example.soone.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment {
    private static EditText topTextInput;
    private static EditText botTextInput;
    TopSectionListener activityCommander;

    public interface TopSectionListener{
        void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);
        topTextInput = (EditText) view.findViewById(R.id.topTextSection);
        botTextInput = (EditText) view.findViewById(R.id.botTextSection);

        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonClicked(view);
                    }
                }
        );
        return view;
    }

    private void buttonClicked(View view) {
        activityCommander.createMeme(topTextInput.getText().toString(), botTextInput.getText().toString());
    }
}
