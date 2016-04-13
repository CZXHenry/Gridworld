
import java.awt.Image;
import imagereader.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;
import java.awt.Toolkit;

public class ImplementImageProcessor implements IImageProcessor{

	@Override
	public Image showChanelB(Image arg0) {
		// TODO Auto-generated method stub
		//return null;
		ColorFilter redFilter = new ColorFilter(1);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.createImage(new FilteredImageSource(arg0.getSource(),redFilter));
		return img;
	}

	@Override
	public Image showChanelG(Image arg0) {
		// TODO Auto-generated method stub
		//return null;
		ColorFilter greenFilter = new ColorFilter(2);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.createImage(new FilteredImageSource(arg0.getSource(),greenFilter));
		return img;
	}

	@Override
	public Image showChanelR(Image arg0) {
		// TODO Auto-generated method stub
		//return null;
		ColorFilter blueFilter = new ColorFilter(3);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.createImage(new FilteredImageSource(arg0.getSource(),blueFilter));
		return img;
	}

	@Override
	public Image showGray(Image arg0) {
		// TODO Auto-generated method stub
		//return null;
		ColorFilter grayFilter = new ColorFilter(4);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.createImage(new FilteredImageSource(arg0.getSource(),grayFilter));
		return img;
	}
}

class ColorFilter extends RGBImageFilter {
	private int colorNum;
	public ColorFilter(int c) {
		colorNum = c;
		canFilterIndexColorModel = true;
	}
	public int filterRGB(int x, int y, int rgb) {
		if (colorNum == 1) {
			return (rgb&0xff0000ff);           //取出red值,再返回
		} else if (colorNum == 2) {
			return (rgb & 0xff00ff00);
		} else if (colorNum == 3) {
			return (rgb & 0xffff0000);
		} else {
			int red = ((rgb&0x00ff0000)>>16);   //分离出red值,再将之右移十六位,取出red值
			int green = ((rgb&0x0000ff00)>>8);  //分离出green值,再将之右移八位,取出green值
			int blue = ((rgb&0x000000ff));      //分离出blue值,不用移位
			int gray = (int)(red*0.299+green*0.587+blue*0.114);  //计算gray的值
			return (rgb&0xff000000) + (gray<<16) + (gray<<8)+gray;
		}
		
	}
}
