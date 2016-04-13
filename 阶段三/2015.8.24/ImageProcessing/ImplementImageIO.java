
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import imagereader.*;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.*;

public class ImplementImageIO implements IImageIO{
    Image img;
	@Override
	public Image myRead(String arg0) throws IOException {
		File file = new File(arg0);
		try {
		    FileInputStream filestream = new FileInputStream(file);
		    
		    byte[] bmpHead = new byte[14];       //读取文件流0-15字节内容
		    filestream.read(bmpHead,0,14);       
		    byte[] bmpInfo = new byte[40];       //读取文件流16-55字节内容
		    filestream.read(bmpInfo,0,40); 
		    
		    int sizeOfBmp = ChangeInt(bmpInfo, 23);     //位图全部像素占用的字节数，BI_RGB时可设为0 0x1A
		    int widthOfBmp = ChangeInt(bmpInfo,7);       //位图的宽度，单位是像素
		    int heightOfBmp = ChangeInt(bmpInfo, 11);    //位图的高度，单位是像素
		    int bibitcount = (int) ((bmpInfo[15]&0xff)<<8)|((bmpInfo[14]&0xff));  //每个像素的位数
		    if (bibitcount==24) {
			    byte[] bmpImage = new byte[sizeOfBmp];    //读取文件流56-(56+sizeOfBmp-1)字节的内容
			    filestream.read(bmpImage, 0, sizeOfBmp);
			    
			    int numOfEmptyByte = sizeOfBmp/heightOfBmp - 3*widthOfBmp;
			    if (numOfEmptyByte ==4) {
			    	numOfEmptyByte = 0;
			    }
			    int[] bmpTemp = new int[widthOfBmp*heightOfBmp];
			    int temp = 0;
			    for (int i = heightOfBmp-1; i>=0; i--) {
			    	for (int j = 0; j < widthOfBmp; j++) {
			    	    bmpTemp[widthOfBmp*i+j] = (0xff<<24)
			    	    		|     ((bmpImage[temp+2]&0xff)<<16)
			    	    		|     ((bmpImage[temp+1]&0xff)<< 8)
			    	    		|     ((bmpImage[temp]&0xff));		 
			    	    temp += 3;
			    	}
			    	temp+= numOfEmptyByte;
			    }
   	            img = Toolkit.getDefaultToolkit().createImage((ImageProducer) new MemoryImageSource(widthOfBmp,heightOfBmp,bmpTemp,0,widthOfBmp));
		    }		    
		    filestream.close();
		    return img;	 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Image myWrite(Image arg0, String arg1) throws IOException {
		File file = new File(arg1);
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		BufferedImage buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		buffer.getGraphics().drawImage(arg0, 0, 0, width, height, null);
		ImageIO.write(buffer, "bmp", file);
		return null;
		// TODO Auto-generated method stub
		//return null;
	}
	
	public int ChangeInt(byte[] array, int flag) {
	    int temp = (int) ((array[flag]&0xff)<<24)
	    		|     ((array[flag-1]&0xff)<<16)
	    		|     ((array[flag-2]&0xff)<< 8)
	    		|     ((array[flag-3]&0xff));
		
		return temp;
	}
	
}
