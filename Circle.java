package edhesive.shapes;
import java.lang.Math;
/**
 *  Represents a circle. Every circle created using this class has a positive radius.
 */
public class Circle{
  private double radius = 1.0;
  
  /**
   *  Creates a circle with a radius of <code>1.0</code>.
   */
  public Circle(){}
  
  /**
   *  Creates a circle with the specified radius.
   *  @param rad The radius of the new circle. This should be a positive number.
   */
  public Circle(double rad){
    setRadius(rad);
  }
  
  /**
   * Sets the radius of the circle to the specified radius.
   * @param rad the proposed new radius. This should be a positive number.
   */
  public void setRadius(double rad){
    if(rad > 0)
      radius = rad;
    else
      throw new IllegalArgumentException("The radius of a circle must be positive");
  }
  
  /**
   *  Used to get the radius of the circle, which will be a positive number.
   *  @return the radius of the circle.
   */
  public double getRadius(){
    return radius;
  }
  
  /**
   *  Calculates the area of this circle as a <code>double</code>.
   *  @return the area of the circle.
   */
  public double getArea(){
    return Math.PI * radius * radius;
  }
  
  /**
   *  Calculates the circumference of this circle as a <code>double</code>.
   *  @return the circumference of the circle.
   */
  public double getCircumference(){
    return Math.PI * 2 * radius;
  }
  
  /** Compares this circle to the specified object. The result is true if and only if the argument is not null and is a Circle object with the same radius as this object.
   *  @return true if the given object represents a Circle with the same radius as this one, false otherwise.
   */
  public boolean equals(Object anObject){
    if(anObject == null)
      return false;
    if(!(anObject instanceof Circle))
      return false;
    
    return (Math.abs(radius - ((Circle)anObject).getRadius()) < 0.00001);
  }
  
  /** A <code>String</code> representation of this circle. This is in the form "circle with radius r", where r is the double representing the radius of the circle to the nearest hundredth.
    * @return a <code>String</code> representation of this circle. 
    */
  public String toString()
  {
    return "circle with radius " + (double)(Math.round(radius*100))/100;
  }
}