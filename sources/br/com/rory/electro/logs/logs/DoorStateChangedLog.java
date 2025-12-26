package br.com.rory.electro.logs.logs;

import br.com.rory.electro.logs.a;
import com.rory.electro.NativeLoader;

/**
 * DoorStateChangedLog - Records door state change events
 * 
 * This log entry is created whenever a vehicle door changes state:
 * - Opening or closing
 * - Locking or unlocking
 * 
 * The log captures:
 * - Which door was affected (area identifier)
 * - The new state of the door
 * 
 * This data is useful for:
 * - Security monitoring (detecting unauthorized door openings)
 * - User behavior analysis
 * - Troubleshooting door sensor issues
 * - Tracking vehicle access patterns
 */
/* loaded from: classes.dex */
public class DoorStateChangedLog extends a {
    private int area;   // Door identifier (e.g., DRIVER_FRONT, PASSENGER_REAR, TRUNK, etc.)
    private int state;  // Door state (e.g., OPEN, CLOSED, LOCKED, UNLOCKED)

    static {
        NativeLoader.classesInit0(118);
    }

    /**
     * Create a new door state change log entry
     * 
     * @param i Door area/location identifier
     * @param i2 New state of the door
     */
    public DoorStateChangedLog(int i, int i2) {
        this.state = i2;
        this.area = i;
    }

    /**
     * Get the type identifier for this log entry
     * Used for serialization and database storage
     */
    @Override // br.com.rory.electro.logs.a
    public native int getType();
}
