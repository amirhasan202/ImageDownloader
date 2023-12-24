package com.imagedownloader.imagedownloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ImageSearch {

    public static void main(String[] args) {
        String query = "your search query here";
        String url = "https://www.google.com/search?tbm=isch&q=" + query;

        try {
            Document doc = Jsoup.connect(url).get();
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif|bmp)]");

            // Download the first image (this is a simplified example)
            String imageUrl = images.first().attr("src");
            // Implement logic to download the image (e.g., using Apache HttpClient)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
