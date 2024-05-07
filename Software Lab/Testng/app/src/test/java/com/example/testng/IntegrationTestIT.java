package com.example.testng;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTestIT {

    @Test
    public void testShapeCreation() {
        Circle circle = new Circle("Circle", 5);
        Square square = new Square("Square", 4);
        Triangle triangle = new Triangle("Triangle", 3, 4, 5);

        assertNotNull(circle);
        assertNotNull(square);
        assertNotNull(triangle);
    }

    @Test
    public void testColorCreation() {
        Red red = new Red();
        Blue blue = new Blue();
        Green green = new Green();

        assertNotNull(red);
        assertNotNull(blue);
        assertNotNull(green);
    }
}
