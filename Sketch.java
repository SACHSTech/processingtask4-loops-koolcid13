import processing.core.PApplet;

/**
* A program Sketch.java that implements the picture provided with four quadrants: quadrant one being a 10 x 10 grid, quadrant two a 5 x grid of evenly spaced circles, quadrant 3 a grayscale gradient, and quadrant 4 a flower with 8 petals.
* @author: Avin A.
*
*/

public class Sketch extends PApplet {

  
  public void settings() {
	  // size of the window
    size(400, 400);
  }

  
  public void setup() {
    // sets background colour to white
    background(255, 255, 255);
  }

  
  public void draw() {
    // QUADRANT 1:
    
    // variable defined for the space between the lines
	  int gridConstant = width / 20;
    // sets colour of lines
    stroke (0, 0, 0);
    // draws lines by adding the value of gridConstant to the x- and y- coordinates in every loop
    for (int i = 0; i < 9; i ++) {
      line (0, gridConstant * (i + 1), width / 2, gridConstant * (i + 1));
      line (gridConstant * (i + 1), 0, gridConstant * (i + 1), width / 2);
    }
    
    // QUADRANT 2:

    // variable defined for the space between the circles
    int circleConstant = width / 12;
    // sets the colour
    fill (212, 28, 151);
    // draws circles from up to down in each column with the diameters of width / 18
    for (int i = 0; i < 5; i ++) {
      for (int j = 0; j < 5; j ++) {
        ellipse (width / 2 + circleConstant * (i + 1), circleConstant * (j + 1), width / 18, width / 18);
      }
    }

    // QUADRANT 3:

    // it is intended that rectangles are drawn each changing colours to have a lighter shade
    // sets the width of the rectangles
    float rectWidth = (float) width / (float) 512;
    // each for loop changes the colour of the rectangle and changes the coordinates to move the shape to the right
    for (int i = 0; i < 256; i ++) {
      stroke (i, i, i);
      fill (i, i, i);
      rect (rectWidth * i, width / 2, rectWidth, width / 2);
    }
    // draws the extra line
    stroke (0, 0, 0);
    line (0, width / 2, width / 2, width / 2);

    // QUADRANT 4:

    // sets colours
    stroke (0, 0, 0);
    fill (224, 102, 31);
    // matrix is pushed and coordinates are translated by the value: 0.75 x width
    pushMatrix();
    translate ((float) (0.75 * width), (float) (0.75 * width));
    // 8 flower petals are drawn and each is rotated 45 degrees more than the last one. coordinates used are now dependent to how we translated the matrix of coordinates
    for (int i = 0; i < 8; i ++) {
      rotate (radians(45 * i));
      ellipse (0, (float) -(width * 0.1), width / 22, (float) (width * 0.16));
    }
    // pop Matrix (coordinates go back to their original state)
    popMatrix();
    // sets colours
    stroke (12, 110, 41);
    fill (12, 110, 41);
    // draws the middle circle for the flower
    ellipse ((float) (0.75 * width), (float) (0.75 * width), width / 9, width / 9);
    
  }
}