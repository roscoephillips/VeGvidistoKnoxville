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
public class RestaurantsFragment extends Fragment {

    final ArrayList<TourGuideListing> ListingList = new ArrayList<>();

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.item_list_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ListingList.add(new TourGuideListing(
                R.string.restaurant_sanctuary,
                R.string.restaurant_sanctuary_description,
                R.string.restaurant_sanctuary_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_sanctuary_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_holy_land,
                R.string.restaurant_holy_land_description,
                R.string.restaurant_holy_land_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_holy_land_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_gosh,
                R.string.restaurant_gosh_description,
                R.string.restaurant_gosh_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_gosh_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_nama,
                R.string.restaurant_nama_description,
                R.string.restaurant_nama_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_nama_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_tot,
                R.string.restaurant_tot_description,
                R.string.restaurant_tot_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_tot_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_tomato_head,
                R.string.restaurant_tomato_head_description,
                R.string.restaurant_tomato_head_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_tomato_head_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_tomato_head_west,
                R.string.restaurant_tomato_head_west_description,
                R.string.restaurant_tomato_head_west_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_tomato_head_west_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_yassin,
                R.string.restaurant_yassin_description,
                R.string.restaurant_yassin_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_yassin_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_yassin_west,
                R.string.restaurant_yassin_west_description,
                R.string.restaurant_yassin_west_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_yassin_west_phone));
        ListingList.add(new TourGuideListing(
                R.string.restaurant_sitar,
                R.string.restaurant_sitar_description,
                R.string.restaurant_sitar_address,
                NO_RESOURCE_PROVIDED,
                R.string.restaurant_sitar_phone));

        ListingAdapter lAdapter = new ListingAdapter(this.getActivity(), ListingList);
        recyclerView.setAdapter(lAdapter);

        return rootView;
    }

}
