package com.example.btt2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmployee = findViewById<EditText>(R.id.etEmployee)
        val btnChange = findViewById<Button>(R.id.btnChange)
        val checkBoxBook1 = findViewById<CheckBox>(R.id.checkBoxBook1)
        val checkBoxBook2 = findViewById<CheckBox>(R.id.checkBoxBook2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Sự kiện đổi nhân viên
        btnChange.setOnClickListener {
            val newName = etEmployee.text.toString().trim()
            if (newName.isEmpty()) {
                Toast.makeText(this, "⚠ Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "✅ Nhân viên đã đổi thành: $newName", Toast.LENGTH_SHORT).show()
            }
        }

        // Sự kiện mượn sách
        btnAdd.setOnClickListener {
            val borrowedBooks = mutableListOf<String>()

            if (checkBoxBook1.isChecked) borrowedBooks.add("Sách 01")
            if (checkBoxBook2.isChecked) borrowedBooks.add("Sách 02")

            if (borrowedBooks.isEmpty()) {
                Toast.makeText(this, "Vui lòng chọn ít nhất một cuốn sách!", Toast.LENGTH_SHORT).show()
            } else {
                val books = borrowedBooks.joinToString(", ")
                Toast.makeText(this, "Bạn đã mượn: $books", Toast.LENGTH_LONG).show()
            }
        }
    }
}