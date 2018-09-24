package com.adeneo.tp_android.app_film.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.CommentAdapter;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Comment;
import com.adeneo.tp_android.app_film.list_cells.Movie;
import com.adeneo.tp_android.app_film.managers.MovieManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IRecyclerView {
    private Button commentButton;
    private Button likeButton;
    private Button closeButton;
    private Button backButton;
    private Button sendButton;
    private Button shareButton;
    private EditText commentEditText;
    private TextView movieTitleTextView;
    private TextView originalMovieTitleTextView;
    private TextView descriptionMovieTextView;
    private TextView movieKeywordsTexView;
    private RecyclerView commentRecyclerView;
    private List<Comment> listComments;

    private int movieId;

    InputMethodManager imm;

    public static Intent newActivity(Context context, int filmId) {
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("MOVIE_ID", filmId);
        return i;
    }


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

        movieTitleTextView = findViewById(R.id.movie_title);
        originalMovieTitleTextView = findViewById(R.id.original_movie_title);
        descriptionMovieTextView = findViewById(R.id.movie_description);
        movieKeywordsTexView = findViewById(R.id.movie_keywords);

        this.shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(buttonListener);
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

        Intent i = getIntent();

        movieId = i.getIntExtra("MOVIE_ID", 2);
        System.out.println("ID MOVIE :" + movieId);
        MovieManager movieManager = MovieManager.getInstance();

        Movie currentMovie = movieManager.getMoviesById(movieId);

        movieTitleTextView.setText(currentMovie.getTitle());
        originalMovieTitleTextView.setText(currentMovie.getOriginalTitle());
        descriptionMovieTextView.setText(currentMovie.getDescription());
        movieKeywordsTexView.setText(currentMovie.getKeyWords());
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
                case R.id.shareButton:
                    onClickShare();
                    break;

                default:
                    break;
            }
        }
    };

    private void onClickShare() {
        String shareText = ((Movie) MovieManager.getInstance().getMoviesById(movieId)).getTitle();

        Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                + "/drawable/" + "bttf");
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "send"));
    }

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
