package com.example.assignment_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener {
            val emailAuth: String = email.text.toString()
            val passwordAuth: String = password.text.toString()

            if(emailAuth.isNotEmpty() && passwordAuth.isNotEmpty()) {
                mAuth.createUserWithEmailAndPassword(emailAuth,passwordAuth)
                    .addOnCompleteListener{
                        task ->
                        if(task.isSuccessful) {
                            Toast.makeText(this, "User created successfully", Toast.LENGTH_LONG).show()
                            email.setText("")
                            password.setText("")
                        }
                        else {
                            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                            email.setText("")
                            password.setText("")
                        }
                    }
            }
        }
    }
}
