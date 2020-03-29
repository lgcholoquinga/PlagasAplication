package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context =context;
    }
    //arrays
    public int[] slide_background = {
            R.drawable.gradient,
            R.drawable.gradient_intro1,
            R.drawable.gradient_intro2
    };
    public int[] slide_images = {
            R.drawable.ic_icon_splash,
            R.drawable.ic_icon_splah2,
            R.drawable.ic_icon_splash3
    };
    public String[] slide_headings = {
            "Bienvenido",
            "Realiza",
            "Detecta"
    };
    public String[] slide_descriptions = {
            "a la mejor aplicación de diagnóstico de plagas en cultivos de papas.",
            "el dianóstico de plagas en tu cultivo de papas de manera efectiva.",
            "a tiempo las plagas como: Psílido de la Punta Morada y Mosca Minadora que son una amenaza para tu cultivo."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return view == (RelativeLayout) o;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideLImageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideLTextview1);
        TextView slideDescription = (TextView) view.findViewById(R.id.slideLTextView2);
        RelativeLayout background = (RelativeLayout) view.findViewById(R.id.slideLayoutRelativeL);
        TextView p1 = (TextView) view.findViewById(R.id.slideLTextP1);
        TextView p2 = (TextView) view.findViewById(R.id.slideLTextP2);
        TextView p3 = (TextView) view.findViewById(R.id.slideLTextP3);

        background.setBackgroundResource(slide_background[position]);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descriptions[position]);
        if (position == 0)
        {
            p1.setTextColor(context.getColor(R.color.colorWhite));
            p2.setTextColor(context.getColor(R.color.colorTransparentWhite));
            p3.setTextColor(context.getColor(R.color.colorTransparentWhite));
        }
        if (position == 1)
        {
            p1.setTextColor(context.getColor(R.color.colorTransparentWhite));
            p2.setTextColor(context.getColor(R.color.colorWhite));
            p3.setTextColor(context.getColor(R.color.colorTransparentWhite));
        }
        if (position == 2)
        {
            p1.setTextColor(context.getColor(R.color.colorTransparentWhite));
            p2.setTextColor(context.getColor(R.color.colorTransparentWhite));
            p3.setTextColor(context.getColor(R.color.colorWhite));
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}

