package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()

        if (bpms == null || bpms.size() == 0) {
            throw new IllegalArgumentException("List cannot be null nor empty.");
        }

        String classification = "";
        double avg = 0.0;
        double total_bpms = 0.0;
        for (int bpm : bpms) {
            total_bpms += bpm;
        }
        avg = total_bpms / bpms.size();

        if (avg >= 140) {
            classification = "HIGH";
        } else if (avg >= 100) {
            classification = "MEDIUM";
        } else {
            classification = "LOW";
        }

        return classification;
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
        if (title == null || title == "" || title.length() > 30) {
            return false;
        }

        char[] chars = title.toCharArray();
        for (char c : chars) {
            if (!(Character.isLetter(c) || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}
