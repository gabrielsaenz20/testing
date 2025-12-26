package br.com.rory.electro.logs.logs;

import br.com.rory.electro.logs.a;
import com.rory.electro.NativeLoader;

/**
 * SeatComfortRunLog - Records seat comfort adjustment operations
 * 
 * This log entry is created when the vehicle's seat comfort features are activated.
 * BYD electric vehicles often include:
 * - Heated seats
 * - Ventilated/cooled seats
 * - Massage functions
 * - Lumbar support adjustments
 * 
 * The comfort stages typically represent intensity levels (0 = off, 1-3 = low/medium/high).
 * 
 * Separate stages are tracked for:
 * - Driver seat
 * - Front passenger seat
 * 
 * This data is useful for:
 * - Tracking user comfort preferences
 * - Energy consumption analysis (heating/cooling uses battery power)
 * - Seat memory profile learning
 * - Feature usage statistics
 */
/* loaded from: classes.dex */
public class SeatComfortRunLog extends a {
    private int driverComfortStage;     // Driver seat comfort level (0=off, 1-3=intensity)
    private int passengerComfortStage;  // Passenger seat comfort level (0=off, 1-3=intensity)

    static {
        NativeLoader.classesInit0(430);
    }

    /**
     * Create a new seat comfort log entry
     * 
     * @param i Driver seat comfort stage/intensity
     * @param i2 Passenger seat comfort stage/intensity
     */
    public SeatComfortRunLog(int i, int i2) {
        this.driverComfortStage = i;
        this.passengerComfortStage = i2;
    }

    /**
     * Get the type identifier for this log entry
     * Used for serialization and database storage
     */
    @Override // br.com.rory.electro.logs.a
    public native int getType();
}
