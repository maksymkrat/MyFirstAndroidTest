package com.example.exampleapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn, btn_alert, alert2;
    private RatingBar rating;
    private TextView text_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public  void  addListenerOnButton () {
        pass = (EditText)findViewById(R.id.editTextTextPassword);
        btn = (Button)findViewById(R.id.button);
        btn_alert = (Button)findViewById(R.id.alert);
        alert2 = (Button)findViewById(R.id.alert2);

        alert2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".Activity2");
                        startActivity(intent);

                    }
                }
        );



        btn.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
                        btn.setText("Done");
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        Toast.makeText(
                                MainActivity.this, pass.getText(),
                                Toast.LENGTH_SHORT
                        ).show();

                    }
                }
        );

        rating = (RatingBar)findViewById(R.id.ratingBar);
        text_show = (TextView)findViewById(R.id.textView);

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text_show.setText(String.valueOf(rating));
                    }
                }
        );

        btn_alert.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {
//                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
//                        Toast.makeText(
//                                MainActivity.this, "we changed averything",
//                                Toast.LENGTH_SHORT
//                        ).show();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage(" You want to close the application?")
                                .setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("close the application");
                        alert.show();
                    }
                }
        );
    }


}