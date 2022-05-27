package com.wajahatkarim3.easyflipviewpager.demo;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BookPageIntroFragment extends Fragment {

    int imageId;

    public static BookPageIntroFragment newInstance( int imageId)
    {
        BookPageIntroFragment fragment = new BookPageIntroFragment();
        Bundle args = new Bundle();

        args.putInt("imageId", imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageId = getArguments().getInt("imageId", R.drawable.ic_launcher_background);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_page_layout, container, false);

        ImageView imageView = rootView.findViewById(R.id.imageView);



        imageView.setImageResource(imageId);

        if (imageId == R.drawable.all_about_reading)
            rootView.setTag(21);
        else
            rootView.setTag(40);

        return rootView;
    }
}
