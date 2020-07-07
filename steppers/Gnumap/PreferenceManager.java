/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package com.steppers.Gnumap;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final boolean DEFAULT_VALUE_BOOLEAN = false;
    private static final float DEFAULT_VALUE_FLOAT = -1.0f;
    private static final int DEFAULT_VALUE_INT = -1;
    private static final long DEFAULT_VALUE_LONG = -1L;
    private static final String DEFAULT_VALUE_STRING = "";
    public static final String PREFERENCES_NAME = "rebuild_preference";

    public static void clear(Context context) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.clear();
        editor.commit();
    }

    public static boolean getBoolean(Context context, String string2) {
        return PreferenceManager.getPreferences(context).getBoolean(string2, false);
    }

    public static float getFloat(Context context, String string2) {
        return PreferenceManager.getPreferences(context).getFloat(string2, -1.0f);
    }

    public static int getInt(Context context, String string2) {
        return PreferenceManager.getPreferences(context).getInt(string2, -1);
    }

    public static long getLong(Context context, String string2) {
        return PreferenceManager.getPreferences(context).getLong(string2, -1L);
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, 0);
    }

    public static String getString(Context context, String string2) {
        return PreferenceManager.getPreferences(context).getString(string2, DEFAULT_VALUE_STRING);
    }

    public static void removeKey(Context context, String string2) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.remove(string2);
        editor.commit();
    }

    public static void setBoolean(Context context, String string2, boolean bl) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.putBoolean(string2, bl);
        editor.commit();
    }

    public static void setFloat(Context context, String string2, float f) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.putFloat(string2, f);
        editor.commit();
    }

    public static void setInt(Context context, String string2, int n) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.putInt(string2, n);
        editor.commit();
    }

    public static void setLong(Context context, String string2, long l) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.putLong(string2, l);
        editor.commit();
    }

    public static void setString(Context context, String string2, String string3) {
        SharedPreferences.Editor editor = PreferenceManager.getPreferences(context).edit();
        editor.putString(string2, string3);
        editor.commit();
    }
}

