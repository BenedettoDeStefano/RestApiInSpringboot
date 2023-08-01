package com.example.Giorno12.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.Giorno12.Entities.Utente;

@Service
public class UtenteService {

	private List<Utente> utenti = new ArrayList<>();

	public Utente save(Utente utente) {
		Random rndm = new Random();
		utente.setId(rndm.nextInt());
		this.utenti.add(utente);
		return utente;
	}

	public List<Utente> getUtenti() {
		return this.utenti;
	}

	public Optional<Utente> findById(int id) {
		Utente u = null;

		for (Utente utente : utenti) {
			if (utente.getId() == id)
				u = utente;
		}

		return Optional.ofNullable(u);
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Utente> iterator = this.utenti.listIterator();

		while (iterator.hasNext()) {
			Utente currentUtente = iterator.next();
			if (currentUtente.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Utente> findByIdAndUpdate(int id, Utente utente) {
		Utente found = null;

		for (Utente currentUtente : utenti) {
			if (currentUtente.getId() == id) {
				found = currentUtente;
				found.setNomeCompleto(utente.getNomeCompleto());
				found.setEmail(utente.getEmail());
				found.setUsername(utente.getUsername());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}
