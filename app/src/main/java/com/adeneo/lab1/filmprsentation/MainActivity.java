package com.adeneo.lab1.filmprsentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button commentButton;
    Button likeButton;
    Button closeButton;
    Button backButton;
    Button sendButton;
    EditText commentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.commentButton = findViewById(R.id.commentButton);
        commentButton.setOnClickListener(buttonListener);
        this.likeButton = findViewById(R.id.likeButton);
        likeButton.setOnClickListener(buttonListener);
        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
        closeButton.setOnClickListener(buttonListener);
        this.backButton = findViewById(R.id.appbar_layout_backButton);
        backButton.setOnClickListener(buttonListener);
        this.sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(buttonListener);
        this.commentEditText = findViewById(R.id.commentEditText);
        commentEditText.setOnClickListener(buttonListener);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.commentButton:
                    onClickComment();
                    break;
                case R.id.likeButton:
                    likeButton.setActivated(!likeButton.isActivated());
                    break;
                case R.id.appbar_layout_closeButton:
                    finish();
                    break;
                case R.id.appbar_layout_backButton:
                    finish();
                    break;
                case R.id.sendButton:
                    onClickSend();
                    break;
                default:
                    break;
            }
        }
    };

    private void onClickComment() {
        commentEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(commentEditText, InputMethodManager.SHOW_IMPLICIT);
    }



    private void onClickSend() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(commentEditText.getText()).
                setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.create().show();

    }

}
