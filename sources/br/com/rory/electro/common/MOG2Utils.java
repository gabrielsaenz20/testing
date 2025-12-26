package br.com.rory.electro.common;

import com.rory.electro.NativeLoader;

/**
 * MOG2Utils - Motion detection and background subtraction utilities
 * 
 * This class provides advanced computer vision capabilities using the MOG2
 * (Mixture of Gaussians 2) algorithm for detecting motion in camera feeds.
 * 
 * MOG2 is a background/foreground segmentation algorithm that:
 * - Learns what the "background" looks like over time
 * - Detects moving objects (foreground) by comparing to the learned background
 * - Adapts to gradual changes (lighting, parked cars, etc.)
 * - Ignores shadows and minor variations
 * 
 * Use cases in vehicle:
 * - Parking sensors: Detect approaching objects
 * - Security: Detect people near the vehicle
 * - Blind spot monitoring: Detect moving vehicles
 * - Interior monitoring: Detect passenger movement
 * - Driver attention: Detect if driver looks away
 * 
 * The native implementation uses OpenCV's BackgroundSubtractorMOG2 class.
 */
/* loaded from: classes.dex */
public class MOG2Utils {

    /**
     * Instance wrapper class for MOG2 algorithm
     * Each instance maintains its own background model and can process
     * frames from a specific camera independently.
     */
    public static class a {
        private long a;           // Native pointer to MOG2 instance
        private int b = 0;        // Frame width
        private int c = 0;        // Frame height
        private boolean d = false; // Initialization status

        static {
            NativeLoader.classesInit0(415);
        }

        /**
         * Constructor - Creates a new MOG2 instance
         * Initializes the background subtraction algorithm
         */
        public a() {
            this.a = -1L;
            this.a = MOG2Utils.createMOG2Instance();
        }

        /**
         * Get foreground percentage in the frame
         * Returns how much of the frame contains moving objects
         * 
         * @param bArr YUV image data
         * @return Percentage (0.0 to 100.0) of frame that is foreground/motion
         */
        public native float a(byte[] bArr);

        /**
         * Release resources
         * Call when done with this MOG2 instance
         */
        public native void a();

        /**
         * Set background ratio threshold
         * Controls how quickly the model adapts to changes
         * 
         * @param f Ratio value (typically 0.5 to 0.9)
         */
        public native void a(float f);

        /**
         * Initialize MOG2 with frame dimensions
         * Must be called before processing frames
         * 
         * @param i Frame width
         * @param i2 Frame height
         * @return true if initialization successful
         */
        public native boolean a(int i, int i2);

        /**
         * Apply MOG2 algorithm to frame
         * Processes the frame and generates foreground mask
         * 
         * @param bArr Input YUV image data
         * @param bArr2 Output foreground mask
         * @return true if processing successful
         */
        public native boolean a(byte[] bArr, byte[] bArr2);

        /**
         * Get vertical center of motion
         * Returns Y coordinate of the center of detected motion
         * Useful for tracking where movement is occurring
         * 
         * @param bArr YUV image data
         * @return Y coordinate of motion center (pixels)
         */
        public native int b(byte[] bArr);

        /**
         * Set learning rate
         * Controls how fast the background model updates
         * Higher rate = adapts faster to changes but may miss slow-moving objects
         * Lower rate = more stable but slower to adapt
         * 
         * @param f Learning rate (typically 0.001 to 0.01)
         */
        public native void b(float f);

        /**
         * Set variance threshold
         * Controls sensitivity to differences from background
         * Higher threshold = less sensitive (fewer false positives)
         * Lower threshold = more sensitive (may detect noise)
         * 
         * @param f Variance threshold value
         */
        public native void c(float f);

        /**
         * Finalizer - cleanup native resources
         * Called by garbage collector when object is destroyed
         */
        protected native void finalize();
    }

    static {
        // Load native library with OpenCV-based implementation
        System.loadLibrary("native-lib");
    }

    /**
     * Apply MOG2 algorithm to a frame (static method)
     * 
     * @param j Native MOG2 instance pointer
     * @param bArr Input YUV image
     * @param bArr2 Output foreground mask
     * @return true if processing successful
     */
    public static native boolean applyMOG2(long j, byte[] bArr, byte[] bArr2);

    /**
     * Apply shadow removal filter
     * Removes detected shadows from the image to reduce false motion detections
     * 
     * Shadows can cause false positives in motion detection. This filter
     * identifies and removes them based on brightness and color analysis.
     * 
     * @param bArr YUV image data
     * @param i Width
     * @param i2 Height
     * @param i3 Algorithm parameter
     * @param f Shadow threshold
     * @param f2 Shadow strength
     * @param f3 Shadow removal intensity
     */
    public static native void applyShadowFilter(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    /**
     * Create a new MOG2 instance
     * 
     * @return Native pointer to MOG2 instance
     */
    public static native long createMOG2Instance();

    /**
     * Destroy MOG2 instance and free resources
     * 
     * @param j Native MOG2 instance pointer to destroy
     */
    public static native void destroyMOG2Instance(long j);

    /**
     * Get percentage of frame that is foreground/motion
     * 
     * @param j Native MOG2 instance pointer
     * @param bArr YUV image data
     * @return Percentage (0.0 to 100.0) of foreground pixels
     */
    public static native float getForegroundPercentage(long j, byte[] bArr);

    /**
     * Get vertical center of detected motion
     * 
     * @param j Native MOG2 instance pointer
     * @param bArr YUV image data
     * @return Y coordinate of motion center
     */
    public static native int getMotionVerticalCenter(long j, byte[] bArr);

    /**
     * Initialize MOG2 instance with frame dimensions
     * 
     * @param j Native MOG2 instance pointer
     * @param i Frame width
     * @param i2 Frame height
     * @return true if initialization successful
     */
    public static native boolean initializeMOG2(long j, int i, int i2);

    /**
     * Set background ratio for MOG2 algorithm
     * 
     * @param j Native MOG2 instance pointer
     * @param f Background ratio value
     */
    public static native void setBackgroundRatio(long j, float f);

    /**
     * Set learning rate for background model
     * 
     * @param j Native MOG2 instance pointer
     * @param f Learning rate
     */
    public static native void setLearningRate(long j, float f);

    /**
     * Set variance threshold for motion detection sensitivity
     * 
     * @param j Native MOG2 instance pointer
     * @param f Variance threshold
     */
    public static native void setVarThreshold(long j, float f);
}
