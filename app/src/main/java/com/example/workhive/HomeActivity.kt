package com.example.workhive

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val gigList = mutableListOf<Gig>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupClickListeners()
        setupSampleData()
        setupRecyclerView()
    }

    private fun setupClickListeners() {
        // Post Gig FAB
        val fabPostGig = findViewById<FloatingActionButton>(R.id.fabPostGig)
        fabPostGig.setOnClickListener {
            val intent = Intent(this, PostGigActivity::class.java)
            startActivity(intent)
        }

        // Notifications
        val btnNotifications = findViewById<ImageButton>(R.id.btnNotifications)
        btnNotifications.setOnClickListener {
            // TODO: Open notifications
        }

        // Filter
        val btnFilter = findViewById<ImageButton>(R.id.btnFilter)
        btnFilter.setOnClickListener {
            // TODO: Open filter dialog
        }
    }

    private fun setupSampleData() {
        gigList.clear()
        gigList.addAll(
            listOf(
                Gig(
                    id = "1",
                    title = "Math Tutor for Grade 10 Student",
                    description = "Looking for an experienced math tutor to help with algebra and geometry. Sessions will be 2 hours per week.",
                    category = "Tutoring",
                    budget = "R250/hr",
                    location = "Johannesburg",
                    postedBy = "Sarah Johnson",
                    postedTime = "2 hours ago",
                    duration = "2 hours per week"
                ),
                Gig(
                    id = "2",
                    title = "Garden Maintenance Service",
                    description = "Need someone to maintain my garden weekly. Includes weeding, pruning, and basic lawn care.",
                    category = "Gardening",
                    budget = "R400/day",
                    location = "Pretoria",
                    postedBy = "Mike Peterson",
                    postedTime = "5 hours ago",
                    duration = "Weekly"
                ),
                Gig(
                    id = "3",
                    title = "Website Design for Small Business",
                    description = "Looking for a web designer to create a professional website for my local bakery. Must have portfolio.",
                    category = "Design",
                    budget = "R2000",
                    location = "Cape Town",
                    postedBy = "Lisa Chen",
                    postedTime = "1 day ago",
                    duration = "2 weeks"
                ),
                Gig(
                    id = "4",
                    title = "Food Delivery Driver Needed",
                    description = "Urgent need for reliable delivery driver for local restaurant. Must have own vehicle and valid license.",
                    category = "Delivery",
                    budget = "R180/day + tips",
                    location = "Durban",
                    postedBy = "Tony's Pizza",
                    postedTime = "3 hours ago",
                    duration = "Flexible hours"
                ),
                Gig(
                    id = "5",
                    title = "House Cleaning Service",
                    description = "One-time deep cleaning for 3-bedroom house. Must bring own equipment and supplies.",
                    category = "Cleaning",
                    budget = "R600",
                    location = "Sandton",
                    postedBy = "David Wilson",
                    postedTime = "6 hours ago",
                    duration = "One-time"
                )
            )
        )
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.rvGigs)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = GigAdapter(
            gigs = gigList,
            onItemClick = { gig ->
                // Open gig details
                val intent = Intent(this, GigDetailsActivity::class.java).apply {
                    putExtra("GIG_TITLE", gig.title)
                    putExtra("GIG_DESCRIPTION", gig.description)
                    putExtra("GIG_CATEGORY", gig.category)
                    putExtra("GIG_BUDGET", gig.budget)
                    putExtra("GIG_LOCATION", gig.location)
                    putExtra("GIG_POSTED_BY", gig.postedBy)
                    putExtra("GIG_POSTED_TIME", gig.postedTime)
                    putExtra("GIG_DURATION", gig.duration)
                }
                startActivity(intent)
            },
            onApplyClick = { gig ->
                // Handle apply logic
                android.widget.Toast.makeText(
                    this,
                    "Applied to: ${gig.title}",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            },
            onBookmarkClick = { gig ->
                // Handle bookmark logic
                android.widget.Toast.makeText(
                    this,
                    "Bookmarked: ${gig.title}",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        )

        recyclerView.adapter = adapter
    }
}