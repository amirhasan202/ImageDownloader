package com.imagedownloader.imagedownloader;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImageDownloader {

	   public static void downloadImage(String imageUrl, String destinationPath) {
	        try {
	            HttpClient httpClient = HttpClients.createDefault();
	            HttpGet httpGet = new HttpGet(imageUrl);
	            HttpResponse response = httpClient.execute(httpGet);

	            HttpEntity entity = response.getEntity();
	            if (entity != null) {
	                try (InputStream inputStream = entity.getContent();
	                     FileOutputStream outputStream = new FileOutputStream(destinationPath)) {

	                    int inByte;
	                    while ((inByte = inputStream.read()) != -1) {
	                        outputStream.write(inByte);
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	   public static void resizeImage(String sourcePath, String destinationPath, int width, int height) {
	        try {
	            BufferedImage originalImage = ImageIO.read(new File(sourcePath));
	            BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());

	            Graphics2D graphics2D = resizedImage.createGraphics();
	            graphics2D.drawImage(originalImage, 0, 0, width, height, null);
	            graphics2D.dispose();

	            String formatName = destinationPath.substring(destinationPath.lastIndexOf(".") + 1);
	            ImageIO.write(resizedImage, formatName, new File(destinationPath));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	   public static void saveImageToDatabase(String imagePath, String imageName) {
	        try (Connection connection = DatabaseConfig.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO images (name, data) VALUES (?, ?)")) {

	            File imageFile = new File(imagePath);
	            FileInputStream fis = new FileInputStream(imageFile);

	            preparedStatement.setString(1, imageName);
	            preparedStatement.setBinaryStream(2, fis, (int) imageFile.length());

	            preparedStatement.executeUpdate();

	            fis.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        String query = "your search query here";
	        String imageUrl = "URL of the image to download";
	        String imageName = "name_of_the_image.jpg"; // You can generate a unique name based on the search query or other criteria

	        String destinationPath = "path/to/save/image.jpg";
	        downloadImage(imageUrl, destinationPath);

	        int width = 300; // Desired width
	        int height = 200; // Desired height
	        resizeImage(destinationPath, destinationPath, width, height);

	        saveImageToDatabase(destinationPath, imageName);
	    }

}
