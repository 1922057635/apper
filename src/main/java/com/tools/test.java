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
		int r = s + random.nextInt(e - s);		//�������RGB��ɫ�е�rֵ
		int g = s + random.nextInt(e - s);		//�������RGB��ɫ�е�gֵ
		int b = s + random.nextInt(e - s);		//�������RGB��ɫ�е�bֵ
		return new Color(r, g, b);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int width = 400;			//ָ����֤��Ŀ��
		int height = 400;	
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();       
		Random random = new Random();              
		Font mFont = new Font("����", Font.BOLD, 22);
		g.fillRect(0, 0, width, height);
		g.setFont(mFont);
		g.setColor(getRandColor(180, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(13) + 1;
			int y1 = random.nextInt(16) + 1;
            g.drawLine(x, y, x + x1, y + y1);       //����ֱ��
		}
		
		BasicStroke bs=new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);	//����һ��������ѡ��������ϸ�Ķ���
		Graphics2D g2d = (Graphics2D) g;    //ͨ��Graphics��Ķ��󴴽�һ��Graphics2D��Ķ���
		g2d.setStroke(bs);					//�ı������Ĵ�ϸ
		g.setColor(Color.GRAY);		//���õ�ǰ��ɫΪԤ������ɫ�еĻ�ɫ
        int lineNumber=4;		//ָ���˵�ĸ���
		int[] xPoints=new int[lineNumber];      //���屣��x�����������
		int[] yPoints=new int[lineNumber];      //���屣��x�����������
        //ͨ��ѭ��Ϊx�������y����������鸳ֵ
		for(int j=0;j<lineNumber;j++){
			xPoints[j]=random.nextInt(width - 1);
			yPoints[j]=random.nextInt(height - 1);
		}
		g.drawPolyline(xPoints, yPoints,lineNumber);    //��������
		ImageIO.write(image, "JPEG", new File("C:\\Users\\���\\Desktop\\test.jpeg"));
	}

}
