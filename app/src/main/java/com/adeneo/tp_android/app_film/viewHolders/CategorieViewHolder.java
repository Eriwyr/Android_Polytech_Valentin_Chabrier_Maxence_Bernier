package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.list_cells.Categorie;

public class CategorieViewHolder extends ViewHolderAbstract {
    private TextView nameCategorie;

    public CategorieViewHolder(View itemView) {
        super(itemView);

        nameCategorie = itemView.findViewById(R.id.name_categorie);
    }

    @Override
    public void layoutForObject(Object object) {
       if ( object != null && object instanceof Categorie ) {
           if(nameCategorie != null){
               nameCategorie.setText(((Categorie)object).getName());
               System.out.println(((Categorie)object).getName());
           }
       }
    }


}
