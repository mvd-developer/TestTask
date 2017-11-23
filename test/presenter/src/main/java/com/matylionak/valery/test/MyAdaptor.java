package com.matylionak.valery.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.matylionak.valery.data.People;
import com.matylionak.valery.test.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;


public class MyAdaptor extends RecyclerView.Adapter<MyHolder> {
    private List<People> list = new ArrayList<>();


    public void setList(List<People> arrayList) {
        list.clear();
        list.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBinding binding = ItemBinding.inflate(inflater, parent, false);
        return new MyHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ItemViewModel viewModel = new ItemViewModel();
        viewModel.setName(list.get(position).getName());
        viewModel.setProfession(list.get(position).getProfession());
        viewModel.setAge(list.get(position).getAge());
        viewModel.setEmail(list.get(position).getEmail());
        viewModel.setPhone(list.get(position).getPhone());
        holder.binding.setViewModel(viewModel);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
