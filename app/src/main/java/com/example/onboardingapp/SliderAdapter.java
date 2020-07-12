package com.example.onboardingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }
    public int[] slide_images = {
            R.drawable.time_icon,
            R.drawable.relax_icon,
            R.drawable.final_icon
    };
    public String[] slide_headings = {
            "Mindfullness",
            "Keep Calm",
            "Stay focused"
    };
    public String[] slide_description = {
            "Mind is very powerful we possess and to take of our mind is an utmost priority",
            "Feel less stressed and mindful with meditation",
            "Let's maintain your focus by meditating everyday without hassle"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideText1 = view.findViewById(R.id.slide_text1);
        TextView slideText2 = view.findViewById(R.id.slide_text2);

        slideImageView.setImageResource(slide_images[position]);
        slideText1.setText(slide_headings[position]);
        slideText2.setText(slide_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
