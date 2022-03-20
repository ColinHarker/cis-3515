package edu.temple.audiobookplayer

import java.io.Serializable

class BookList : Serializable {

    private val bookList = ArrayList<Book>()

    fun add(b: Book) {
        bookList.add(b)
    }

    fun remove(b: Book) {
        bookList.remove(b)
    }

    fun get(index: Int): Book {
        return bookList[index]
    }

    fun size(): Int {
        return bookList.size
    }
}