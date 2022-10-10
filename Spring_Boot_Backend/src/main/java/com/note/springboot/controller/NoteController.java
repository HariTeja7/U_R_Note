package com.note.springboot.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note.springboot.dao.NoteRepository;
import com.note.springboot.entity.Note;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	public NoteController(NoteRepository noteRepository) {
		this.noteRepository=noteRepository;
	}
	
	@PutMapping
	Note createOrUpdateNote(@RequestBody Note note){
		System.out.println("put mapping"+note.getTitle());
		return noteRepository.save(note);
	}
	
	@GetMapping
	List<Note> getNotes(){
		List<Note> list=noteRepository.findAll();
		Collections.reverse(list);
		return list;
	}
	
	@GetMapping("/{title}")
	Note getNotes(@PathVariable String title){
		try
		{
			return noteRepository.findById(title).get();
		}
		catch(Exception e)
		{
			return new Note();
		}
	}
	
	@DeleteMapping("/{title}")
	void delete(@PathVariable String title) {
		noteRepository.deleteById(title);
	}
	
	@DeleteMapping
	void delete() {
		noteRepository.deleteAll();
	}
	
	
}
