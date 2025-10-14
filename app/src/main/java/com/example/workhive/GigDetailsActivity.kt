package com.example.workhive

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class GigDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gig_details)

        setupToolbar()
        setupGigData()
        setupClickListeners()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Share button
        val btnShare = findViewById<ImageButton>(R.id.btnShare)
        btnShare.setOnClickListener {
            // TODO: Implement share functionality
        }
    }

    private fun setupGigData() {
        // Get data from intent
        val title = intent.getStringExtra("GIG_TITLE") ?: "Gig Title"
        val description = intent.getStringExtra("GIG_DESCRIPTION") ?: "Description"
        val category = intent.getStringExtra("GIG_CATEGORY") ?: "Category"
        val budget = intent.getStringExtra("GIG_BUDGET") ?: "Budget"
        val location = intent.getStringExtra("GIG_LOCATION") ?: "Location"
        val postedBy = intent.getStringExtra("GIG_POSTED_BY") ?: "User"
        val postedTime = intent.getStringExtra("GIG_POSTED_TIME") ?: "Recently"
        val duration = intent.getStringExtra("GIG_DURATION") ?: "Flexible"

        // Update UI with real data
        findViewById<TextView>(R.id.tvGigTitle).text = title
        findViewById<TextView>(R.id.tvDescription).text = description
        findViewById<TextView>(R.id.tvBudget).text = budget
        findViewById<TextView>(R.id.tvLocation).text = location
        findViewById<TextView>(R.id.tvUserName).text = postedBy
        findViewById<TextView>(R.id.tvPostedInfo).text = "Posted $postedTime by $postedBy"
        findViewById<TextView>(R.id.tvDuration).text = duration

        // Update category chip
        val categoryChip = findViewById<com.google.android.material.chip.Chip>(R.id.chipCategory)
        categoryChip.text = category
    }

    private fun setupClickListeners() {
        // Apply button
        val btnApply = findViewById<Button>(R.id.btnApply)
        btnApply.setOnClickListener {
            showApplicationSuccess()
        }

        // Message button
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        btnMessage.setOnClickListener {
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }

        // Bookmark button
        val btnBookmark = findViewById<Button>(R.id.btnBookmark)
        btnBookmark.setOnClickListener {
            // TODO: Implement bookmark functionality
            btnBookmark.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_bookmark_filled, 0, 0, 0
            )
        }
    }

    private fun showApplicationSuccess() {
        android.widget.Toast.makeText(
            this,
            "Application submitted successfully!",
            android.widget.Toast.LENGTH_SHORT
        ).show()

        // Go back to home after applying
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}