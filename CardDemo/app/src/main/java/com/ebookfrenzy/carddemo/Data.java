package com.ebookfrenzy.carddemo;

public class Data {
    private String[] titles = {
            "Chapter One",
            "Chapter Two",
            "Chapter Three",
            "Chapter Four",
            "Chapter Five",
            "Chapter Six",
            "Chapter Seven",
            "Chapter Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item five details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = {
            R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8};

    public String getTitles(int i) {
        return this.titles[i];
    }

    public String getDetails(int i) {
        return this.details[i];
    }

    public int getImages(int i) {
        return this.images[i];
    }

    public int getArrCount(){
        return this.titles.length;
    }
}
