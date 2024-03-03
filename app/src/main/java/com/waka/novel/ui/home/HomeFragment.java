package com.waka.novel.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.waka.basic.GsonUtil;
import com.waka.basic.ImageLoadUtil;
import com.waka.basic.LogUtil;
import com.waka.basic.OkHttpUtils;
import com.waka.novel.R;
import com.waka.novel.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Callable;

import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends Fragment {
    private final String TAG= this.getClass().getSimpleName();

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)  {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTitle;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), te"xtView::setText);
        textView.setText("kawa");
        textView.setTextColor(getResources().getColor(R.color.teal_200));
        LogUtil.log(TAG,"home is show");
        final  TextView textView1 =binding.textDescription;
        textView1.setText("你比四环多一环");
        textView1.setTextColor(getResources().getColor(R.color.teal_700));
        final ImageView imageView = binding.avatar;
        ImageLoadUtil.image(getContext(),"https://img-cdn-test.amap.com/g/avatar/11.png?ver=1662370482&imgoss=1",imageView);
       // imageView.setImageDrawable(getResources().getDrawable(R.drawable.image2));
        try {
            OkHttpUtils.httpGet("https://mock.apifox.com/m1/4093654-0-default/pet/1", new HashMap<>(), new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.log(TAG, e.getMessage());

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
//                    LogUtil.log(TAG, response.body().string());

                    Pet pet=GsonUtil.safeFromJson(response.body().string(), Pet.class);
                    LogUtil.log(TAG, pet.getData().getName());

                    Handler mainHandler = new Handler(Looper.getMainLooper());

                    mainHandler.post(new Runnable() {

                        @Override

                        public void run() {

                            textView1.setText(pet.getData().getName());
                            //已在主线程中，可以更新UI

                        }

                    });


                }
            });
        } catch (Exception e) {
            LogUtil.log(TAG, Arrays.toString(e.getStackTrace()));
        }



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}