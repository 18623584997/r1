package test;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Test3 {
	static Integer NUM=5;
	static Integer count=0;
	public static void main(String[] args) {
//		for(Integer i=NUM;i>0;i--){
//			Integer[] ss = new  Integer[1];
//			ss[0]=i;
//			printNumber(NUM, ss);
//		}
		
		makeRoundedCorner("d:/k1.jpg", "d:/k2.png", "png", 100);
		

	}
	public static void printNumber(int target,Integer[] reuslts){
       if(validate(reuslts, target)==target){
    	  
    	   show(reuslts);
    	   return;
    	   
    	   
       }else{
    	   Integer cc = 1;
    	   while(validate(reuslts, target)<target&&validate(reuslts)){
    		   Integer[] ss = new  Integer[reuslts.length+1];
    		  
    		   ss[ss.length-1]=cc;
    		   copy(reuslts,ss);
    		   printNumber(target,ss);
    		   cc++;
    		   reuslts[reuslts.length-1]=reuslts[reuslts.length-1]+1;
    	   }
       }
	}
	public static Integer validate(Integer[] reuslts,Integer target){
		Integer all =0;
		for(Integer i : reuslts){
			all=all+i;
		}
		return all;
		
	}
	
	public static boolean validate(Integer[] reuslts){
		if(reuslts.length==1){
			return true;
		}else{
			if(reuslts[reuslts.length-1]<=reuslts[reuslts.length-2]){
				return true;
			}else{
				return false;
			}
		}
		
		
	}
	
	public static void show(Integer[] reuslts){
		StringBuilder bf = new StringBuilder();
		for(Integer i : reuslts){
			bf.append(i+"+");
			
		}
		count++;
		String temp = bf.toString();
		temp = temp.substring(0, temp.length()-1);
		System.out.println(count+"-->"+temp);
	}
	
	public static Integer[] copy(Integer[] copy,Integer[] copy2){
		
		for(Integer i=0; i<copy.length;i++){
			copy2[i] =copy[i];
		}
		return copy2;
	}
	
	
	public static String makeRoundedCorner(String srcImageFile, String result, String type, int cornerRadius) {
	    try {
	        BufferedImage image = ImageIO.read(new File(srcImageFile));
	        int w = image.getWidth();
	        int h = image.getHeight();
	        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = output.createGraphics();
	        output = g2.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
	        g2.dispose();
	        g2 = output.createGraphics();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.fillRoundRect(0, 0,w, h, cornerRadius, cornerRadius);
	        g2.setComposite(AlphaComposite.SrcIn);
	        g2.drawImage(image, 0, 0, w, h, null);
	        g2.dispose();
	        ImageIO.write(output, type, new File(result));
	        return result;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	/**
     * 图片设置圆角
     * @param srcImage
     * @param radius
     * @param border
     * @param padding
     * @return
     * @throws IOException
     */
    public static BufferedImage setRadius(BufferedImage srcImage, int radius, int border, int padding) throws IOException{
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();
        int canvasWidth = width + padding * 2;
        int canvasHeight = height + padding * 2;
        
        BufferedImage image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gs = image.createGraphics();
        gs.setComposite(AlphaComposite.Src);
        gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gs.setColor(Color.WHITE);
        gs.fill(new RoundRectangle2D.Float(0, 0, canvasWidth, canvasHeight, radius, radius));
        gs.setComposite(AlphaComposite.SrcAtop);
        gs.drawImage(setClip(srcImage, radius), padding, padding, null);
        if(border !=0){
            gs.setColor(Color.GRAY);
            gs.setStroke(new BasicStroke(border));
            gs.drawRoundRect(padding, padding, canvasWidth - 2 * padding, canvasHeight - 2 * padding, radius, radius);    
        }
        gs.dispose();
        return image;
    }
    
    /**
     * 图片设置圆角
     * @param srcImage
     * @return
     * @throws IOException
     */
    public static BufferedImage setRadius(BufferedImage srcImage) throws IOException{
        int radius = (srcImage.getWidth() + srcImage.getHeight()) / 6;
        return setRadius(srcImage, radius, 2, 5);
    }
    
    /**
     * 图片切圆角
     * @param srcImage
     * @param radius
     * @return
     */
    public static BufferedImage setClip(BufferedImage srcImage, int radius){
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gs = image.createGraphics();

        gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gs.setClip(new RoundRectangle2D.Double(0, 0, width, height, radius, radius));
        gs.drawImage(srcImage, 0, 0, null);
        gs.dispose();
        return image;
    }

}
