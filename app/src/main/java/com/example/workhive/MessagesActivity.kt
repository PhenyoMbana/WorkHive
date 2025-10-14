package com.example.workhive

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MessagesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyState: LinearLayout
    private lateinit var btnBrowseGigs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        setupToolbar()
        setupViews()
        setupRecyclerView()
        checkEmptyState()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.rvConversations)
        emptyState = findViewById(R.id.emptyState)
        btnBrowseGigs = findViewById(R.id.btnBrowseGigs)

        btnBrowseGigs.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        // TODO: Replace with real adapter and data
        recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                return object : RecyclerView.ViewHolder(
                    layoutInflater.inflate(R.layout.item_conversation, parent, false)
                ) {}
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                // Bind data later
                holder.itemView.setOnClickListener {
                    val intent = Intent(this@MessagesActivity, ChatActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun getItemCount(): Int = 0 // Start with empty for now
        }
    }

    private fun checkEmptyState() {
        // Show empty state if no conversations
        val adapter = recyclerView.adapter
        if (adapter?.itemCount == 0) {
            emptyState.visibility = android.view.View.VISIBLE
            recyclerView.visibility = android.view.View.GONE
        } else {
            emptyState.visibility = android.view.View.GONE
            recyclerView.visibility = android.view.View.VISIBLE
        }
    }
}