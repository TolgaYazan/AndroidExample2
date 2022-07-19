package com.example.week12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Date;

public class MyFragmentDialog extends DialogFragment {

    public static MyFragmentDialog newInstance(int title){
        MyFragmentDialog  fragment = new MyFragmentDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        args.putString("message","Messsage line 1 \n Messsae Line 2");
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog( Bundle savedInstance){

        int title = getArguments().getInt("title");
        String message = getArguments().getString("message");
            return new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setMessage(message)
                    .setIcon(null)
                    .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((MainActivity)getActivity())
                                    .positiveOption(new Date());
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((MainActivity)getActivity())
                                    .negativeOption(new Date());
                        }
                    })
                    .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((MainActivity)getActivity())
                                .neutralOption(new Date());
                        }
                    }).create();



    }
}
