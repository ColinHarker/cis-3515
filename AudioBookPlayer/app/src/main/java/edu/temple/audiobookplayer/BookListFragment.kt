package edu.temple.audiobookplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.security.AuthProvider
import java.text.FieldPosition

class BookListFragment : Fragment() {

    lateinit var bookList: BookList;
    lateinit var recyclerView: RecyclerView;
    lateinit var layout: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            bookList = it.getSerializable("BookList") as BookList
        }
    }

    override fun onCreateView(
        inflater_: LayoutInflater, container_: ViewGroup?,
        savedInstanceState_: Bundle?,
    ): View? {
        layout = inflater_.inflate(R.layout.book_list_fragment, container_, false)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = layout.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = BookAdapter(requireContext(), bookList) {
            update(recyclerView.getChildAdapterPosition(it))
        }

    }

    private fun update(position: Int){
        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .setBook(bookList.get(position))
        (requireActivity() as LayoutInterface).selectionMade()
    }

    companion object {
        @JvmStatic
        fun newInstance(bookList_: BookList): BookListFragment {
            val fragment = BookListFragment().apply {
                bookList = bookList_
                arguments = Bundle().apply {
                    putSerializable("BookList", bookList)
                }
            }
            return fragment
        }
    }


    interface LayoutInterface {
        fun selectionMade()
    }
}