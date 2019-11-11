package com.example.mvvm.data.db


//@Database(
//    entities = [User::class],
//    version = 1,
//    exportSchema = false
//)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun getUserDao() : UserDao
//
//    companion object{
//
//        @Volatile
//        private var instance: AppDatabase? = null
//        private var LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
//            instance?:buildDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                AppDatabase::class.java,
//                "my_db"
//            ).build()
//    }
//}