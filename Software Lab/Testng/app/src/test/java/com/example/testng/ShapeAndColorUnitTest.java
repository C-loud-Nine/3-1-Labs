package com.example.testng;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeAndColorUnitTest {

    @Test
    public void testCircleAreaAndPerimeter() {
        Circle circle = new Circle("Circle", 5);
        assertEquals(78.54, circle.area(), 0.01);
        assertEquals(31.42, circle.perimeter(), 0.01);
    }

    @Test
    public void testSquareAreaAndPerimeter() {
        Square square = new Square("Square", 4);
        assertEquals(16, square.area(), 0.01);
        assertEquals(16, square.perimeter(), 0.01);
    }

    @Test
    public void testTriangleAreaAndPerimeter() {
        Triangle triangle = new Triangle("Triangle", 3, 4, 5);
        assertEquals(6, triangle.area(), 0.01);
        assertEquals(12, triangle.perimeter(), 0.01);
    }

    @Test
    public void testColorName() {
        Red red = new Red();
        assertEquals("Red", red.name);

        Blue blue = new Blue();
        assertEquals("Blue", blue.name);

        Green green = new Green();
        assertEquals("Green", green.name);
    }
}
