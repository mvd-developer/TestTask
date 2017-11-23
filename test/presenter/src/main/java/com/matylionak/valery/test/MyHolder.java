package com.matylionak.valery.test;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.matylionak.valery.test.databinding.ItemBinding;


public class MyHolder extends RecyclerView.ViewHolder {
    public ItemBinding binding;
    public MyHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public ItemBinding getBinding() {
        return binding;
    }

    public void setBinding(ItemBinding binding) {
        this.binding = binding;
    }
}
