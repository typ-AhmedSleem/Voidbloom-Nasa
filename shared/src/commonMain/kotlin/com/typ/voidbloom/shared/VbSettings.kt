package com.typ.voidbloom.shared

import com.russhwolf.settings.Settings

class VbSettings {
    private val settings = Settings()
    private val secureSettings = VbSecureSettings()

    /**
     * Clears all values stored in this [Settings] instance.
     */
    fun clear() = settings.clear()

    /**
     * Removes the value stored at [key].
     */
    fun remove(key: String) {
        return settings.remove(key)
    }

    /**
     * Returns `true` if there is a value stored at [key], or `false` otherwise.
     */
    fun hasKey(key: String): Boolean {
        return settings.hasKey(key)
    }

    /**
     * Stores the `Int` [value] at [key].
     */
    fun putInt(key: String, value: Int) {
        return settings.putInt(key, value)
    }

    /**
     * Returns the `Int` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getInt(key: String, defaultValue: Int): Int {
        return settings.getInt(key, defaultValue)
    }

    /**
     * Returns the `Int` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getIntOrNull(key: String): Int? {
        return settings.getIntOrNull(key)
    }

    /**
     * Stores the `Long` [value] at [key].
     */
    fun putLong(key: String, value: Long) {
        return settings.putLong(key, value)
    }

    /**
     * Returns the `Long` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getLong(key: String, defaultValue: Long): Long {
        return settings.getLong(key, defaultValue)
    }

    /**
     * Returns the `Long` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getLongOrNull(key: String): Long? {
        return settings.getLongOrNull(key)
    }

    /**
     * Stores the `String` [value] at [key].
     */
    fun putString(key: String, value: String) {
        return settings.putString(key, value)
    }

    /**
     * Returns the `String` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getString(key: String, defaultValue: String): String {
        return settings.getString(key, defaultValue)
    }

    /**
     * Returns the `String` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getStringOrNull(key: String): String? {
        return settings.getStringOrNull(key)
    }

    /**
     * Stores the `Float` [value] at [key].
     */
    fun putFloat(key: String, value: Float) {
        return settings.putFloat(key, value)
    }

    /**
     * Returns the `Float` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getFloat(key: String, defaultValue: Float): Float {
        return settings.getFloat(key, defaultValue)
    }

    /**
     * Returns the `Float` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getFloatOrNull(key: String): Float? {
        return settings.getFloatOrNull(key)
    }

    /**
     * Stores the `Double` [value] at [key].
     */
    fun putDouble(key: String, value: Double) {
        return settings.putDouble(key, value)
    }

    /**
     * Returns the `Double` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getDouble(key: String, defaultValue: Double): Double {
        return settings.getDouble(key, defaultValue)
    }

    /**
     * Returns the `Double` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getDoubleOrNull(key: String): Double? {
        return settings.getDoubleOrNull(key)
    }

    /**
     * Stores the `Boolean` [value] at [key].
     */
    fun putBoolean(key: String, value: Boolean) {
        return settings.putBoolean(key, value)
    }

    /**
     * Returns the `Boolean` value stored at [key], or [defaultValue] if no value was stored. If a value of a different
     * type was stored at `key`, the behavior is not defined.
     */
    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return settings.getBoolean(key, defaultValue)
    }

    /**
     * Returns the `Boolean` value stored at [key], or `null` if no value was stored. If a value of a different type was
     * stored at `key`, the behavior is not defined.
     */
    fun getBooleanOrNull(key: String): Boolean? {
        return settings.getBooleanOrNull(key)
    }

    fun securePutString(key: String, value: String) {
        secureSettings.set(key, value)
    }

    fun secureGetString(key: String, defaultValue: String): String {
        return secureSettings.string(key) ?: defaultValue
    }

}