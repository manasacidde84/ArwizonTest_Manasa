package com.arwizon.book.main;

import java.util.Scanner;
import java.util.Set;

import com.arwizon.book.model.Book;
import com.arwizon.book.service.AdminInterface;
import com.arwizon.book.service.AdminInterfaceImpl;

import com.arwizon.book.utility.Utilities;


public class BookShopApplication {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		AdminInterface ad = new AdminInterfaceImpl();


		while(true) {
			
			System.out.println("Press 1 to add book" 
					+"\nPress 2 to display books "
					+"\nPress 3 to search book"
					+"\nPress 4 to update book"
					+"\nPress 5 to exit");

			System.out.println("Please choose  your option");
			int ch = scn.nextInt();
			switch(ch) {

			case 1:

				String bookName = null;
				while (true) {
					System.out.println("Enter book name");
					bookName = scn.next();
					try {
						Utilities.validateBookName(bookName);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String bookType = null;
				while (true) {
					System.out.println("Enter book type");
					bookType= scn.next();
					try {
						Utilities.validateChar(bookType);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String author = null;
				while (true) {
					System.out.println("Enter author");
					author = scn.next();
					try {
						Utilities.validateChar(author);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String noOfUnits = null;
				while (true) {
					System.out.println("Enter no of copies");
					noOfUnits= scn.next();
					try {
						Utilities.validateNumeric(noOfUnits);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}


				}
				int noOfUnits1= Integer.parseInt(noOfUnits);

				String cost = null;
				while (true) {
					System.out.println("Enter cost ");
					cost  = scn.next();
					try {
						Utilities.validateNumeric(cost);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}


				}
				double cost1= Double.parseDouble(cost);				
				ad.addBook(bookName, bookType, author, noOfUnits1, cost1);
				System.out.println("book Added Successfully");


				break;
			case 2:


				Set<Book> s = ad.DisplayAllBooks();

				for(Book b:s) {
					System.out.println(b);
				}

				break;

			case 3:

				System.out.println("please enter book name");
				String name1=scn.next();

				Set<Book> book= ad.searchBook(name1);
				if(book.size()==0) {
					System.out.println("book not found");
				}else {
					System.out.println("book Found");
					for(Book b1:book) {
						System.out.println(b1);
					}
				}


				break;

			case 4:
				System.out.println("Enter book Id");
				String bId = scn.next();
				int bId2 = Integer.parseInt(bId);
				System.out.println("Enter your Updated No Of copies");
				String units = scn.next();
				int units1 = Integer.parseInt(units);
				ad.updateBook(bId2, units1);
				System.out.println("Units Updated Successfully");

				break;
				
			case 5:
				System.exit(1);
				break;

			default:System.out.println("invalid option");


			}

		}
	}
}
