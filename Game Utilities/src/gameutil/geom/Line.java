package gameutil.geom;

public class Line {
	private Vector P1;
	private Vector P2;
	private Vector v;//the vector parallel to the line
	
	/**initializes a line that intersects the tails of the input vectors
	 * 
	 * @param v1
	 * @param v2
	 */
	public Line(Vector v1,Vector v2){
		this.P1=v1;
		this.P2=v2;
		v=P1. $S$ (P2);
	}
	
	public boolean containsPoint(Point p){
		double t=( new Vector(p). $S$ (P1). $D$ (v) ).getSpds().i(0);
		return p.equals(new Point(equation(t).end()));
		//return p.tuple.
	}
	
	public Vector equation(double t){
		return (v. $X$ (t)). $A$ (P1);
	}
}
