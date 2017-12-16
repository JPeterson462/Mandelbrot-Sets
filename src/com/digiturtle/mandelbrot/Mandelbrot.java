package com.digiturtle.mandelbrot;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Mandelbrot {

	private BufferedImage image;

	public Mandelbrot(int n, double xc, double yc, double size, int max) {
		image = new BufferedImage(n, n, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				double x0 = xc - size / 2 + size * x / n;
				double y0 = yc - size / 2 + size * y / n;
				Complex z0 = new Complex(x0, y0);
				image.setRGB(x, n - y - 1, getColor(mandelbrot(z0, max)).getRGB());
			}
		}
	}
	
	private Color getColor(int mandelbrot) {
		System.out.println(mandelbrot);
		switch (mandelbrot) {
			case 255: return Color.WHITE;
			case 1: return Color.RED;
			case 2: return Color.ORANGE;
			case 3: return Color.YELLOW;
			case 4: return Color.GREEN;
			case 5: return Color.BLUE;
			case 6: return Color.PINK;
			case 7: return Color.MAGENTA;
		}
		return Color.BLACK;
	}
	
	public int width() {
		return image.getWidth();
	}
	
	public int height() {
		return image.getHeight();
	}

	private int mandelbrot(Complex z0, int max) {
		Complex z = z0;
		for (int t = 0; t < max; t++) {
			if (z.abs() > 2.0) return t;
			z = z.times(z).plus(z0);
		}
		return max;
	}

	public BufferedImage getImage() {
		return image;
	}

}
