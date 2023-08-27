package com.system;

import java.util.*;
import java.util.stream.Collectors;

public class Frames {
    private String framesId;
    public String getFramesId() {
        return framesId;
    }
    public void setFramesId(String framesId) {
        this.framesId = framesId;
    }

    private float price;
    private static int minPrice = 1;
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        if (price < minPrice) {
            throw new IllegalArgumentException("Price can not be smaller than " + minPrice + ".");
        }
        this.price = price;
    }
    public static void setMinPrice(int minPrice) {
        if (minPrice < 0) {
            throw new IllegalArgumentException("Price can not be smaller than 0.");
        }
        Frames.minPrice = minPrice;
    }

    public Frames(String framesId, float price) {
        setFramesId(framesId);
        setPrice(price);
        addFrames(this);
    }

    private static Set<Frames> extent = new TreeSet<>(Comparator.comparing(Frames::getFramesId));
    private static void addFrames(Frames frames) {
        extent.add(frames);
    }
    public static void removeFrames(Frames frames) {
        extent.remove(frames);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Frames.class.getName());
        for (Frames frames : extent) {
            System.out.println(frames);
        }
    }

    //methods
    //class method that return list of frames that are same price or cheaper than given price
    public static List<Frames> findFramesCheaperThan(float price) {
        return extent.stream().filter(frames -> frames.getPrice() <= price)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}