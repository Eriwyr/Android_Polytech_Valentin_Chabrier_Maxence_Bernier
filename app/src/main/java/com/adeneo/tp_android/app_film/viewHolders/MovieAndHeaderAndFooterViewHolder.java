package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Film;

public class MovieAndHeaderAndFooterViewHolder extends ViewHolderAbstract {

    TextView counter;
    private TextView title;
    private TextView descritpion;
    private ImageView image;
    private TextView letter;


    public MovieAndHeaderAndFooterViewHolder(View itemView) {
        super(itemView);
        this.counter = itemView.findViewById(R.id.counter);
        this.title = itemView.findViewById(R.id.film_title);
        this.descritpion = itemView.findViewById(R.id.film_content);
        this.image = itemView.findViewById(R.id.film_image);
        this.letter = itemView.findViewById(R.id.letter_cell);
    }

    @Override
    public void layoutForObject(Object object) {

        if (counter != null) {
            String text;
            if (((Film) object).getIndexInLetterSubdivision() == 1) {
                text = " film";
            } else {
                text = " films";
            }
            counter.setText(((Film) object).getIndexInLetterSubdivision() + text);
        }
        if (title != null) {
            title.setText(((Film) object).getTitle());
        }
        if (descritpion != null) {
            descritpion.setText(((Film) object).getDescription());
        }
        if (image != null)
            image.setImageResource(R.drawable.bttf);
        if (letter != null)
            letter.setText(String.valueOf(((Film) object).getTitle().charAt(0)));

    }
}
