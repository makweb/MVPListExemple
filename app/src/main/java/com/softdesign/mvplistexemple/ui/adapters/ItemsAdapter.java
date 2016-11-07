package com.softdesign.mvplistexemple.ui.adapters;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.softdesign.mvplistexemple.R;
import com.softdesign.mvplistexemple.data.models.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Makweb on 04.11.2016.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>{
    private List<UserDto> mUserList = new ArrayList<>();
    private ItemViewHolder.ICustomClickListener mCustomClickListener;

    public ItemsAdapter(List<UserDto> userList, ItemViewHolder.ICustomClickListener customClickListener) {
        mUserList = userList;
        mCustomClickListener = customClickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(convertView, mCustomClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.abbreviationTxt.setText(mUserList.get(position).getAbbrivation());
        holder.abbreviationTxt.setBackground(getBackground(mUserList.get(position).getColor()));
        holder.fullNameTxt.setText(mUserList.get(position).getFullName());
        holder.descriptionTxt.setText(mUserList.get(position).getShortMessage());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.abbreviation_txt)
        TextView abbreviationTxt;
        @BindView(R.id.full_name_txt)
        TextView fullNameTxt;
        @BindView(R.id.description_txt)
        TextView descriptionTxt;
        @BindView(R.id.text_wrapper)
        LinearLayout textWrapper;

        private ICustomClickListener mCustomClickListener;

        public ItemViewHolder(View itemView, ICustomClickListener clickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mCustomClickListener = clickListener;
            abbreviationTxt.setOnClickListener(this);
            textWrapper.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mCustomClickListener != null) {
                mCustomClickListener.onItemClicked(getAdapterPosition(),v);
            }

        }

        public interface ICustomClickListener {
            void onItemClicked(int position, View view);
        }
    }

    private Drawable getBackground(int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setColor(color);
        return shape;
    }
}

