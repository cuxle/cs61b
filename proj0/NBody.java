public class NBody {
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
			String imgFileName = in.readString();
			Body body = new Body(xxPos, yyPos, xxVel, yyVel, mess, imgFileName);
			bodies[i] = body;
		}

		return bodies;
	}
}