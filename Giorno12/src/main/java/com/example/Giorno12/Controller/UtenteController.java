package com.example.Giorno12.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Giorno12.Entities.Utente;
import com.example.Giorno12.Service.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService uts;

	@PostMapping("/crea")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody Utente body) {
		Utente createdUser = uts.save(body);
		return createdUser;
	}

	@GetMapping("/lista")
	public List<Utente> getUsers() {
		return uts.getUtenti();
	}

	@GetMapping("/{userId}")
	public Utente findById(@PathVariable int userId) throws Exception {
		return uts.findById(userId).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	@PutMapping("/{userId}")
	public Utente findAndUpdate(@PathVariable int userId, @RequestBody Utente body) throws Exception {
		return uts.findByIdAndUpdate(userId, body).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable int userId) {
		uts.findByIdAndDelete(userId);
	}

}
