package com.example.workhive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip

class GigAdapter(
    private val gigs: List<Gig>,
    private val onItemClick: (Gig) -> Unit,
    private val onApplyClick: (Gig) -> Unit,
    private val onBookmarkClick: (Gig) -> Unit
) : RecyclerView.Adapter<GigAdapter.GigViewHolder>() {

    class GigViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvPostedTime: TextView = itemView.findViewById(R.id.tvPostedTime)
        val tvGigTitle: TextView = itemView.findViewById(R.id.tvGigTitle)
        val tvGigDescription: TextView = itemView.findViewById(R.id.tvGigDescription)
        val chipCategory: Chip = itemView.findViewById(R.id.chipCategory)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvBudget: TextView = itemView.findViewById(R.id.tvBudget)
        val btnApply: com.google.android.material.button.MaterialButton = itemView.findViewById(R.id.btnApply)
        val btnBookmark: ImageButton = itemView.findViewById(R.id.btnBookmark)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GigViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gig, parent, false)
        return GigViewHolder(view)
    }

    override fun onBindViewHolder(holder: GigViewHolder, position: Int) {
        val gig = gigs[position]

        holder.tvUserName.text = gig.postedBy
        holder.tvPostedTime.text = gig.postedTime
        holder.tvGigTitle.text = gig.title
        holder.tvGigDescription.text = gig.description
        holder.chipCategory.text = gig.category
        holder.tvLocation.text = gig.location
        holder.tvBudget.text = gig.budget

        // Item click
        holder.itemView.setOnClickListener {
            onItemClick(gig)
        }

        // Apply button click
        holder.btnApply.setOnClickListener {
            onApplyClick(gig)
        }

        // Bookmark button click
        holder.btnBookmark.setOnClickListener {
            onBookmarkClick(gig)
            // Toggle bookmark icon (basic implementation)
            holder.btnBookmark.setImageResource(R.drawable.ic_bookmark_filled)
        }
    }

    override fun getItemCount(): Int = gigs.size
}