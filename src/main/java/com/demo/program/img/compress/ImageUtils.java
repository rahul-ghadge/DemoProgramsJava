package com.demo.program.img.compress;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtils {

	private static final double RESIZE_PERCENT = 0.8;
	private static final String COMPRESSED_DIRECTORY = "compressed";

	public static boolean resizeImage(BufferedImage inputImage, String directoryPath, String fileExtension, File f) {
		boolean isCompressed = false;
		try {
			/*
			 * StringBuffer qualifiedFileName = new StringBuffer(directoryPath);
			 * qualifiedFileName.append(File.separator); qualifiedFileName.append(fileName);
			 * BufferedImage inputImage = ImageIO.read(new
			 * File(qualifiedFileName.toString()));
			 */

			int scaledWidth = (int) (inputImage.getWidth() * RESIZE_PERCENT);
			int scaledHeight = (int) (inputImage.getHeight() * RESIZE_PERCENT);

			// creates output image
			BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

			// scales the input image to the output image
			Graphics2D g2d = outputImage.createGraphics();
			g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
			g2d.dispose();

			StringBuffer qualifiedFileName = new StringBuffer(directoryPath);
			qualifiedFileName.append(File.separator);
			qualifiedFileName.append(COMPRESSED_DIRECTORY);

			File dir = new File(qualifiedFileName.toString());

			if (!dir.exists() && !dir.isDirectory()) {
				dir.mkdir();
			}

			qualifiedFileName.append(File.separator);
			qualifiedFileName.append(f.getName());

			// writes to output file
			ImageIO.write(outputImage, fileExtension, new File(qualifiedFileName.toString()));
			isCompressed = true;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return isCompressed;
	}

}