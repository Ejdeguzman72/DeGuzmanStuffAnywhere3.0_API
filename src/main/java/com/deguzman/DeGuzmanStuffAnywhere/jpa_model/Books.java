package com.deguzman.DeGuzmanStuffAnywhere.jpa_model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class Books {
	
	public int book_id;
	public String name;
	public String author;
	public String descr;

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + book_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (book_id != other.book_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", name=" + name + ", author=" + author + "]";
	}
	
	public Books(int book_id, String name, String author, String descr) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.descr = descr;
	}
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
