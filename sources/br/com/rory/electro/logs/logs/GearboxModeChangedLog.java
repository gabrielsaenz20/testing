package br.com.rory.electro.logs.logs;

import br.com.rory.electro.logs.a;
import com.rory.electro.NativeLoader;

/**
 * GearboxModeChangedLog - Records gearbox/transmission mode changes
 * 
 * This log entry is created when the vehicle's gearbox mode changes.
 * For electric vehicles, this typically refers to:
 * - Drive mode (D)
 * - Reverse mode (R)
 * - Park mode (P)
 * - Neutral mode (N)
 * - Eco/Sport/Normal driving modes
 * 
 * The isDriving flag indicates whether the vehicle is in a driving state
 * (Drive or Reverse) versus a stationary state (Park or Neutral).
 * 
 * This data is useful for:
 * - Analyzing driving patterns
 * - Energy consumption tracking per mode
 * - Safety monitoring (ensuring proper gear usage)
 * - Performance analysis
 */
/* loaded from: classes.dex */
public class GearboxModeChangedLog extends a {
    private boolean isDriving;  // true if in Drive/Reverse, false if in Park/Neutral

    static {
        NativeLoader.classesInit0(457);
    }

    /**
     * Create a new gearbox mode change log entry
     * 
     * @param z true if vehicle entered a driving mode, false if entered a stationary mode
     */
    public GearboxModeChangedLog(boolean z) {
        this.isDriving = z;
    }

    /**
     * Get the type identifier for this log entry
     * Used for serialization and database storage
     */
    @Override // br.com.rory.electro.logs.a
    public native int getType();
}
