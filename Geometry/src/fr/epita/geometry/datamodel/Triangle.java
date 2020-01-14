package fr.epita.geometry.datamodel;

public class Triangle implements Shape {
	private double base, height, sideA, sideB;

	public Triangle(double base, double height, double sideA, double sideB) {
//		super(); //Can be removed because there is no superclass
		this.base = base;
		this.height = height;
		this.sideA = sideA;
		this.sideB = sideB;
	}

	public double getArea() {
		double area = 0.5 * this.base * this.height;

		return area;
	}

	public double getPerimeter() {
		double perimeter = this.base + this.sideA + this.sideB;

		return perimeter;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

}
