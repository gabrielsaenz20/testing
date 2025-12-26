package br.com.rory.electro.common;

/**
 * YuvUtils - YUV video format conversion utilities for camera processing
 * 
 * This class provides native methods for processing camera video frames in YUV format.
 * YUV is a color encoding system commonly used in video, where:
 * - Y = Luminance (brightness)
 * - U and V = Chrominance (color information)
 * 
 * BYD vehicles use multiple cameras (front, rear, side, interior) that output video
 * in various YUV formats. This utility converts and processes these formats for display
 * and analysis.
 * 
 * Common formats:
 * - NV12/NV21: Semi-planar YUV formats used by Android cameras
 * - I420 (YUV420p): Planar format used by video encoders (WebRTC, H.264)
 * 
 * Native implementation in libnative-lib.so uses OpenCV and other optimized libraries
 * for high-performance video processing.
 */
/* loaded from: classes.dex */
public class YuvUtils {
    static {
        // Load native library containing optimized video processing functions
        System.loadLibrary("native-lib");
    }

    /**
     * Apply CLAHE (Contrast Limited Adaptive Histogram Equalization) to enhance image quality
     * 
     * CLAHE improves visibility in poorly lit conditions (night driving, tunnels, etc.)
     * by enhancing local contrast without over-amplifying noise.
     * 
     * @param bArr Input YUV image data
     * @param i Width of the image
     * @param i2 Height of the image
     * @param f Clip limit for contrast enhancement
     * @param i3 Tile grid size for adaptive processing
     */
    public static native void applyCLAHE(byte[] bArr, int i, int i2, float f, int i3);

    /**
     * Combine multiple camera feeds into a 2x2 grid layout
     * 
     * Takes feeds from 4 cameras (e.g., front, rear, left, right) and arranges them
     * in a quad-view display. Converts from NV21 (camera output) to I420 (display format).
     * 
     * Used for:
     * - 360-degree surround view
     * - Parking assistance
     * - Multi-angle monitoring
     * 
     * @param bArr Output buffer for combined image (I420 format)
     * @param i Output width
     * @param i2 Output height
     * @param bArr2 Input camera data arrays (NV21 format)
     * @param i3 Input width for each camera
     * @param i4 Input height for each camera
     * @return Status code (0 = success)
     */
    public static native int combineCamerasTo2x2GridNV21ToI420(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    /**
     * Convert NV12 format to I420 format
     * 
     * NV12 is a semi-planar format (Y plane, interleaved UV plane)
     * I420 is a planar format (Y plane, U plane, V plane)
     * 
     * @param bArr Input NV12 data
     * @param bArr2 Output I420 data
     * @param i Width
     * @param i2 Height
     */
    public static native void convertNV12ToI420(byte[] bArr, byte[] bArr2, int i, int i2);

    /**
     * Convert NV21 format to I420 format
     * 
     * NV21 is similar to NV12 but with V and U swapped in the chroma plane
     * This is the default format from Android Camera API
     * 
     * @param bArr Input NV21 data
     * @param bArr2 Output I420 data
     * @param i Width
     * @param i2 Height
     */
    public static native void convertNV21ToI420(byte[] bArr, byte[] bArr2, int i, int i2);

    /**
     * Crop a region from NV21 image and convert to I420
     * 
     * Used to extract specific regions of interest from camera feeds,
     * such as focusing on license plates, obstacles, or specific areas.
     * 
     * @param bArr Input NV21 data
     * @param i Input width
     * @param i2 Input height
     * @param i3 Crop X offset
     * @param i4 Crop Y offset
     * @param i5 Crop width
     * @param i6 Crop height
     * @param bArr2 Output I420 data
     * @return Status code (0 = success)
     */
    public static native int cropNV21ToI420(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2);

    /**
     * Normalize the Y (luminance) channel
     * 
     * Adjusts brightness levels to a standard range, improving consistency
     * across different lighting conditions and cameras.
     * 
     * @param bArr YUV image data
     * @param i Width
     * @param i2 Height
     */
    public static native void normalizeYChannel(byte[] bArr, int i, int i2);

    /**
     * Rearrange I420 image halves side by side
     * 
     * Splits an image vertically and places the halves horizontally,
     * useful for certain display layouts or stereo camera processing.
     * 
     * @param bArr Input I420 data
     * @param bArr2 Output I420 data
     * @param i Width
     * @param i2 Height
     * @return Status code (0 = success)
     */
    public static native int rearrangeI420HalvesSideBySide(byte[] bArr, byte[] bArr2, int i, int i2);
}
