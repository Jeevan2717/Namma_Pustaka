package com.nammapustaka.data.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nammapustaka.data.dao.BookDao
import com.nammapustaka.data.dao.BorrowTransactionDao
import com.nammapustaka.data.dao.ReviewDao
import com.nammapustaka.data.dao.StudentDao
import com.nammapustaka.data.dao.UserDao
import com.nammapustaka.data.entity.BookEntity
import com.nammapustaka.data.entity.BorrowTransactionEntity
import com.nammapustaka.data.entity.ReviewEntity
import com.nammapustaka.data.entity.StudentEntity
import com.nammapustaka.data.entity.UserEntity
import com.nammapustaka.util.HashUtil

@Database(
    entities = [BookEntity::class, StudentEntity::class, BorrowTransactionEntity::class, ReviewEntity::class, UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun studentDao(): StudentDao
    abstract fun borrowTransactionDao(): BorrowTransactionDao
    abstract fun reviewDao(): ReviewDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "namma_pustaka_v2.db")
                .fallbackToDestructiveMigration()
                .addCallback(seedCallback())
                .build()
                .also { INSTANCE = it }
        }

        private fun seedCallback() = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val now = System.currentTimeMillis()
                val hash = HashUtil.sha256("password123")

                db.insert("student", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 1, "name" to "Ravi Kumar", "rollNumber" to "101", "classSection" to "7A", "avatarPath" to "", "totalPagesRead" to 540))
                db.insert("student", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 2, "name" to "Priya Sharma", "rollNumber" to "102", "classSection" to "7A", "avatarPath" to "", "totalPagesRead" to 320))
                db.insert("student", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 3, "name" to "Arjun Nayak", "rollNumber" to "103", "classSection" to "7B", "avatarPath" to "", "totalPagesRead" to 180))

                db.insert("user", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 1, "fullName" to "Teacher One", "username" to "teacher1", "passwordHash" to hash, "role" to "teacher", "linkedStudentId" to null))
                db.insert("user", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 2, "fullName" to "Ravi Kumar", "username" to "ravi101", "passwordHash" to hash, "role" to "student", "linkedStudentId" to 1))
                db.insert("user", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 3, "fullName" to "Priya Sharma", "username" to "priya102", "passwordHash" to hash, "role" to "student", "linkedStudentId" to 2))
                db.insert("user", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 4, "fullName" to "Arjun Nayak", "username" to "arjun103", "passwordHash" to hash, "role" to "student", "linkedStudentId" to 3))

                seedBook(db, 1, "Malgudi Days", "R. K. Narayan", "Story", "Kannada summary for Malgudi Days.", 240, "NMPSTK_SEED_1", false, now - 6_000_000)
                seedBook(db, 2, "Panchatantra", "Vishnu Sharma", "Story", "Kannada summary for Panchatantra.", 160, "NMPSTK_SEED_2", true, now - 5_000_000)
                seedBook(db, 3, "Wings of Fire", "A. P. J. Abdul Kalam", "Science", "Kannada summary for Wings of Fire.", 300, "NMPSTK_SEED_3", false, now - 4_000_000)
                seedBook(db, 4, "The Story of Science", "Joy Hakim", "Science", "Kannada summary for science readers.", 280, "NMPSTK_SEED_4", true, now - 3_000_000)
                seedBook(db, 5, "India After Gandhi", "Ramachandra Guha", "History", "Kannada summary for modern India.", 450, "NMPSTK_SEED_5", true, now - 2_000_000)
                seedBook(db, 6, "Freedom Struggle", "Bipan Chandra", "History", "Kannada summary for freedom struggle.", 360, "NMPSTK_SEED_6", true, now - 1_000_000)

                db.insert("borrow_transaction", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 1, "bookId" to 1, "studentId" to 1, "issuedByTeacherId" to 1, "issueDate" to now - 7L * 86_400_000L, "dueDate" to now + 7L * 86_400_000L, "returnDate" to null, "isReturned" to 0, "isOverdue" to 0))
                db.insert("borrow_transaction", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to 2, "bookId" to 3, "studentId" to 2, "issuedByTeacherId" to 1, "issueDate" to now - 20L * 86_400_000L, "dueDate" to now - 6L * 86_400_000L, "returnDate" to null, "isReturned" to 0, "isOverdue" to 1))
            }
        }

        private fun seedBook(db: SupportSQLiteDatabase, id: Int, title: String, author: String, category: String, summary: String, pages: Int, qr: String, available: Boolean, added: Long) {
            db.insert("book", SQLiteDatabase.CONFLICT_IGNORE, cv("id" to id, "title" to title, "author" to author, "category" to category, "coverImagePath" to "", "summaryKannada" to summary, "totalPages" to pages, "qrCode" to qr, "isAvailable" to if (available) 1 else 0, "addedDate" to added, "addedByTeacherId" to 1))
        }

        private fun cv(vararg pairs: Pair<String, Any?>): ContentValues = ContentValues().apply {
            pairs.forEach { (key, value) ->
                when (value) {
                    null -> putNull(key)
                    is String -> put(key, value)
                    is Int -> put(key, value)
                    is Long -> put(key, value)
                    is Boolean -> put(key, value)
                }
            }
        }
    }
}
