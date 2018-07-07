package com.example.android.vegvidistoknoxville;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.example.android.vegvidistoknoxville.MainActivity.NO_RESOURCE_PROVIDED;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    final ArrayList<TourGuideListing> ListingList = new ArrayList<>();

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.item_list_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ListingList.add(new TourGuideListing(
                R.string.events_scruffy_city_vegfest,
                R.string.events_scruffy_city_vegfest_description,
                R.string.events_scruffy_city_vegfest_address,
                NO_RESOURCE_PROVIDED,
                NO_RESOURCE_PROVIDED));
        ListingList.add(new TourGuideListing(
                R.string.events_thxgiving_potluck,
                R.string.events_thxgiving_potluck_description,
                R.string.events_thxgiving_potluck_address,
                NO_RESOURCE_PROVIDED,
                NO_RESOURCE_PROVIDED));
        ListingList.add(new TourGuideListing(
                R.string.events_vset_potlucks,
                R.string.events_vset_potlucks_description,
                R.string.events_vset_potlucks_address,
                NO_RESOURCE_PROVIDED,
                NO_RESOURCE_PROVIDED));

        ListingAdapter lAdapter = new ListingAdapter(this.getActivity(), ListingList);
        recyclerView.setAdapter(lAdapter);

        return rootView;
    }

}

