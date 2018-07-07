package com.example.android.vegvidistoknoxville;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<TourGuideListing> ListingList;
    Context context;

    public ListingAdapter(Context context, ArrayList<TourGuideListing> ListingList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.ListingList = ListingList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TourGuideListing currentListing = ListingList.get(position);

        holder.listingTitle.setText(currentListing.getListingTitle());
        holder.listingDescription.setText(currentListing.getListingDescription());

        if (currentListing.hasAddress()) {
            holder.listingAddress.setText(currentListing.getListingAddress());
            holder.listingAddress.setVisibility(View.VISIBLE);
        } else {
            holder.addressContainer.setVisibility(View.GONE);
        }
        if (currentListing.hasWebsite()) {
            holder.listingWebsite.setText(R.string.list_website);
            holder.websiteContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri webpage = Uri.parse(context.getResources().getString(currentListing.getListingWebsite()));
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
            holder.listingWebsite.setVisibility(View.VISIBLE);
        } else {
            holder.websiteContainer.setVisibility(View.GONE);
        }

        if (currentListing.hasPhoneNumber()) {
            holder.listingPhoneNumber.setText(currentListing.getListingPhoneNumber());
            holder.phoneNumberContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri phoneNo = Uri.parse(context.getResources().getString(currentListing.getListingPhoneNumber()));
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData((Uri.parse("tel:" + phoneNo)));
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
            holder.listingPhoneNumber.setVisibility(View.VISIBLE);
        } else {
            holder.phoneNumberContainer.setVisibility(View.GONE);
        }

        if (currentListing.hasImage()) {
            holder.listingImage.setImageResource(currentListing.getListingImage());
            holder.listingAddress.setVisibility(View.VISIBLE);
        } else {
            holder.listingImage.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return ListingList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView listingTitle;
        private TextView listingDescription;
        private TextView listingAddress;
        View addressContainer;
        private TextView listingWebsite;
        View websiteContainer;
        private TextView listingPhoneNumber;
        View phoneNumberContainer;
        private ImageView listingImage;

        private ViewHolder(View listingView) {
            super(listingView);
            listingTitle = listingView.findViewById(R.id.listing_title);
            listingDescription = listingView.findViewById(R.id.listing_description);
            listingAddress = listingView.findViewById(R.id.listing_address);
            addressContainer = listingView.findViewById(R.id.directions_container);
            listingWebsite = listingView.findViewById(R.id.listing_website);
            websiteContainer = listingView.findViewById(R.id.website_container);
            listingPhoneNumber = listingView.findViewById(R.id.listing_phone_no);
            phoneNumberContainer = listingView.findViewById(R.id.phone_number_container);
            listingImage = listingView.findViewById(R.id.image_view_item);

        }
    }
}

