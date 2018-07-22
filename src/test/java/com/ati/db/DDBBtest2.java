package com.ati.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ati.model.Amigo;

public class DDBBtest2 {

	@Test
	public void testAddAmigo() {
		Amigo miAmigo = Database.getInstance().addAmigos("Rinaldo");
		Database.getInstance().getAmigo(2);
		assertEquals("Rinaldo", miAmigo.getNombre());
	}
}
