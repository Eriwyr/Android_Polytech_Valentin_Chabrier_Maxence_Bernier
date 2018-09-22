package com.adeneo.tp_android.app_film.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ViewHolderAbstract;
import com.adeneo.tp_android.app_film.custom_controls.CustomCommentImage;
import com.adeneo.tp_android.app_film.list_cells.Comment;

public class CommentViewHolder extends ViewHolderAbstract {

    TextView userName;
    TextView commentContent;
    CustomCommentImage profileImage;


    public CommentViewHolder(View itemView) {
        super(itemView);
        this.userName = itemView.findViewById(R.id.user_name_comment);
        this.commentContent = itemView.findViewById(R.id.comment_content);
        this.profileImage = itemView.findViewById(R.id.profile_image);

    }

    @Override
    public void layoutForObject(Object object) {
        if (userName != null)
            userName.setText(((Comment) object).getUserName());
        if (commentContent != null)
            commentContent.setText(((Comment) object).getContent());
        if (profileImage != null)
            profileImage.setImageResource(R.drawable.bttf);
    }
}
