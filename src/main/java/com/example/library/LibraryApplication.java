package com.example.library;

import com.example.library.book.Book;
import com.example.library.book.BookGenre;
import com.example.library.book.BookRepository;
import com.example.library.bookshelf.Bookshelf;
import com.example.library.bookshelf.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookshelfRepository bookshelfRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Bookshelf UK = new Bookshelf(2,"UK",15);
		Bookshelf Netherlands = new Bookshelf(4,"Netherlands",10);

		bookshelfRepository.save(UK);
		bookshelfRepository.save(Netherlands);
		Book TheLostContinent = new Book("The Lost Continent","Congenital quadriplegia","Darrell","Tebb", BookGenre.NOVEL,446,UK);
		Book MyWayHome=new Book( "Így jöttem" , "Reiter arthritis-up/arm","Margery","D'Antuoni",BookGenre.CRIME,396,Netherlands);
		Book Tarzan = new Book("Tarzan's Secret Treasure", "Lower limb anomaly NOS", "Feliza", "Addekin", BookGenre.DRAMA, 512, UK);
		Book HumanConditionIII= new Book("Human Condition III, The (Ningen no joken III)","Abdmnal pain periumbilic","Barbara","MacCorkell",BookGenre.CHILDREN,141,UK);
		Book Jaws2= new Book("Jaws 2","Inf arthritis NOS-mult","Aguie","Costellow",BookGenre.HORROR,495,Netherlands);
		bookRepository.save(TheLostContinent);
		bookRepository.save(MyWayHome);
		bookRepository.save(Tarzan);
		bookRepository.save(HumanConditionIII);
		bookRepository.save(Jaws2);



	}
}
