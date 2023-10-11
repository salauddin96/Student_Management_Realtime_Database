package org.techtales.studentmanagementadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtales.studentmanagementadmin.databinding.ActivityAddBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
            finish()
        }
        binding.updateBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, UpdateActivity::class.java))
            finish()
        }
        binding.deleteBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, DeleteActivity::class.java))
            finish()
        }
    }
}