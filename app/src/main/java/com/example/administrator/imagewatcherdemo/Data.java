package com.example.administrator.imagewatcherdemo;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    private List<Uri> pictureList;
    private List<Uri> pictureThumbList;

    public static List<Data> get() {
        List<Data> dataList = new ArrayList<>();

        Data data1 = new Data();
        data1.pictureList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1317.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1238.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1058.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/41320.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1044.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1309.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1300.png?")
        );
        data1.pictureThumbList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1317.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1238.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1058.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/41320.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1044.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1309.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/1300.png?")
        );


        Data data2 = new Data();
        data2.pictureList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4136.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4135.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/31338.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4014.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4361.png?")
        );
        data2.pictureThumbList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4136.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4135.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/31338.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4014.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/4361.png?")
        );

        Data data3 = new Data();
        data3.pictureList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33434.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3183.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33432.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3014.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33429.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3147.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3508.png?")
        );
        data3.pictureThumbList = Arrays.asList(
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33434.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3183.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33432.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3014.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/33429.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3147.png?"),
                Uri.parse("https://drjaosdejw578.cloudfront.net/tw/static/1533094167156/assets/886/products/3508.png?")
        );

        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);

        return dataList;
    }

    public List<Uri> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Uri> pictureList) {
        this.pictureList = pictureList;
    }

    public List<Uri> getPictureThumbList() {
        return pictureThumbList;
    }

    public void setPictureThumbList(List<Uri> pictureThumbList) {
        this.pictureThumbList = pictureThumbList;
    }
}
