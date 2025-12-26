package br.com.rory.electro.logs.logs;

import br.com.rory.electro.logs.a;
import com.rory.electro.NativeLoader;

/**
 * MCURebootLog - Records MCU (Microcontroller Unit) reboot events
 * 
 * This log entry is created when the vehicle's MCU or infotainment system
 * reboots or restarts.
 * 
 * MCU reboots can occur due to:
 * - Software updates
 * - System crashes
 * - Manual restarts
 * - Power cycling
 * - Watchdog timer resets
 * 
 * This data is useful for:
 * - System stability monitoring
 * - Detecting frequent crashes
 * - Correlating reboots with other events
 * - Troubleshooting reliability issues
 */
/* loaded from: classes.dex */
public class MCURebootLog extends a {
    static {
        NativeLoader.classesInit0(93);
    }

    /**
     * Get the type identifier for this log entry
     * Used for serialization and database storage
     */
    @Override // br.com.rory.electro.logs.a
    public native int getType();
}
