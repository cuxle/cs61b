public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos) + (yyPos - b.yyPos)*(yyPos - b.yyPos));
	}

	public double calcForceExertedBy(Body b) 
	{
		double distance = this.calcDistance(b);

		return 6.67E-11 * mass * b.mass / (distance * distance);
	}

	public double calcForceExertedByX(Body b) 
	{
		double dx = b.xxPos - xxPos;
		double r = this.calcDistance(b);
		double force = calcForceExertedBy(b);
		return dx * force / r;
	}

	public double calcForceExertedByY(Body b) 
	{
		double dy = b.yyPos - yyPos;
		double r = this.calcDistance(b);
		double force = calcForceExertedBy(b);
		return dy * force / r;
	}

	public double calcNetForceExertedByX (Body[] br)
	{
		double fx = 0;
		for (int i = 0; i < br.length; i++) {
			if (this == br[i]) {
				continue;
			}
			fx += this.calcForceExertedByX(br[i]);
		}
		return fx;
	}

	public double calcNetForceExertedByY (Body[] br)
	{

		double fy = 0;
		for (int i = 0; i < br.length; i++) {
			if (this == br[i]) {
				continue;
			}
			fy += this.calcForceExertedByY(br[i]);
		}
		return fy;
	}

	public void update(double dt, double fx, double fy) 
	{
		xxVel = xxVel + fx * dt / mass;
		yyVel = yyVel + fy * dt / mass;
		xxPos = xxPos + xxVel * dt;
		yyPos = yyPos + yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}
}