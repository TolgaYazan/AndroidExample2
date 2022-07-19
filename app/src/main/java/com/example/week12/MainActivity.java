package com.example.week12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtMsg;
    private Button btnAlert, btnCustom , btnFragment;
    private Context myContext;
    private String msg ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext=this;

        txtMsg=findViewById(R.id.txtMsg);
        btnAlert=findViewById(R.id.btnAlert);
        btnCustom=findViewById(R.id.btnCustom);
        btnFragment=findViewById(R.id.btnFragment);

        btnAlert.setOnClickListener(this);
        btnCustom.setOnClickListener(this);
        btnFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==btnAlert.getId())
            showAlertDialog(this);
        if(v.getId()==btnCustom.getId())
            showCustomialog();
        if(v.getId()==btnFragment.getId())
            showFragmentDialog(this);

    }

    //dialogo simple dialog
    private void showAlertDialog(MainActivity mainActivity){
        AlertDialog.Builder alert = new AlertDialog.Builder(myContext) ;
        alert.setTitle("Bilgi Alert");
        alert.setMessage("Hello Bilgi");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "YES" + Integer.toString(which);
                txtMsg.setText(msg);
            }
        });
        // insert
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            String msg = "No" + Integer.toString(which);
            txtMsg.setText(msg);
            }
        });

        alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "Cancel" + Integer.toString(which);
                txtMsg.setText(msg);
            }


    });

        // display the dialog
        AlertDialog myDialog = alert.create();
        myDialog.show();


    }

    // dialogo custom dialoog
    private void showCustomialog(){

        Dialog customDialog = new Dialog(myContext);
        customDialog.setTitle("Bilgi Custom Dialogo");
        customDialog.setContentView(R.layout.custom_dialog);

        /*
        ((TextView)customDialog.findViewById(R.id.sd_textView1))
                .setText("\n Message Line 1 \n Message Line 2\n" +
                        "Dismiss : Back btn Close, or touch outside"); */

        TextView myText =customDialog.findViewById(R.id.sd_textView1);
        myText.setText("Hello Everyone");
        EditText inputText = customDialog.findViewById(R.id.sd_editText);

        ((Button)customDialog.findViewById(R.id.sd_btnClose))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtMsg.setText(inputText.getText().toString());
                        customDialog.dismiss();
                    }
                });


    }

    // dialogs fragment dialog
    private void showFragmentDialog(MainActivity mainActivity){
        DialogFragment dialogFragment = MyFragmentDialog.newInstance(R.string.app_name);
        dialogFragment.show(getFragmentManager(), "TAG");
    }

    public void positiveOption(Date time){
        txtMsg.setText(time.toString());
    }


    public void negativeOption(Date time){
        txtMsg.setText(time.toString());
    }


    public void neutralOption(Date time){
        txtMsg.setText(time.toString());
    }
}