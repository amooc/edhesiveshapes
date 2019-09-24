package edhesive.shapes;
import java.lang.Math;
/**
 *  Represents a Regular Polygon. Every shape created using this class has an integer number of sides greater than 3 all with the same length.
 */
public class RegularPolygon{
  private int numSides = 3;
  private double sideLength = 1.0;
  
  /**
   *  Creates an equilateral triangle with side length 1.0.
   */
  public RegularPolygon(){}
  
  /**
   *  Creates a regular polygon with the given number of sides. Side lengths default to <code>1.0</code>.
   *  @param num the number of sides in the polygon. This should be 3 or greater.
   */
  public RegularPolygon(int num){
    setNumSides(num);
  }
  
  /**
   *  Creates an equilateral triangle with the given side length.
   *  @param len the length of each side in the polygon. This should be positive.
   */
  public RegularPolygon(double len){
    setSideLength(len);
  }
  
  /**
   *  Creates a regular polygon with the given number of sides and side length.
   *  @param num the number of sides in the polygon. This should be 3 or greater.
   *  @param len the length of each side in the polygon. This should be positive.
   */
  public RegularPolygon(int num, double len){
    setNumSides(num);
    setSideLength(len);
  }
  
  /**
   * Sets the side length of the regular polygon to the specified length.
   * @param len the proposed new side length. This should be a positive number.
   */
  public void setSideLength(double len){
    if(len > 0)
      sideLength = len;
    else
      throw new IllegalArgumentException("The length of a side must be positive");
  }
  
  /**
   * Sets the number of sides of the regular polygon to the specified number.
   * @param num the proposed new number of sides. This should be 3 or greater.
   */
  public void setNumSides(int num){
    if(num > 2)
      numSides = num;
    else
      throw new IllegalArgumentException("The number of sides in a regular polygon must be 3 or greater");
  }
  
  /**
   *  Used to get the number of sides in the polygon.
   *  @return the number of sides in the regular polygon.
   */
  public int getNumSides(){
    return numSides;
  }
  
  /**
   *  Used to get the length of each side in the regular polygon.
   *  @return the side length of the regular polygon.
   */
  public double getSideLength(){
    return sideLength;
  }
  
  /**
   *  Calculates the area of this regular polygon as a <code>double</code>.
   *  @return the area of the regular polygon.
   */
  public double getArea(){
    double s = sideLength;
    double n = numSides;
    return (s*s*n)/(4*Math.tan(Math.PI/n));
  }
  
  /**
   *  Calculates the perimeter of this regular polygon as a <code>double</code>.
   *  @return the perimeter of the regular polygon.
   */
  public double getPerimeter(){
    return sideLength * numSides;
  }
  
  /** Compares this regular polygon to the specified object. The result is true if and only if the argument is not null and represents a polygon with the same number of sides and side lengths as this one.
   *  @return true if the given object represents a Rectangle with the same length and width as this one, false otherwise.
   */
  public boolean equals(Object anObject){
    if(anObject == null)
      return false;
    if(numSides == 4
         && anObject instanceof Rectangle
         && Math.abs(((Rectangle)anObject).getWidth() - sideLength) < 0.00001
         && Math.abs(((Rectangle)anObject).getLength() - sideLength) < 0.00001)
      return true;
    if(!(anObject instanceof RegularPolygon))
      return false;
    
    return numSides == ((RegularPolygon)anObject).getNumSides() && (Math.abs(sideLength - ((RegularPolygon)anObject).getSideLength()) < 0.00001);
  }
  
  /**
   *  Increases the number of sides in the polygon by 1. The lengths of the sides in the polygon are unaffected, with the additional side having the same length as the others so the shape remains a regular polygon.
   */
  public void addSides(){
    numSides++;
  }
  
  /**
   *  Increases the number of sides in the polygon by the given number. The lengths of the sides in the polygon are unaffected, with the additional side having the same length as the others so the shape remains a regular polygon.
   *  @param numExtra the number of sides to add to the polygon.
   */
  public void addSides(int numExtra){
    numSides += numExtra;
  }
  
  /** A <code>String</code> representation of this regular polygon. The string returned is in the form "regular shape_name with side length l", where l is the length of each side, and shape_name is the correct polygon name for shapes between 5 and 20 sides inclusive. For shapes with more sides the phrase "polygon of n sides", where n is the number of sides, is used. For shapes of side 3 the string returned is "equilateral triangle with side length l", and for shapes of side 4 the string returned is "square with side length l".
    *  @return a <code>String</code> representation of this polygon. 
    */
  public String toString()
  {
    String s = "";
    if(numSides == 3)
      s += "equilateral triangle";
    else if (numSides == 4)
      s += "square";
    else{
      s += "regular ";
      if(numSides <= 20){
        String[] names = {"pentagon", "hexagon", "heptagon", "octagon", "nonagon", "decagon", "hendecagon", "dodecagon", 
          "triskaidecagon", "tetrakaidecagon", "pentadecagon", "hexadecagon", "heptadecagon", "octadecagon", "enneadecagon", "icosagon"};
        s += names[numSides - 5];
      }
      else
        s += "polygon of " + numSides + " sides";
    }
    
    s += " with side length " + (double)(Math.round(sideLength*100))/100;
    return s;
  }
}