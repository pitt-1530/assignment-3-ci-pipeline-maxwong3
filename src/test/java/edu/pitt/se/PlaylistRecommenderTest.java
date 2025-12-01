package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class PlaylistRecommenderTest {

    @Test 
    void testClassifyEnergy() {
        List<Integer> sampleBpms = new ArrayList<Integer>();
        sampleBpms.add(101);
        sampleBpms.add(102);
        sampleBpms.add(103);
        sampleBpms.add(104);
        sampleBpms.add(105);
        // Should be MEDIUM (averages 103)
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(sampleBpms));
    }

    @Test 
    void testClassifyEnergyLow() {
        List<Integer> sampleBpms = new ArrayList<Integer>();
        sampleBpms.add(-101);
        sampleBpms.add(-102);
        sampleBpms.add(-103);
        sampleBpms.add(-104);
        sampleBpms.add(-105);
        // Should be LOW (averages -103)
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(sampleBpms));
    }

    @Test
    void testClassifyEnergyInvalidParameter() {
        List<Integer> sampleBpms = new ArrayList<Integer>();
        assertThrows(Exception.class, () -> PlaylistRecommender.classifyEnergy(sampleBpms));
    }

    @Test
    void testIsValidTrackTitle() {
        String title = "Digital Bath";
        assertTrue(PlaylistRecommender.isValidTrackTitle(title));
    }

    @Test
    void testIsValidTrackTitleInvalid() {
        String title = "Keep Droppin'";
        assertFalse(PlaylistRecommender.isValidTrackTitle(title));
    }

    @Test
    void testIsValidTrackTitleEmpty() {
        String title = "";
        assertFalse(PlaylistRecommender.isValidTrackTitle(title));
    }

    @Test
    void testNormalizeVolume() {
        int db = 50;
        assertEquals(50, PlaylistRecommender.normalizeVolume(db));
    }

    @Test
    void testNormalizeVolumeZero() {
        int db = 0;
        assertEquals(0, PlaylistRecommender.normalizeVolume(db));
    }

    @Test
    void testNormalizeVolumeNegative() {
        int db = -305940400;
        assertEquals(0 , PlaylistRecommender.normalizeVolume(db));
    }
}
