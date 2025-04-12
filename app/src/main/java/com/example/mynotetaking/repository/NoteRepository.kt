package com.example.mynotetaking.repository

import com.example.mynotetaking.database.NoteDatabase
import com.example.mynotetaking.model.Note

class NoteRepository(private val db: NoteDatabase) {
    val noteDao = db.getNoteDao()

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    fun getAllNotes() = noteDao.getAllNotes()
    fun searchNote(query: String?) = noteDao.searchNote(query)
}