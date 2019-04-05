package com.xyz.shrreya.plainoldnotes.model;

import java.util.Date;

/**
 * Created by shrreya on 5/4/19.
 */
public class NoteEntity {

    private int id;
    private String text;
    private Date date;

    /* to assign value differently*/
    public NoteEntity() {
    }

    /* to alter data of the existing note*/
    public NoteEntity(int id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    /* when creating a new note and what the integers to be assigned automatically */
    public NoteEntity(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
