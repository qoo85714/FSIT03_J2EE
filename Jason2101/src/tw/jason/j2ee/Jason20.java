package tw.jason.j2ee;

public class Jason20 {
	private int x , y;
	public Jason20(String x, String y) {
		this.x=Integer.parseInt(x);
		this.y=Integer.parseInt(y);
	}
	public int add() {
		return x+y;
	}

}
