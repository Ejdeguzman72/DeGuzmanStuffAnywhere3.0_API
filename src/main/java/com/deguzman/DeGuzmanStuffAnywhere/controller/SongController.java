package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.SongDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Song;

@RestController
@RequestMapping("/app/music")
@CrossOrigin
public class SongController {

	@Autowired
	private SongDaoImpl songDaoImpl;
	
	@GetMapping("/all")
	public List<Song> getAllSongInformation() {
		return songDaoImpl.findAllSongInformation();
	}
	
	@GetMapping("/song/{song_id}")
	public ResponseEntity<Song> getSongInformationById(@PathVariable int song_id) throws ResourceNotFoundException {
		return songDaoImpl.findSongById(song_id);
	}
	
	@GetMapping("/song/artist/{artist}")
	public List<Song> getSongInformationByArtist(@PathVariable String artist) {
		return songDaoImpl.findSongByArtist(artist);
	}
	
	@GetMapping("/song/genre/{genre}")
	public List<Song> getSongInformationByGenre(@PathVariable String genre) {
		return songDaoImpl.findSongsByGenre(genre);
	}
	
	@GetMapping("/count-of-songs")
	public int getCountOfSongs() {
		return songDaoImpl.findSongCount();
	}
	
	@PostMapping("/add-song-information")
	public int addSongInformation(@RequestBody Song song) throws DuplicateTitleException {
		return songDaoImpl.addSongInformation(song);
	}
	
	@DeleteMapping("/song/{song_id}")
	public int deleteSongInformationById(@PathVariable int song_id) {
		return songDaoImpl.deleteSongInformation(song_id);
	}
	
	@DeleteMapping("/delete-all-songs")
	public int deleteAllSongs() {
		return songDaoImpl.deleteAllSongs();
	}
}
