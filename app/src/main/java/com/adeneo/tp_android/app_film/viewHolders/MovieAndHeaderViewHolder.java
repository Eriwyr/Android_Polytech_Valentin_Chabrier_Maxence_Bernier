package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Film;

public class MovieAndHeaderViewHolder extends ViewHolderAbstract {
    private TextView letter;

    private TextView title;
    private TextView descritpion;
    private ImageView image;

    public MovieAndHeaderViewHolder(View itemView) {
        super(itemView);

        letter = itemView.findViewById(R.id.letter_cell);
        this.title = itemView.findViewById(R.id.film_title_with_letter);
        this.descritpion = itemView.findViewById(R.id.film_content_with_letter);
        this.image = itemView.findViewById(R.id.film_image_with_letter);
    }

    @Override
    public void layoutForObject(Object object) {
        if (letter != null) {
            letter.setText(String.valueOf(((Film) object).getTitle().charAt(0)));
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
