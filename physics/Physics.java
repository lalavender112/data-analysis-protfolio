//@author: Melissa Chen
//@date: 2025 June 20
//@purpose: Lab 5; finding the hypotenuse and the angle of a triangle and determine if it's a 3-4-5; calculating the distance from Earth to Sun and see if it matches the known value

package labs.example.physics;

import java.lang.Math;

public class Physics {
    final static double GRAVITY = 9.81; // m/s^2

    // Week 5 Lab starts here
    
    //defining hypotenuse
    public double getHypotenuseOfTriangle(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    //finding the angle between x and y
    public double getAngleInDegrees(int x, int y) {
        double radians = Math.atan2(y, x);
        return radians * 180 / Math.PI;
    }

    //works with the if-else statement in Main.java. If the "if statement" isn't valid, the program will return the following message
    public void logInvalidAngleInfo(double angle) {
        System.out.println("logging the angle " + angle + " degrees. This is not a right angle.");
    }

    //If the "if statement" is valid, the program will return the following message
    public void logValidAngleInfo(double angle) {
        System.out.println("logging the angle " + angle + " degrees. This is a valid 3-4-5 triangle");
    }

    //defining distance
    public double getDistance(double velocity, double time) {
        return velocity * time;
    }

     // Defining light speed in miles per hour
     public double getLightSpeedInMPH() {
        return 186282 * 3600; // convert miles/sec to miles/hour
    }

    // Time it takes for light to travel from Sun to Earth, in hours
    public double getTimeFromSunToEarthInHours() {
        double lightSpeedMPS = 186282;
        double timeInSeconds = 92947266.72 / lightSpeedMPS; // distance / speed
        return timeInSeconds / 3600; // convert to hours
    }

    // Defining known Earth-Sun distance
    public double getKnownDistanceToEarth() {
        return 92947266.72; // miles
    }

    public void logEarthToSunInvalidDistance(double distance) {
        System.out.println("Calculated distance " + distance + " miles is invalid.");
    }

    // Other physics methods
    public double getVelocity(double distance, double time) {
        return distance / time;
    }

    public double getMomentum(double mass, double velocity) {
        return mass * velocity;
    }

    public double getForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    public double getWork(double force, double distance) {
        return force * distance;
    }

    public double getKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * Math.pow(velocity, 2);
    }

    public double getPotentialEnergy(double mass, double height) {
        return mass * GRAVITY * height;
    }

    public double getDisplacement(double initialVelocity, double time, double acceleration) {
        return (initialVelocity * time) + (0.5 * acceleration * Math.pow(time, 2));
    }

    public double getVelocityWithoutTime(double initialVelocity, double acceleration, double displacement) {
        return Math.sqrt(Math.pow(initialVelocity, 2) + (2 * acceleration * displacement));
    }

    public double getDisplacementAvgVelocity(double initialVelocity, double finalVelocity, double time) {
        return ((initialVelocity + finalVelocity) / 2) * time;
    }

    public double getTimeFromStoppedPosition(double displacement, double acceleration) {
        return Math.sqrt((2 * displacement) / acceleration);
    }

    public double getAvgVelocityInUniformMotion(double displacement, double time) {
        return displacement / time;
    }

    public double getVerticalVelocity(double initialVerticalVelocity, double time) {
        return initialVerticalVelocity - (GRAVITY * time);
    }

    public double getVelocityVectorOfMissile(double velocityX, double velocityY) {
        return Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
    }
}
