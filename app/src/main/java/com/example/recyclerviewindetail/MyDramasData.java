package com.example.recyclerviewindetail;

public class MyDramasData {

    private String DramasName;
    private String DramasData;
    private int DramaImage;
    private String color;
    public MyDramasData(String dramasName, String dramasData, int dramaImage, String color) {
        DramasName = dramasName;
        DramasData = dramasData;
        DramaImage = dramaImage;
        this.color = color;
    }
    public String getDramasName() {
        return DramasName;
    }

    public String getDramasData() {
        return DramasData;
    }
    public int getDramaImage() {
        return DramaImage;
    }
    public String getColor() {
        return color;
    }
}
