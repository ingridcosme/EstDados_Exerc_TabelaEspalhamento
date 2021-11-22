/*
 * Uma empresa precisa de um programa que efetue o cadastro de compradores.
 * Os compradores deverão ser alocados e rescuperados rapidamente da memó_
 * ria. Crie um programa para esta empresa, alocando os "Compradores" em 
 * uma HashTable utilizando a API do Java.
 * A chave deve ser o nome e cada comprador tem nome, rg, cpf e telefone.
 */

package view;

import java.util.Hashtable;

import javax.swing.JOptionPane;

import controller.CadastroController;
import model.Comprador;

public class Principal {

	public static void main(String[] args) {
		CadastroController cadCont = new CadastroController();
		Hashtable<String, Comprador> ht = new Hashtable<String, Comprador>();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 0:
				Comprador comp = new Comprador();
				comp.nome = JOptionPane.showInputDialog(null, "Insira o nome");
				comp.rg = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o RG"));
				comp.cpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o CPF"));
				comp.telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o Telefone"));
				cadCont.cadastrar(comp, ht);
				break;
			
			case 1:
				try {
					String nome = JOptionPane.showInputDialog(null, "Insira o nome a ser consultado");
					Comprador compConsultado = cadCont.consultar(nome, ht);
					JOptionPane.showMessageDialog(null, "Comprador: "+compConsultado.nome+"\nRG: "+compConsultado.rg
							+"\nCPF: "+compConsultado.cpf+"\nTelefone: "+compConsultado.telefone);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 2:
				try {
					String nome = JOptionPane.showInputDialog(null, "Insira o nome a ser removido");
					Comprador compRemovido = cadCont.remove(nome, ht);
					JOptionPane.showMessageDialog(null, "Comprador "+compRemovido.nome+" portador do RG "
							+compRemovido.rg+" foi removido");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 9:
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Digite uma opção:\n");
		buffer.append("0 - Cadastrar novo comprador\n");
		buffer.append("1 - Consultar comprador\n");
		buffer.append("2 - Remover comprador\n");
		buffer.append("9 - Encerra a aplicação\n");

		return buffer.toString();
	}

}
