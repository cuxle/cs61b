/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static GuitarString[] string;
    private static void initString() {
        string = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            string[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24) / 12.0));
            System.out.println(keyboard.charAt(i));
        }

    }
    public static void main(String[] args) {
        //create all GuitarString
        initString();

        while (true) {

            /* check if the user has typed a key; if so, process it */
            int i = 0;
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                i = keyboard.indexOf(key);
                if (i == -1) {
                    continue;
                }
                string[i].pluck();
            }

            /* compute the superposition of samples */
            double sample = string[i].sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string[i].tic();
        }
    }
}
