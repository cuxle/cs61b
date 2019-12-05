public class NBody {
	public static String imgPrefix = "/home/cs61b/cs61b/cs61b_github/skeleton-sp19/proj0/images/";
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int planetNums;
		double radius;
		planetNums = in.readInt();
		radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String fileName) {
		In in = new In(fileName);
		int bodyNums = in.readInt();
		Body[] bodies = new Body[bodyNums];
		in.readDouble();
		for (int i = 0; i < bodyNums; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mess = in.readDouble();
			String imgFileName = imgPrefix + in.readString();
			Body body = new Body(xxPos, yyPos, xxVel, yyVel, mess, imgFileName);
			bodies[i] = body;
		}

		return bodies;
	}

	public static void main(String[] args) {
		double T;
		double dt;
		double time = 0;
		String filename;
		String bgFileName = "/home/cs61b/cs61b/cs61b_github/skeleton-sp19/proj0/images/starfield.jpg";

		if (args.length < 3) {
			return;
		}
		T = Double.parseDouble(args[0]);
		dt = Double.parseDouble(args[1]);
		filename = args[2];

		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);

		/** DRAW section */
		StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three Compileres of advice.png in a triangular pattern. */
		while (time < T) {
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			for (int i = 0; i < bodies.length; i++) {
				//xForces[i] = new double;
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				//yForces[i] = new double;
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, bgFileName);

			for (int i = 0; i < bodies.length; i++) {
				//System.out.println(bodies[i].imgFileName);
				bodies[i].draw();
			}

			/* Shows the drawing to the screen, and waits 2000 milliseconds. */
			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}



	}
}