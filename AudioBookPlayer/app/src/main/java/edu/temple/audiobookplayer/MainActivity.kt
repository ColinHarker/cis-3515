package edu.temple.audiobookplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var bookViewModel: BookViewModel;
    var twoFragment = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var books = BookList()

        books.add(Book("A Tale of Two Cities","Charles Dickens"))
        books.add(Book("the Hobbit","J. R. R. Tolkien"))
        books.add(Book("Harry Potter and the Philosopher's Stone","J. K. Rowling"))
        books.add(Book("The Little Prince","Antoine de Saint-Exupéry"))
        books.add(Book("Dream of the Red Chamber","Cao Xueqin"))
        books.add(Book("And Then There Were None","Agatha Christie"))
        books.add(Book("The Lion, The Witch and the Wardrobe","C. S. Lewis"))
        books.add(Book("She: A History of Adventure","H. Rider Haggard"))
        books.add(Book("The Adventures of Pinocchio","Carlo Collodi"))
        books.add(Book("The Da Vinci Code","Dan Brown"))

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        val bookListFragment = BookListFragment.newInstance(books)

        if(twoFragment){
            supportFragmentManager.popBackStack()

        } else{
            if (ViewModelProvider(this).get(BookViewModel::class.java).getBook().value?.title != ""
                && !bookViewModel.isEmpty()) {
                if (!twoFragment) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView1, BookDetailsFragment())
                        .addToBackStack(null)
                        .commit()
                }
                else{
                    if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView2, BookDetailsFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView1, bookListFragment)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        ViewModelProvider(this).get(BookViewModel::class.java).setBook(Book("", ""))
    }
}