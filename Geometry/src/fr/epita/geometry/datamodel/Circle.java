package fr.epita.geometry.datamodel;

public class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		double area = Math.PI * Math.pow(this.radius, 2);

		return area;
	}

	public double getPerimeter() {
		double perimeter = Math.PI * this.radius * 2;

		return perimeter;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius <= 0) {
			System.out.println("Input is invalid.");
			return;
		}
		this.radius = radius;
	}
}
