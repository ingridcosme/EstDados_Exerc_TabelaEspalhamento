/*
 * Uma empresa precisa de um programa que efetue o cadastro de compradores.
 * Os compradores deverão ser alocados e rescuperados rapidamente da memó_
 * ria. Crie um programa para esta empresa, alocando os "Compradores" em 
 * uma HashTable utilizando a API do Java.
 * A chave deve ser o nome e cada comprador tem nome, rg, cpf e telefone.
 */

package controller;

import java.util.Hashtable;
import model.Comprador;

public class CadastroController {

	public CadastroController() {
		super();
	}
	
	public void cadastrar(Comprador comp, Hashtable<String, Comprador> ht) {
		ht.put(comp.nome, comp);
	}
	
	public Comprador consultar(String nome, Hashtable<String, Comprador> ht) throws Exception {
		if(ht.isEmpty()) {
			throw new Exception("Não há compradores cadastrados");
		}
		Comprador comp = ht.get(nome);
		return comp;
	}

	public Comprador remove(String nome, Hashtable<String, Comprador> ht) throws Exception {
		if(ht.isEmpty()) {
			throw new Exception("Não há compradores cadastrados");
		}
		return ht.remove(nome);
	}
	
}
