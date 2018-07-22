package com.ati.db;

import java.util.ArrayList;
import java.util.List;

import com.ati.model.Amigo;




public class Database {
	private static Database Instancia=null;
	private static List<Amigo> listaAmigos = new ArrayList<Amigo>();
	
	public static final Database getInstance() {
		if(Instancia == null) Instancia=new Database();
		return Instancia;
	}
	
	private Database() {
		loadAmigos();
	}


	private static final boolean loadAmigos() {
		listaAmigos.add(new Amigo(1,"Anacleto"));
		listaAmigos.add(new Amigo(2,"Federico"));
		listaAmigos.add(new Amigo(3,"Alberto"));
		listaAmigos.add(new Amigo(4,"Pancrasio"));
		listaAmigos.add(new Amigo(5,"Anacleto"));
		listaAmigos.add(new Amigo(6,"Ana"));
		return true;
	}
	
	public Amigo getAmigo(int unAmigo) {
		Amigo miAmigo = null;
		for (Amigo mamigo : listaAmigos) {
			if (unAmigo == mamigo.getId()) {
				miAmigo = mamigo;
			}
		}
		return miAmigo;
	}
	
	public final boolean deleteAmigo(int idUsuario) {
		boolean eliminaAmigo=false;
		for (Amigo amigo : listaAmigos) {
			if(amigo.getId()==idUsuario) {
				listaAmigos.remove(amigo);
				eliminaAmigo=true;
				break;
			}
		}
		
		return eliminaAmigo;
	}
	
	
	public final void recargarAmigo() {
		listaAmigos.clear();
		loadAmigos();
	}
	

	public final boolean getActualizaPuntuacion(int idAmigo,int idPuntuacion) {
		boolean actualizado=false;
		for (Amigo amigo : listaAmigos) {
			if(amigo.getId()==idPuntuacion) {
				amigo.setPuntuacion(idPuntuacion);
				actualizado=true;
				break;
			}
		}
		return actualizado;
	}
	
	public final int ultimoId() {
		int namigo=0;
		for (Amigo amigo : listaAmigos) {
			namigo++;
		}
		
		return namigo;
	}
	
	public Amigo AddAmigo(String nombre) {
		boolean isOk = false;
		int y = listaAmigos.size();
		int x = listaAmigos.size() + 1;

		Amigo nuevoAmigo = new Amigo(x, nombre);
		listaAmigos.add(nuevoAmigo);
		if (y < listaAmigos.size()) {
			isOk = true;
			return nuevoAmigo;
		} else {
			return null;
		}
	}
	
	public boolean actualizarAmigo(int i, String nombre, int j) {

		boolean isOk = false;

		String regexnum = ".?[0-9].?";

		if (i > 0 && nombre != null && !nombre.equals("") && !nombre.toUpperCase().equals(nombre)) {
			if (!nombre.matches(regexnum)) {
				for (Amigo amigo : listaAmigos) {
					if (amigo.getId() == i) {
						amigo.setPuntuacion(j);
						amigo.setNombre(nombre);
						int index = listaAmigos.indexOf(amigo);
						listaAmigos.set(index, amigo);
						isOk = true;
						break;
					}
				}
			}
		}
		return isOk;
	}

	
}

