package com.adeneo.tp_android.app_film.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.CommentAdapter;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Comment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IRecyclerView {
    private Button commentButton;
    private Button likeButton;
    private Button closeButton;
    private Button backButton;
    private Button sendButton;
    private EditText commentEditText;
    private RecyclerView commentRecyclerView;
    private List<Comment> listComments;
    InputMethodManager imm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        listComments = new ArrayList<>();
        listComments.add(new Comment("Bob", "Comment comment comment comment comment comment ", 1));
        listComments.add(new Comment("Ana", "Comment comment comment  comment comment ", 1));
        listComments.add(new Comment("Marie", "Comment comment comment comment comment ", 1));
        listComments.add(new Comment("Paul", "Comment comment comment comment comment comment comment comment ", 1));
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
        this.commentRecyclerView = findViewById(R.id.comments_recycler_view);


        CommentAdapter adapter = new CommentAdapter();
        adapter.setManager(this);

        this.commentRecyclerView.setAdapter(adapter);
        this.commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
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


        imm.showSoftInput(commentEditText, InputMethodManager.SHOW_IMPLICIT);
    }


    private void onClickSend() {
        if (!commentEditText.getText().toString().isEmpty()) {
            listComments.add(0, new Comment("Moi", commentEditText.getText().toString(), 6));
            commentEditText.clearFocus();
            commentEditText.setText("");
            hideKeyboard(this);
            refreshListComments();
        }

    }

    @Override
    public int getCountItem() {
        if (listComments != null) {
            return listComments.size();
        }
        return 0;
    }

    @Override
    public List<Comment> getItems() {
        return listComments;
    }

    public void refreshListComments() {
        if (this.commentRecyclerView != null && this.commentRecyclerView.getAdapter() != null) {
            this.commentRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void hideKeyboard(Activity activity) {
        //InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
