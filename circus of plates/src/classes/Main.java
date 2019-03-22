package classes;


	import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
	
import java.io.IOException;

// w w w  . jav  a 2s  . com
import javax.imageio.ImageIO;

	public class Main {
		  public static void main(String args[]) throws IOException{
			  		  ColorShapes b= new ColorShapes();
			 	  BufferedImage img = b.color("n44.png", Color.red);
			  	    ImageIO.write(img, "png", new File("Test.png"));
			  	  File file= new File("test.png");
				  BufferedImage image = ImageIO.read(file);
				  // Getting pixel color by position x and y 
				  int clr=  image.getRGB(image.getMinX(),image.getMinY()); 
				  int  red   = (clr & 0x00ff0000) >> 16;
				  int  green = (clr & 0x0000ff00) >> 8;
				  int  blue  =  clr & 0x000000ff;
				  System.out.println(red);
				  System.out.println(green);
				  System.out.println(blue);
			  	  }
			  
			 	  private static BufferedImage colorImage(BufferedImage image) {
			  	    int width = image.getWidth();
			  	    int height = image.getHeight();
			      WritableRaster raster = image.getRaster();
			  
			      for (int xx = 0; xx < width; xx++) {
			        for (int yy = 0; yy < height; yy++) {
			          int[] pixels = raster.getPixel(xx, yy, (int[]) null);
			          pixels[0] =pixels[0]+ 0;
			          pixels[1] = 255;
			          pixels[2] = pixels[2]+0;
			          raster.setPixel(xx, yy, pixels);
			        }
			 	    }
			  	    return image;
			  

			  }
	}

