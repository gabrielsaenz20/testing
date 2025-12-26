package br.com.rory.electro.logs.logs;

import br.com.rory.electro.logs.a;
import com.rory.electro.NativeLoader;

/**
 * ElectroInitLog - Records application initialization events
 * 
 * This log entry is created when the Electro app successfully initializes
 * and establishes connection with the vehicle systems.
 * 
 * This marks the point when:
 * - Native libraries are loaded
 * - CAN bus connection is established
 * - Vehicle sensors are detected and initialized
 * - Camera systems are ready
 * - All subsystems are operational
 * 
 * This data is useful for:
 * - Troubleshooting startup issues
 * - Measuring initialization performance
 * - Detecting system compatibility problems
 * - Tracking app stability
 */
/* loaded from: classes.dex */
public class ElectroInitLog extends a {
    static {
        NativeLoader.classesInit0(212);
    }

    /**
     * Get the type identifier for this log entry
     * Used for serialization and database storage
     */
    @Override // br.com.rory.electro.logs.a
    public native int getType();
}
