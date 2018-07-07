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
public class ResourcesFragment extends Fragment {

    final ArrayList<TourGuideListing> ListingList = new ArrayList<>();


    public ResourcesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.item_list_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ListingList.add(new TourGuideListing(
                R.string.resources_k_town_vegans,
                R.string.resources_k_town_vegans_description,
                NO_RESOURCE_PROVIDED,
                R.string.resources_k_town_vegans_website,
                NO_RESOURCE_PROVIDED,
                R.drawable.fb_knoxville_vegans));
        ListingList.add(new TourGuideListing(
                R.string.resources_vset,
                R.string.resources_vset_description,
                NO_RESOURCE_PROVIDED,
                R.string.resources_vset_website,
                NO_RESOURCE_PROVIDED,
                R.drawable.vset_image));
        ListingList.add(new TourGuideListing(
                R.string.resources_knoxville_vegans_fb_group,
                R.string.resources_knoxville_vegans_fb_group_description,
                NO_RESOURCE_PROVIDED,
                R.string.resources_knoxville_vegans_fb_group_website,
                NO_RESOURCE_PROVIDED,
                R.drawable.fb_knoxville_vegans));
        ListingList.add(new TourGuideListing(
                R.string.resources_knox_save,
                R.string.resources_knox_save_description,
                NO_RESOURCE_PROVIDED,
                R.string.resources_knox_save_website,
                NO_RESOURCE_PROVIDED,
                R.drawable.knoxville_save));

        ListingAdapter lAdapter = new ListingAdapter(this.getActivity(), ListingList);
        recyclerView.setAdapter(lAdapter);

        return rootView;
    }

}

