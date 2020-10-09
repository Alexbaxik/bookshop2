package com.company.bookshop.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Table(name = "BOOKSHOP_ARCHIVE")
@Entity(name = "bookshop_Archive")
@NamePattern("%s %s %s %s %s|author,bookname,year,newFile")
public class Archive extends StandardEntity {
    private static final long serialVersionUID = -8746721822908430155L;

    @NotNull
    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @NotNull
    @Column(name = "BOOKNAME", nullable = false, unique = true)
    private String bookname;

    @Column(name = "YEAR_")
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @MetaProperty
    @Transient
    private FileDescriptor newFile;

    public FileDescriptor getNewFile() {
        return newFile;
    }
    public void setNewFile(FileDescriptor newFile) {
        this.newFile = newFile;
    }
}