package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicThreshold {

	BufferedImage image;
	int width, height, red, green, blue, gray;
	int threshold = 100;
		
	public void run() throws IOException {
		File input = new File("C:/Users/thay-/Desktop/Aulas 2021.2/Computação grafica/PDI/atividade-pdi-1/image1.jfif");
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();
				
				gray = (red*2 + green/5 - blue)/3;
				
				if(gray > threshold) {
					image.setRGB(j, i, Color.WHITE.getRGB());
				}else {
					image.setRGB(j, i, Color.BLACK.getRGB());
				}
				
								
			}			
		}
		
		File output = new File("C:/Users/thay-/Desktop/Aulas 2021.2/Computação grafica/PDI/atividade-pdi-1/image1_bw.jpg");
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
		
	}
	
	public static void main(String[] args) {
		try {
			new BasicThreshold().run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
