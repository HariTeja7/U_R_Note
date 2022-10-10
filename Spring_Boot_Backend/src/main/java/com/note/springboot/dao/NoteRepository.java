package com.note.springboot.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.note.springboot.entity.Note;

@CrossOrigin("http://localhost:4200")
public interface NoteRepository extends Neo4jRepository<Note,String>{

}
