package com.example.minor_tbd

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [UserInfo::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDAO

    companion object{
        @Volatile
        private var dbOb: Database? = null

        fun getDatabaseOb(context: Context): Database{
            if (dbOb==null){
                synchronized(this)
                {
                    dbOb = Room.databaseBuilder(context.applicationContext,Database::class.java,"UserInfo").build()
                }
            }
            return dbOb!!
        }
    }
}