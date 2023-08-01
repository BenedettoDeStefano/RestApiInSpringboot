package com.example.Giorno12.Entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

	private int id;
	private Utente utente;
	private Postazione postazione;
	private LocalDate dataPrenotazione;
	private LocalDate scadenzaPrenotazione;

}
