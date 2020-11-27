package com.example.cafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    private  static final  int Num_pages = 3;
    private ViewPager viewPager;
    private  ScreenSlidePagerAdapter pagerAdapter;
ImageView fon_img,name_img,logo_img;
Animation animation;
LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo_img = findViewById(R.id.logo);
        fon_img = findViewById(R.id.fon);
        name_img = findViewById(R.id.name);
        lottieAnimationView = findViewById(R.id.lottie);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        animation = AnimationUtils.loadAnimation(this,R.anim.b_b_animation);
        viewPager.startAnimation(animation);

        logo_img.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        fon_img.animate().translationY(2100).setDuration(1000).setStartDelay(4000);
        name_img.animate().translationY(2100).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2100).setDuration(1000).setStartDelay(4000);
    }
    private  class  ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
           switch (position){
               case 0:
                   OnbordingFragment1 tab1 =  new OnbordingFragment1();
                   return tab1;
               case 1:
                   OnbordingFragment2 tab2 =  new OnbordingFragment2();
                   return tab2;
               case 2:
                   OnbordingFragment3 tab3 =  new OnbordingFragment3();
                   return tab3;
           }
           return null;
        }

        @Override
        public int getCount() {
            return Num_pages;
        }
    }
}