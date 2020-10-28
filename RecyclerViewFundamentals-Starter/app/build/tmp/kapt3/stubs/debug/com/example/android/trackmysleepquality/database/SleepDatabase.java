package com.example.android.trackmysleepquality.database;

import java.lang.System;

/**
 * A database that stores SleepNight information.
 * And a global method to get access to the database.
 *
 * This pattern is pretty much the same for any database,
 * so you can reuse it.
 */
@androidx.room.Database(entities = {com.example.android.trackmysleepquality.database.SleepNight.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/android/trackmysleepquality/database/SleepDatabase;", "Landroidx/room/RoomDatabase;", "()V", "sleepDatabaseDao", "Lcom/example/android/trackmysleepquality/database/SleepDatabaseDao;", "getSleepDatabaseDao", "()Lcom/example/android/trackmysleepquality/database/SleepDatabaseDao;", "Companion", "app_debug"})
public abstract class SleepDatabase extends androidx.room.RoomDatabase {
    
    /**
     * INSTANCE will keep a reference to any database returned via getInstance.
     *
     * This will help us avoid repeatedly initializing the database, which is expensive.
     *
     * The value of a volatile variable will never be cached, and all writes and
     * reads will be done to and from the main memory. It means that changes made by one
     * thread to shared data are visible to other threads.
     */
    private static volatile com.example.android.trackmysleepquality.database.SleepDatabase INSTANCE;
    public static final com.example.android.trackmysleepquality.database.SleepDatabase.Companion Companion = null;
    
    /**
     * Connects the database to the DAO.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.android.trackmysleepquality.database.SleepDatabaseDao getSleepDatabaseDao();
    
    public SleepDatabase() {
        super();
    }
    
    /**
     * Define a companion object, this allows us to add functions on the SleepDatabase class.
     *
     * For example, clients can call `SleepDatabase.getInstance(context)` to instantiate
     * a new SleepDatabase.
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/android/trackmysleepquality/database/SleepDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/android/trackmysleepquality/database/SleepDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        /**
         * Helper function to get the database.
         *
         * If a database has already been retrieved, the previous database will be returned.
         * Otherwise, create a new database.
         *
         * This function is threadsafe, and callers should cache the result for multiple database
         * calls to avoid overhead.
         *
         * This is an example of a simple Singleton pattern that takes another Singleton as an
         * argument in Kotlin.
         *
         * To learn more about Singleton read the wikipedia article:
         * https://en.wikipedia.org/wiki/Singleton_pattern
         *
         * @param context The application context Singleton, used to get access to the filesystem.
         */
        @org.jetbrains.annotations.NotNull()
        public final com.example.android.trackmysleepquality.database.SleepDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}