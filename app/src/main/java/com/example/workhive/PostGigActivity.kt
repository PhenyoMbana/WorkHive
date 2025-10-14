package com.example.workhive

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class PostGigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_gig)

        setupToolbar()
        setupPostButton()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish() // Go back to previous screen
        }
    }

    private fun setupPostButton() {
        val btnPostGig = findViewById<Button>(R.id.btnPostGig)
        btnPostGig.setOnClickListener {
            // TODO: Implement gig posting logic
            // For now, just go back to home
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}