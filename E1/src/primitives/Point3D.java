package primitives;

import java.lang.Math;

public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;

	public Point3D(double x, double y, double z) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}

	@Override
	public String toString() {
		return "(" + x.toString() + "," + y.toString() + "," + z.toString() + ")";
	}

	public Coordinate getX() {
		return x;
	}

	public Coordinate getY() {
		return y;
	}

	public Coordinate getZ() {
		return z;
	}

	/**
	 * equal function
	 */
	@Override
	public boolean equals(Object other) {
		if (x.equals(((Point3D) other).getX())) {
			if (y.equals(((Point3D) other).getY())) {
				if (z.equals(((Point3D) other).getZ()))
					return true;
			}
		}
		return false;
	}

	/**
	 * Subtract function
	 * 
	 * @param other
	 * @return
	 */
	public Vector subtract(Point3D other) {
		Point3D temp;
		Vector vec;
		temp = new Point3D(other.getX().subtract(this.getX()).get(), other.getY().subtract(this.getY()).get(),
				other.getZ().subtract(this.getZ()).get());
		vec = new Vector(temp);
		return vec;
	}

	/**
	 * add function
	 * 
	 * @param other
	 * @return
	 */
	public Point3D add(Vector other) {
		Point3D temp;
		temp = new Point3D(this.getX().add(other.getHead().getX()).get(), this.getY().add(other.getHead().getY()).get(),
				this.getZ().add(other.getHead().getZ()).get());
		return temp;
	}

	/**
	 * Squared distance
	 * 
	 * @param other
	 * @return
	 */
	public double distance2(Point3D other) {
		if (this.equals(other))
			return 0;
		double a = this.getX().subtract(other.getX()).get();
		double b = this.getY().subtract(other.getY()).get();
		double c = this.getZ().subtract(other.getZ()).get();
		double temp = (a * a) + (b * b) + (c * c);
		return temp;
	}

	/**
	 * distance
	 * 
	 * @param other
	 * @return
	 */
	public double distance(Point3D other) {
		return Math.sqrt(distance2(other));
	}

}
