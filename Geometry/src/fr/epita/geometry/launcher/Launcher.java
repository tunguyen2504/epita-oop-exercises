package fr.epita.geometry.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {

	public static void main(String[] args) {
//		Triangle triangle = new Triangle();
		Shape c1 = new Circle(4);
		Shape c2 = new Circle(6);
		Shape s1 = new Square(5);
		Shape s2 = new Square(8);

		List<Shape> shapeList = Arrays.asList(c1, c2, s1, s2);
		double totalPerimeter = 0;
		double totalArea = 0;
		for (Shape shape : shapeList) {
			totalPerimeter += shape.getPerimeter();
			totalArea += shape.getArea();
		}
		System.out.println("The total perimeter and total area is: " + totalPerimeter + " and " + totalArea);

		double c1Area = c1.getArea();
		double c2Area = c2.getArea();
		double s1Area = s1.getArea();
		double s2Area = s2.getArea();
		double c1Perimeter = c1.getPerimeter();
		double s1Perimeter = s1.getPerimeter();
		System.out.println("The area of circle 1 & 2 are: " + c1Area + " & " + c2Area);
		System.out.println("The area of square 1 & 2 are: " + s1Area + " & " + s2Area);
	}

}
