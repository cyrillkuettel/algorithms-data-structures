package ch.hslu.ad.sw12;

/**
 *
 * @author cyrill
 */
public final class Suchautomat {

    public static int stateSearch(final String str) {
        String searchPattern = "ANANAS";
        int i = 0;
        String state = "";

        final int notFound = -1;
        do {
            switch (state) {
                case "":
                    if (str.charAt(i) == 'A') {
                        state = "A";
                    } 
                    break;
                case "A":
                    if (str.charAt(i) == 'N') {
                        state = "AN";
                    } else {
                        state = "";
                    }
                    break;
                case "AN":
                    if (str.charAt(i) == 'A') {
                        state = "ANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANA":
                    if (str.charAt(i) == 'N') {
                        state = "ANAN";
                    } else if (str.charAt(i) == 'S') { // Sonderfall hier
                        state = "ANANAS";
                    } else {
                        state = "";
                    }
                    break;
                case "ANAN":
                    if (str.charAt(i) == 'A') {
                        state = "ANANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANANA":
                    if (str.charAt(i) == 'S') {
                        state = "ANANAS";
                    } else {
                        state = ""; // how else to proceed
                    }
                    break;
            }
            i++;
        } while (state != searchPattern && i < str.length());

        if (state == searchPattern) {
            System.out.printf("Found the patttern on String %s%n", str);
            return (i - searchPattern.length()); //  return the position of pattern start. 
        }
        return notFound;
    }

}
