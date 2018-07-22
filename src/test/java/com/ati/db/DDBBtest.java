package com.ati.db;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.ati.model.Amigo;

public class DDBBtest {
	@Test
	public void testUpdateAmigovalid() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, "Marta", 4);
		assertTrue(isOk);
	}

	@Test
	public void testUpdateAmigo24Marta4() {
		boolean isOk = Database.getInstance().actualizarAmigo(24, "Marta", 4);
		assertFalse(isOk);
	}

	@Test
	public void testUpdateAmigo2NombreVacio() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, "", 4);
		assertFalse(isOk);
	}

	@Test
	public void testUpdateAmigo24NullVacio() {
		boolean isOk = Database.getInstance().actualizarAmigo(24, null, 4);
		assertFalse(isOk);
	}
	@Test
	public void testUpdateAmigo24NombrePuntuacionInvalida() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, null, 6);
		assertFalse(isOk);
	}@Test
	public void testUpdateAmigo24NombrePuntuacionInvalida2() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, null, 4);
		assertFalse(isOk);
	}
	public void testUpdateAmigo24Numero4() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, "17", 4);
		assertFalse(isOk);
	}@Test
	public void testUpdateAmigo24NombreInexistenteVacio() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, null, 4);
		assertFalse(isOk);
	}
	@Test
	public void isSaved() {
		boolean isOk = Database.getInstance().actualizarAmigo(2, "Rinaldo", 4);
		Amigo miAmigo=Database.getInstance().getAmigo(2);
		assertEquals("Rinaldo", miAmigo.getNombre());
		
	}

	
	
	
	
	
	
	
	
	
}
