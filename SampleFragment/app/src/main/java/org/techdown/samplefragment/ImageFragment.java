package org.techdown.samplefragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by fribel on 2017-07-12.
 */

public class ImageFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_sample,container,false);
        imageView = (ImageView) viewGroup.findViewById(R.id.imageView);

        return viewGroup;
    }

    public void setImage(int index) {
        if (index == 0) {
            imageView.setImageResource(R.drawable.test);
        }else if (index == 1){
            imageView.setImageResource(R.drawable.test2);
        }else if (index == 2) {
            imageView.setImageResource(R.drawable.test3);
        }else {
            imageView.setImageResource(R.drawable.test);
        }
    }

}
