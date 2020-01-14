package fr.epita.geometry.datamodel;

public class Square implements Shape {
	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getArea() {
		double area = Math.pow(this.side, 2);

		return area;
	}

	public double getPerimeter() {
		double perimeter = this.side * 4;

		return perimeter;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if (side <= 0)
			return;
		this.side = side;
	}
}
