package com.example.testng;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Define the Shape class
abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    abstract double area();

    abstract double perimeter();
}

// Implement subclasses of Shape
class Circle extends Shape {
    double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double area() {
        return 3 * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * 3 * radius;
    }
}

class Square extends Shape {
    double sideLength;

    Square(String name, double sideLength) {
        super(name);
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return sideLength * sideLength;
    }

    @Override
    double perimeter() {
        return 4 * sideLength;
    }
}

class Triangle extends Shape {
    double side1;
    double side2;
    double side3;

    Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double perimeter() {
        return side1 + side2 + side3;
    }
}

// Define the Color class
class Color {
    String name;

    Color(String name) {
        this.name = name;
    }
}

// Implement subclasses of Color
class Red extends Color {
    Red() {
        super("Red");
    }
}

class Blue extends Color {
    Blue() {
        super("Blue");
    }
}

class Green extends Color {
    Green() {
        super("Green");
    }
}

public class MainActivity extends AppCompatActivity {
    TextView shapeInfoTextView, colorInfoTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        shapeInfoTextView = findViewById(R.id.shapeInfoTextView);
        colorInfoTextView = findViewById(R.id.colorInfoTextView);

        // Create instances of shapes and colors
        Circle circle = new Circle("Circle", 5);
        Square square = new Square("Square", 4);
        Triangle triangle = new Triangle("Triangle", 3, 4, 5);
        Red red = new Red();
        Blue blue = new Blue();
        Green green = new Green();

        // Display shape information
        shapeInfoTextView.setText("Shape Information:\n" +
                "Circle - Area: " + circle.area() + ", Perimeter: " + circle.perimeter() + "\n" +
                "Square - Area: " + square.area() + ", Perimeter: " + square.perimeter() + "\n" +
                "Triangle - Area: " + triangle.area() + ", Perimeter: " + triangle.perimeter());

        // Display color information
        colorInfoTextView.setText("Color Information:\n" +
                "Red\n" +
                "Blue\n" +
                "Green");
    }
}
