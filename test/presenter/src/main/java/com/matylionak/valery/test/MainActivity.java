package com.matylionak.valery.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.matylionak.valery.test.base.BaseActivity;
import com.matylionak.valery.test.databinding.ActivityMainBinding;
import com.matylionak.valery.test.di.TestApplication;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainActivityViewModel mainActivityViewModel;

    public MainActivity() {
        TestApplication.appComponent.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.viewModel = mainActivityViewModel;
        ActivityMainBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainActivityViewModel);
        mainActivityViewModel.setBinding(binding);

        super.onCreate(savedInstanceState);
    }
}
