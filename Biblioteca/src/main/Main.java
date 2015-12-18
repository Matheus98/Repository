package main;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import entidades.Volume;
import entidades.VolumeDAO;

public class Main {

	private static Scanner input;

	//METODO DE CADASTRO DO VOLUME
	public static void cadastrarVolume() throws SQLException{

		input = new Scanner (System.in);

		String valor = new String();

		Volume volume = new Volume();

		System.out.println("Bem vindo a tela de Cadastro de Volume\n");

		System.out.println("Entre com o titulo do volume\n");
		valor = input.nextLine();
		volume.setTitulo(valor);

		System.out.println("Entre com o nome do autor\n");
		valor = input.nextLine();
		volume.setAutor(valor);

		System.out.println("Entre com uma descrição\n");
		valor = input.nextLine();
		volume.setDescricao(valor);

		System.out.println("Entre com o tipo de volume\n");
		valor = input.nextLine();
		volume.setTipo(valor);

		System.out.println("Entre com o número de páginas\n");
		valor = input.nextLine();
		volume.setNum_pag(valor);

		System.out.println("Entre com o ano de publicação do volume\n");
		valor = input.nextLine();
		volume.setAno_public(valor);

		System.out.println("Entre com a editora\n");
		valor = input.nextLine();
		volume.setEditora(valor);

		VolumeDAO volumeDAO = new VolumeDAO();

		try {

			volumeDAO.inserir(volume);
			volumeDAO.disconnect();

		} catch (SQLException e) {

			System.out.println("Erro de funcionamento");
		}
		System.out.println("\nCADASTRO FEITO COM SUCESSO!\n");
	}
	//METODO DE REMOÇÃO DE UM VOLUME
	public static void removerVolume() throws SQLException{

		input = new Scanner (System.in);

		String valor = new String();

		Volume volume = new Volume();

		System.out.println("Bem vindo a tela de Remoção de Volumes\n");

		System.out.println("Entre com o titulo do volume\n");
		valor = input.nextLine();
		volume.setTitulo(valor);

		VolumeDAO volumeDAO = new VolumeDAO();

		try {

			volumeDAO.remove(volume);
			volumeDAO.disconnect();

		} catch (SQLException e) {

			System.out.println("Erro de funcionamento");
		}
		System.out.println("\nREMOÇÃO FEITA COM SUCESSO!\n");
	}

	//METODO DE CONSULTA DE VOLUME
	public static void consultarVolume() throws SQLException{

		input = new Scanner (System.in);

		String valor = new String();

		Volume volume = new Volume();

		System.out.println("Bem vindo a tela de Consulta de Volumes\n");

		System.out.println("Entre com o titulo do volume\n");
		valor = input.nextLine();
		volume.setTitulo(valor);

		VolumeDAO volumeDAO = new VolumeDAO();

		try {

			volumeDAO.query(volume);
			volumeDAO.disconnect();

		} catch (SQLException e) {

			System.out.println("Erro de funcionamento");
		}
		System.out.println("\nCONSULTA FEITA COM SUCESSO!\n");
	}

	//METODO MAIN
	public static void main(String[] args) throws SQLException, IOException  {
		input = new Scanner (System.in);

		while(true){

			System.out.println("Menu (Digite o numero para ter acesso ao serviço)\n"
					+ ">>> 1. Cadastrar Volume\n"
					+ ">>> 2. Remover Volume\n"
					+ ">>> 3. Consultar Volume");
			String escolhaFeita = input.nextLine();


			switch (escolhaFeita) {
			case "1": try {
				cadastrarVolume();
			}
			catch (java.util.InputMismatchException e){
				System.out.println("\nDados Incorretos!\n");
			}
			break;
			case "2": try {
				removerVolume();
			}
			catch (java.util.InputMismatchException e){
				System.out.println("\nDados Incorretos!\n");
			}
			break;
			case "3":
				try {
					consultarVolume();
				}
				catch (java.util.InputMismatchException e){
					System.out.println("\nDados Incorretos!\n");
				}
				break;

			default:
				System.out.println("\nValor inválido\n");
				break;
			}


		}
	}

}
