package com.example.android.vegvidistoknoxville;

import static com.example.android.vegvidistoknoxville.MainActivity.NO_RESOURCE_PROVIDED;

public class TourGuideListing {

    //Name of Listing
    private int mListingTitle;

    //Listing of description
    private int mListingDescription;

    //Res ID for address
    private int mListingAddress = NO_RESOURCE_PROVIDED;

    //Res ID for website.
    private int mListingWebsite = NO_RESOURCE_PROVIDED;

    //Res ID for phone number.
    private int mListingPhoneNumber = NO_RESOURCE_PROVIDED;

    //Res ID for image.
    private int mListingImage = NO_RESOURCE_PROVIDED;

    //Creates a tour guide listing with an image.
    public TourGuideListing(int listingTitle, int listingDescription, int listingAddress, int listingWebsite, int listingPhoneNumber, int listingImage) {
        mListingTitle = listingTitle;
        mListingDescription = listingDescription;
        mListingAddress = listingAddress;
        mListingWebsite = listingWebsite;
        mListingPhoneNumber = listingPhoneNumber;
        mListingImage = listingImage;
    }

    //Creates a tour guide listing without an image.
    public TourGuideListing(int listingTitle, int listingDescription, int listingAddress, int listingWebsite, int listingPhoneNumber) {
        mListingTitle = listingTitle;
        mListingDescription = listingDescription;
        mListingAddress = listingAddress;
        mListingWebsite = listingWebsite;
        mListingPhoneNumber = listingPhoneNumber;
    }

    //gets the string resource ID for the title.
    public int getListingTitle() {
        return mListingTitle;
    }

    //gets the string resource ID for the description.
    public int getListingDescription() {
        return mListingDescription;
    }

    //gets the string resource ID for the listing's address(if applicable).
    public int getListingAddress() {
        return mListingAddress;
    }

    //Checks for presence of address.
    public boolean hasAddress() {
        return mListingAddress != NO_RESOURCE_PROVIDED;
    }

    //gets the string resource ID for the listing's website(if applicable).
    public int getListingWebsite() {
        return mListingWebsite;
    }

    //Checks for presence of website.
    public boolean hasWebsite() {
        return mListingWebsite != NO_RESOURCE_PROVIDED;
    }

    //gets the string resource ID for the listing's phone number(if applicable).
    public int getListingPhoneNumber() {
        return mListingPhoneNumber;
    }

    //Checks for presence of phone number.
    public boolean hasPhoneNumber() {
        return mListingPhoneNumber != NO_RESOURCE_PROVIDED;
    }

    //gets the string resource ID for the listing's image(if applicable).
    public int getListingImage() {
        return mListingImage;
    }

    //Checks for presence of image.
    public boolean hasImage() {
        return mListingImage != NO_RESOURCE_PROVIDED;
    }

}
