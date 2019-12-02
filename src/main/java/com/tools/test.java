package com.tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class test {
	public static Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255) s = 255;
		if (e > 255) e = 255;
		int r = s + random.nextInt(e - s);		//随机生成RGB颜色中的r值
		int g = s + random.nextInt(e - s);		//随机生成RGB颜色中的g值
		int b = s + random.nextInt(e - s);		//随机生成RGB颜色中的b值
		return new Color(r, g, b);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int width = 400;			//指定验证码的宽度
		int height = 400;	
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();       
		Random random = new Random();              
		Font mFont = new Font("宋体", Font.BOLD, 22);
		g.fillRect(0, 0, width, height);
		g.setFont(mFont);
		g.setColor(getRandColor(180, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(13) + 1;
			int y1 = random.nextInt(16) + 1;
            g.drawLine(x, y, x + x1, y + y1);       //绘制直线
		}
		
		BasicStroke bs=new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);	//创建一个供画笔选择线条粗细的对象
		Graphics2D g2d = (Graphics2D) g;    //通过Graphics类的对象创建一个Graphics2D类的对象
		g2d.setStroke(bs);					//改变线条的粗细
		g.setColor(Color.GRAY);		//设置当前颜色为预定义颜色中的灰色
        int lineNumber=4;		//指定端点的个数
		int[] xPoints=new int[lineNumber];      //定义保存x轴坐标的数组
		int[] yPoints=new int[lineNumber];      //定义保存x轴坐标的数组
        //通过循环为x轴坐标和y轴坐标的数组赋值
		for(int j=0;j<lineNumber;j++){
			xPoints[j]=random.nextInt(width - 1);
			yPoints[j]=random.nextInt(height - 1);
		}
		g.drawPolyline(xPoints, yPoints,lineNumber);    //绘制折线
		ImageIO.write(image, "JPEG", new File("C:\\Users\\斌斌\\Desktop\\test.jpeg"));
	}

}
