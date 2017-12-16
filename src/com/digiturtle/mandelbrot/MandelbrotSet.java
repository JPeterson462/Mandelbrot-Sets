package com.digiturtle.mandelbrot;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MandelbrotSet {
	
	public static void main(String[] args) {
		new MandelbrotSet();
	}
	
	public MandelbrotSet() {
		Mandelbrot mandelbrot = new Mandelbrot(1024, 0, 0, 5, 255);
		System.out.println("Generated Mandelbrot");
		new MandelbrotPicture(mandelbrot);
	}
	
	class MandelbrotPicture extends Frame {
		
		private static final long serialVersionUID = -1L;
		
		private Mandelbrot mandelbrot;
		
		public MandelbrotPicture(Mandelbrot mandelbrot) {
			super("Mandelbrot Set");
			this.mandelbrot = mandelbrot;
			setSize(mandelbrot.width(), mandelbrot.height());
			setVisible(true);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose(); 
					System.exit(0);
				}
			});
		}
		
		public void paint(Graphics g) {
			g.drawImage(mandelbrot.getImage(), 0, 0, null);
		}
		
	}

}
