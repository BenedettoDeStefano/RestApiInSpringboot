package com.example.Giorno12.Entities;

import com.example.Giorno12.Enum.TipoPostazione;

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
public class Postazione {

	private int id;
	private String descrizione;
	private int numeroMassimoOccupanti;
	private TipoPostazione tipo;
	private String citta;

}
