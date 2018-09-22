package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Film;

public class MovieAndFooterViewHolder extends ViewHolderAbstract {
    TextView counter;
    private TextView title;
    private TextView descritpion;
    private ImageView image;


    public MovieAndFooterViewHolder(View itemView) {
        super(itemView);
        counter = itemView.findViewById(R.id.counter);
        this.title = itemView.findViewById(R.id.film_title);
        this.descritpion = itemView.findViewById(R.id.film_content);
        this.image = itemView.findViewById(R.id.film_image);
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

    }
}
