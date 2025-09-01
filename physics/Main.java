//@author: Melissa Chen
//@date: 2025 June 28
//@purpose: Lab 5; finding the hypotenuse and the angle of a triangle and determine if it's a 3-4-5; calculating the distance from Earth to Sun and see if it matches the known value

package labs.example.physics;

public class Main {
    public static void main(String[] args) {
        Physics physics = new Physics();

        //defining x and y
        int x = 3;
        int y = 4;

        //Part 1: calling the hypotenuse and angle arguments from Physics.java and using if-else statement to determine if angle information is valid
        double hypotenuse = physics.getHypotenuseOfTriangle(x, y);
        double angle = physics.getAngleInDegrees(x, y);

        //printing the value of the hypotenuse and angle that are calculated in Physics.java class
        System.out.println("Hypotenuse: " + hypotenuse);
        System.out.println("Angle: " + angle + " degrees");

        //if-else statement that is used to determine if the angle matches a 3-4-5 triangle
        if (angle > 37 || angle < 36.87) {
            physics.logInvalidAngleInfo(angle);
        } else {
            physics.logValidAngleInfo(angle);
        }

         // Part 2: Light speed calculation

         //assigning velocity and time that's used for getDistance() calculation
         double velocity = physics.getLightSpeedInMPH();
         double time = physics.getTimeFromSunToEarthInHours();
 
         //calculating thee calculatedDistance and restating the known distance
         double calculatedDistance = physics.getDistance(velocity, time);
         double knownDistance = physics.getKnownDistanceToEarth();
 
         System.out.println("Calculated Earth-Sun Distance: " + calculatedDistance);
 
         //checking if the calculatedDistance is the same as the knownDistance
         if (Math.abs(calculatedDistance - knownDistance) > 0) {
             physics.logEarthToSunInvalidDistance(calculatedDistance); //returns this if the distances are different
         } else {
             System.out.println("Calculated distance is valid and matches known Earth-Sun distance."); //if the distances are the same
         }

        // Test each method and print results with units
        System.out.println("Distance: " + physics.getDistance(60, 2) + " miles");
        System.out.println("Velocity: " + physics.getVelocity(120, 2) + " mph");
        System.out.println("Momentum: " + physics.getMomentum(5, 10) + " kg m/s");
        System.out.println("Force: " + physics.getForce(5, 9.81) + " kg m/s^2");
        System.out.println("Work: " + physics.getWork(10, 5) + " NM or Joules");
        System.out.println("Kinetic Energy: " + physics.getKineticEnergy(5, 10) + " NM or Joule");
        System.out.println("Potential Energy: " + physics.getPotentialEnergy(5, 10) + " NM or Joule");
        System.out.println("Displacement: " + physics.getDisplacement(10, 5, 2) + " miles");
        System.out.println("Velocity without time: " + physics.getVelocityWithoutTime(10, 2, 50) + " mph");
        System.out.println("Displacement with average velocity: " + 
            physics.getDisplacementAvgVelocity(10, 20, 5) + " miles/feet/inches");
        System.out.println("Time from stopped position: " + 
            physics.getTimeFromStoppedPosition(100, 9.81) + " seconds");
        System.out.println("Average velocity in uniform motion: " + 
            physics.getAvgVelocityInUniformMotion(100, 10) + " mph");
        System.out.println("Vertical velocity: " + 
            physics.getVerticalVelocity(50, 3) + " mph");
        System.out.println("Velocity vector of missile: " + 
            physics.getVelocityVectorOfMissile(30, 40) + " mph");
    }
}