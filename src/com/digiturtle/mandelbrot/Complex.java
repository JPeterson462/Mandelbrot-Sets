package com.digiturtle.mandelbrot;

public class Complex {
	
	private double real, imaginary;
	
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public double abs() {
		return Math.hypot(imaginary, real);
	}
	
	public Complex plus(Complex c) {
		real += c.real;
		imaginary += c.imaginary;
		return this;
	}
	
	public Complex times(Complex c) {
		double realPart = real, imaginaryPart = imaginary;
		real = realPart * c.real - imaginaryPart * c.imaginary;
		imaginary = realPart * c.imaginary + imaginaryPart * c.real;
		return this;
	}

}
