package team100.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents all the Raspberry Pi 4 cameras we have.
 */
public enum Camera {
    // these are in serial-number order
    // keep these synchronized with python tag_finder.py.
    FRONT("1000000013c9c96c"),
    // REAR("100000004e0a1fb9"),
    LEFT("10000000a7c673d9"),
    RIGHT("100000004e0a1fb9"),
    UNKNOWN(null);

    private static Map<String, Camera> cameras = new HashMap<String, Camera>();
    static {
        for (Camera i : Camera.values()) {
            cameras.put(i.m_serialNumber, i);
        }
    }
    private String m_serialNumber;

    private Camera(String serialNumber) {
        m_serialNumber = serialNumber;
    }

    public static Camera get(String serialNumber) {
        if (cameras.containsKey(serialNumber))
            return cameras.get(serialNumber);
        return UNKNOWN;
    }
}
