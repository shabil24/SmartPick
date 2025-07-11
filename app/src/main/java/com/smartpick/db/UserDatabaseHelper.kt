package com.smartpick.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.smartpick.model.UserModel

class UserDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "smartpick.db", null, 1) {

    companion object {
        private const val TABLE_NAME = "users"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT,
                email TEXT UNIQUE,
                password TEXT
            );
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(user: UserModel): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("username", user.username)
            put("email", user.email)
            put("password", user.password)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    fun getUserByEmail(email: String): UserModel? {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "email = ?",
            arrayOf(email),
            null, null, null
        )
        return if (cursor.moveToFirst()) {
            val user = UserModel(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                username = cursor.getString(cursor.getColumnIndexOrThrow("username")),
                email = cursor.getString(cursor.getColumnIndexOrThrow("email")),
                password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            )
            cursor.close()
            user
        } else {
            cursor.close()
            null
        }
    }

    fun getUserByEmailAndPassword(email: String, password: String): UserModel? {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "email = ? AND password = ?",
            arrayOf(email, password),
            null, null, null
        )

        return if (cursor.moveToFirst()) {
            val user = UserModel(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                username = cursor.getString(cursor.getColumnIndexOrThrow("username")),
                email = cursor.getString(cursor.getColumnIndexOrThrow("email")),
                password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            )
            cursor.close()
            user
        } else {
            cursor.close()
            null
        }
    }

    fun updateUser(user: UserModel): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("username", user.username)
            put("email", user.email)
            put("password", user.password)
        }
        return db.update(TABLE_NAME, values, "id = ?", arrayOf(user.id.toString()))
    }

    fun getUserById(id: Int): UserModel? {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "id = ?",
            arrayOf(id.toString()),
            null, null, null
        )

        return if (cursor.moveToFirst()) {
            val user = UserModel(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                username = cursor.getString(cursor.getColumnIndexOrThrow("username")),
                email = cursor.getString(cursor.getColumnIndexOrThrow("email")),
                password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            )
            cursor.close()
            user
        } else {
            cursor.close()
            null
        }
    }
}
