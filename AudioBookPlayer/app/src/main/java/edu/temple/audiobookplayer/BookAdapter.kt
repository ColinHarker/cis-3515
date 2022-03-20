package edu.temple.audiobookplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(context_: Context, private val bookList_: BookList, private val onClick_: View.OnClickListener) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(view_: View) : RecyclerView.ViewHolder(view_){
        val view = view_
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_views, parent, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = holder.view.findViewById<TextView>(R.id.bookTitleTextView)
        title.text = bookList_.get(position).title

        val author = holder.view.findViewById<TextView>(R.id.bookAuthorTextView)
        author.text = bookList_.get(position).author

        holder.view.setOnClickListener(onClick_)
    }

    override fun getItemCount(): Int {
        return bookList_.size();
    }
}
