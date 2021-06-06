/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class BMICalc {
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    BMICalc bmIndex = new BMICalc();
    double height = bmIndex.getHeight();
    double weight = bmIndex.getWeight();
    double bmi = bmIndex.calcBMI(height, weight);
    System.out.printf("Your BMI is %.2f.%n", bmi);
    System.out.println(bmIndex.checkRange(bmi));
  }

  public double getHeight() {
    System.out.print("What is your height (in)? ");
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR! Invalid Response, Try Again!");
      return getHeight();
    }

    return Double.parseDouble(n);
  }

  public double getWeight() {
    System.out.print("What is your weight (lbs)? ");
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR! Invalid Response, Try Again!");
      return getWeight();
    }

    return Double.parseDouble(n);
  }

  public double calcBMI(double height, double weight) {
    return (weight / (height * height)) * 703;
  }

  public String checkRange(double bmi) {
    String output = "You are within the ideal weight range.";
    if (bmi >= 18.5 && bmi <= 25) {
      return output;
    }
    else if (bmi < 18.5) {
      output = "underweight";
    }
    else {
      output = "overweight";
    }

    return "You are " + output + ". You should consult your doctor.";
  }
}
