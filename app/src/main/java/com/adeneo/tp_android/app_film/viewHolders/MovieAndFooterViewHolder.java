package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.IItemOnClickManager;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Movie;

public class MovieAndFooterViewHolder extends ViewHolderAbstract {
    IItemOnClickManager onClickManager;
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
    public void layoutForObject(final Object object) {

        if (counter != null) {
            String text;
            if (((Movie) object).getIndexInLetterSubdivision() == 1) {
                text = " film";
            } else {
                text = " films";
            }
            counter.setText(((Movie) object).getIndexInLetterSubdivision() + text);
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
