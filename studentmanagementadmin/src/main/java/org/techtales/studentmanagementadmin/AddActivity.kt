package org.techtales.studentmanagementadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.techtales.studentmanagementadmin.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val batch = binding.batchEtxt.text.toString()
            val name = binding.nameEtxt.text.toString()
            val email = binding.emailEtxt.text.toString()
            val phone = binding.phoneEtxt.text.toString()
            val subject = binding.subjectEtxt.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Students")

            val student = Student(batch, name, email, phone, subject)

            database.child(name+phone).setValue(student)
                .addOnSuccessListener {
                    binding.batchEtxt.text?.clear()
                    binding.nameEtxt.text?.clear()
                    binding.emailEtxt.text?.clear()
                    binding.phoneEtxt.text?.clear()
                    binding.subjectEtxt.text?.clear()
                    Toast.makeText(this@AddActivity,"Saved",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@AddActivity, MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this@AddActivity,"Failed",Toast.LENGTH_SHORT).show()
                }
        }
    }
}