

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testBlue1() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/1.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image blueImage = processer.showChanelB(image);
		
		assertEquals(image.getWidth(null), blueImage.getWidth(null));
		assertEquals(image.getHeight(null), blueImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = blueImage.getWidth(null);
		int height = blueImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(blueImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/1_blue_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testBlue2() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/2.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image blueImage = processer.showChanelB(image);
		
		assertEquals(image.getWidth(null), blueImage.getWidth(null));
		assertEquals(image.getHeight(null), blueImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = blueImage.getWidth(null);
		int height = blueImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(blueImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/2_blue_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testGreen1() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/1.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image greenImage = processer.showChanelG(image);
		
		assertEquals(image.getWidth(null), greenImage.getWidth(null));
		assertEquals(image.getHeight(null), greenImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = greenImage.getWidth(null);
		int height = greenImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(greenImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/1_green_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testGreen2() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/2.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image greenImage = processer.showChanelG(image);
		
		assertEquals(image.getWidth(null), greenImage.getWidth(null));
		assertEquals(image.getHeight(null), greenImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = greenImage.getWidth(null);
		int height = greenImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(greenImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/2_green_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testRed1() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/1.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image redImage = processer.showChanelR(image);
		
		assertEquals(image.getWidth(null), redImage.getWidth(null));
		assertEquals(image.getHeight(null), redImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = redImage.getWidth(null);
		int height = redImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(redImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/1_red_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testRed2() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/2.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image redImage = processer.showChanelR(image);
		
		assertEquals(image.getWidth(null), redImage.getWidth(null));
		assertEquals(image.getHeight(null), redImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = redImage.getWidth(null);
		int height = redImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(redImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/2_red_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testGray1() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/1.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image grayImage = processer.showGray(image);
		
		assertEquals(image.getWidth(null), grayImage.getWidth(null));
		assertEquals(image.getHeight(null), grayImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = grayImage.getWidth(null);
		int height = grayImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(grayImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/1_gray_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
	@Test
	public void testGray2() throws IOException {
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图宽度、位图高度）；
		 * 
		 * */
		File file = new File("/home/lucas/Documents/bmptest/2.bmp");
		FileInputStream filestream = new FileInputStream(file);
		BufferedInputStream bufferstream = new BufferedInputStream(filestream);
		Image image = ImageIO.read(bufferstream);
		
		ImplementImageProcessor processer = new ImplementImageProcessor();
		Image grayImage = processer.showGray(image);
		
		assertEquals(image.getWidth(null), grayImage.getWidth(null));
		assertEquals(image.getHeight(null), grayImage.getHeight(null));
		
		/*
		 * 测试输出的图片是否与goal文件夹下的图片一致。（比较位图像素值）；
		 * 
		 * */
		int width = grayImage.getWidth(null);
		int height = grayImage.getHeight(null);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferedImage.getGraphics().drawImage(grayImage, 0, 0, width, height, null);
		
		File goalFile = new File("/home/lucas/Documents/bmptest/goal/2_gray_goal.bmp");
		FileInputStream goalin = new FileInputStream(goalFile);
		BufferedImage goalBufferedImage = ImageIO.read(goalin);
		
		for (int i =0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				assertEquals(goalBufferedImage.getRGB(i, j), bufferedImage.getRGB(i, j));
			}
		}
	}
	
}
