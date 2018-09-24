package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.IItemOnClickManager;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Movie;

public class MovieAndHeaderViewHolder extends ViewHolderAbstract {
    IItemOnClickManager onClickManager;
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
    public void layoutForObject(final Object object) {
        if (letter != null) {
            letter.setText(String.valueOf(((Movie) object).getTitle().charAt(0)));
        }
        if (title != null) {
            title.setText(((Movie) object).getTitle());
        }
        if (descritpion != null) {
            descritpion.setText(((Movie) object).getDescription());
        }
        if (image != null)
            image.setImageResource(R.drawable.bttf);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickManager != null)
                    onClickManager.onClickListItem(object);
            }
        });
    }

    public void setOnClickManager(IItemOnClickManager onClickManager) {
        this.onClickManager = onClickManager;
    }


}
