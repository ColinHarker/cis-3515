package edu.temple.audiobookplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel(){

    private var isEmpty = true;

    private val book: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }

    fun getBook(): LiveData<Book> {
        return book
    }

    fun setBook(book_: Book){
        book.value = book_
        isEmpty = false
    }

    fun isEmpty() : Boolean {
        return isEmpty
    }
}