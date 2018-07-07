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
public class FoodTrucksFragment extends Fragment {

    final ArrayList<TourGuideListing> ListingList = new ArrayList<>();

    public FoodTrucksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.item_list_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ListingList.add(new TourGuideListing(
                R.string.food_truck_gg_tamale,
                R.string.food_truck_gg_tamale_description,
                NO_RESOURCE_PROVIDED,
                R.string.food_truck_gg_tamale_website,
                R.string.food_truck_gg_tamale_phone));
        ListingList.add(new TourGuideListing(
                R.string.food_truck_viet_grill,
                R.string.food_truck_viet_grill_description,
                NO_RESOURCE_PROVIDED,
                R.string.food_truck_viet_grill_website,
                R.string.food_truck_viet_grill_phone));

        ListingAdapter lAdapter = new ListingAdapter(this.getActivity(), ListingList);
        recyclerView.setAdapter(lAdapter);

        return rootView;
    }

}

