package primitives;

public class Ray {
	private Vector vec;
	private Point3D p;
	/**
	 * *********** c'ctor ***********
	 * 
	 * @param vec , direction Vector.
	 * @param p   , a point on the Ray
	 */
	public Ray(Vector vec, Point3D p) {

		this.vec = vec.normalize();
		this.p = p;
	}
	/************** Getters ************* */
	public Vector getVector() {
		return vec;
	}

	public Point3D getHead() {
		return p;
	}

	@Override
	public boolean equals(Object other) {
		if (p.equals(other) == true) {
			if (vec.equals(other) == true) {
				return true;
			}
		}
		return false;
	}

	public Ray scale(double num) {
		Vector newVec = vec.scale(num);
		Ray scaledRay = new Ray(newVec, p);
		return scaledRay;
	}

	@Override
	public String toString() {
		return "from " + p.toString() + " to " + vec.toString();
	}
}
