package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("digite o departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.println("nome: ");
		String nome = sc.nextLine();
		System.out.println("level: ");
		String nivelTrabalhador = sc.nextLine();
		sc.nextLine();
		System.out.print("Salario Base: ");
		double salarioBase = sc.nextDouble();
		sc.nextLine();
		System.out.print("Quantos contratos o trabalhador tem? ");
		int resposta = sc.nextInt();
		Funcionario funcionario = new Funcionario(nome, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase,
				new Departamento(departamento));

		for (int i = 0; i < resposta; i++) {
			System.out.println("DIGITE OS DADOS DO CONTRATO: ");
			System.out.print("Data: ");
			Date data = sdf.parse(sc.next());
			System.out.print("valor por Hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("horas trabalhadas : ");
			int horasTrabalhadas = sc.nextInt();

			HoraContrato contrato = new HoraContrato(data, valorHora, horasTrabalhadas);
			funcionario.addContrato(contrato);
		}
		System.out.println();
		System.out.println("Digite o mes e o ano da data de pesquisa: MM/yyyy");

		String mesano = sc.next();
		int mes = Integer.parseInt(mesano.substring(0, 2));
		int ano = Integer.parseInt(mesano.substring(3));
		System.out.println("nome Trabalhador: " + funcionario.getNome());
		System.out.println("departamento: " + funcionario.getDepartamento().getDepartamanto());
		System.out.println("valor total recebido: " + funcionario.income(ano, mes));
	}

}
