package com.example.workhive

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Make login button go to Home
        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Close login screen so user can't go back

            // Add this in onCreate method, after the login button code:
            val createAccountText = findViewById<TextView>(R.id.create_account_text)
            createAccountText.setOnClickListener { view ->
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                // Don't finish() here so user can go back to login
            }
        }

    }
}