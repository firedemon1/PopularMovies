package com.example.deepakt.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // The detail Activity called via intent.  Inspect the intent for forecast data.
        Intent intent = this.getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String movieData = intent.getStringExtra(Intent.EXTRA_TEXT);
            String data[] = movieData.split("~");
            ((TextView) rootView.findViewById(R.id.title)).setText(data[0]);
            String url = getString(R.string.image_url) + data[1];
            Picasso.with(getContext()).load(url).into((ImageView) rootView.findViewById(R.id.thumbnail));
            ((TextView) rootView.findViewById(R.id.synopsis)).setText(data[2]);
            ((TextView) rootView.findViewById(R.id.rating)).setText("Rating: " + data[3]);
            ((TextView) rootView.findViewById(R.id.date)).setText("Release Date: " + data[4]);
        }

        return rootView;
    }
}
