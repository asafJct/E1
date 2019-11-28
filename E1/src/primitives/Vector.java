package primitives;

import java.lang.Math;

public class Vector {

	Point3D head;

	final public static Point3D Zero = new Point3D(0, 0, 0);
/***********c'ctor  ************
	 * @exception do not allow defining zero point.
	 * @throws newIllegalException()
	 */

	public Vector(Point3D head) {

		if (!head.equals(Zero))
			this.head = head;
	}

	public Vector(double x, double y, double z) {
		Point3D HeadPoint = new Point3D(x, y, z);
		if (!HeadPoint.equals(Zero))
			HeadPoint = new Point3D(x, y, z);
		this.head = HeadPoint;
	}
	/********* Getters************* */
	public Point3D getHead() {
		return head;
	}

	@Override
	public boolean equals(Object other) {
		if (head.equals(other)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return head.toString();
	}

	/**
	 * add function : Vector.add(Vector)
	 * sum of two vectors equals to the equivalent vector.
	 * @param other
	 * @return equivalent vector
	 */
	public Vector add(Vector other) {
		Point3D temp;
		Vector Otherhead;
		temp = new Point3D(this.head.getX().add(other.getHead().getX()).get(),
				this.head.getY().add(other.getHead().getY()).get(), this.head.getZ().add(other.getHead().getZ()).get());
		Otherhead = new Vector(temp);
		return Otherhead;
	}

	/**
	 * subtract function : Vector.sub(Vector)
	 * Subtract define as the sum of vector + -(other).
	 * @param other , type Vector
	 * @return equivalent vector.
	 */
	public Vector subtract(Vector other) {
		Point3D temp;
		Vector Otherhead;
		temp = new Point3D(this.head.getX().subtract(other.getHead().getX()).get(),
				this.head.getY().subtract(other.getHead().getY()).get(),
				this.head.getZ().subtract(other.getHead().getZ()).get());
		Otherhead = new Vector(temp);
		return Otherhead;
	}

	/**
	 * dot product multiplication
	 * (a,b,c) dotProduct (h,y,k) = a*h+b*y+c*k
	 * @param other , type Vector 
	 * @return  outcome of the formula below.
	 */
	public double dotProduct(Vector other) {
		double temp;
		temp = (this.head.getX().multiply(other.getHead().getX()).get()
				+ this.head.getY().multiply(other.getHead().getY()).get()
				+ this.head.getZ().multiply(other.getHead().getZ()).get());
		return temp;
	}
	/**
	 * cross product multiplication
	 * define as the result of
	 * (a,b,c) crossProduct (h,y,f) = (b*f-c*y,c*h-a*f,a*y-b*h).
	 * @param other , type Vector .
	 * @return orthogonal Vector.
	 * @throws an exception will be thrown , if Vectors are orthogonal.
	 */
	public Vector crossProduct(Vector other) {

		Point3D temp;
		Vector tempVec;
		double newX;
		double newY;
		double newZ;
		Coordinate thisX = new Coordinate(this.getHead().getX());
		Coordinate thisY = new Coordinate(this.getHead().getY());
		Coordinate thisZ = new Coordinate(this.getHead().getZ());
		Coordinate otherX = new Coordinate(other.getHead().getX());
		Coordinate otherY = new Coordinate(other.getHead().getY());
		Coordinate otherZ = new Coordinate(other.getHead().getZ());

		newX = thisY.multiply(otherZ).subtract(thisZ.multiply(otherY)).get();
		newY = thisZ.multiply(otherX).subtract(thisX.multiply(otherZ)).get();
		newZ = thisX.multiply(otherY).subtract(thisY.multiply(otherZ)).get();
		temp = new Point3D(newX, newY, newZ);
		tempVec = new Vector(temp);
		return tempVec;

	}

	/**
	 * squared length of the Vector
	 * @return |vec| squared.
	 */
	public double length2() {
		double a = this.head.getX().get();
		double b = this.head.getY().get();
		double c = this.head.getZ().get();
		double length = (a * a) + (b * b) + (c * c);
		return length;
	}

	/**
	 * length of the Vector
	 * define as size of Vector 
	 * |v|= sqrt(x*x + y*y + z*z)
	 * @return double norma of Vector
	 */
	public double length() {
		return Math.sqrt(length2());
	}

	/**
	 * change size of the Vector
	 *  (lamda) * (a Vector)
	 * @param num , type double 
	 * @return a Vector multiply by a scale number.
	 */
	public Vector scale(double num) {
		Point3D temp;
		Vector Otherhead;
		temp = new Point3D(this.head.getX().scale(num).get(), this.head.getY().scale(num).get(),
				this.head.getZ().scale(num).get());
		Otherhead = new Vector(temp);
		return Otherhead;
	}

	/**
	 * normalize Vector 
	 * Receiving a normal direction Vector 
	 * without change head.
	 * @return normal Vector.
	 */
	public Vector normalize() {
		Vector otherHead;
		double temp;
		temp = 1 / this.length();
		otherHead = this.scale(temp);
		return otherHead;
	}

}
