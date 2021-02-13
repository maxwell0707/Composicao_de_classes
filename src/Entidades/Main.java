package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do Cliente: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento: ");
		Date data = sdf.parse(sc.next());

		System.out.println("ENTRE COM OS DADOS DO PEDIDO: ");
		System.out.println("Status Do Pedido ");
		String statusPedido = sc.next();
		sc.nextLine();
		System.out.println("Quantos Pedidos serao adicionados?  ");
		int resposta = sc.nextInt();

		Pedido pedido = new Pedido(StatusPedido.valueOf(statusPedido), new Cliente(nome, email, data));
		for (int i = 0; i < resposta; i++) {
			sc.nextLine();
			System.out.println("Nome Produto : ");
			String nomeProduto = sc.nextLine();
			System.out.println("Preco produto ");
			double preco = sc.nextDouble();
			System.out.println("quantidade: ");
			int quantidade = sc.nextInt();
			pedido.addList(new ItemPedido(quantidade,preco,new Produto(nomeProduto,preco)));
		}
		
		System.out.println(pedido);
		for(ItemPedido c:  pedido.getList()) {
			
			System.out.print("Nome Do produto: " + c.getProduto().getNome());
			System.out.print("\npreco: " +String.format("%.2f\n", c.getProduto().getPreco()));
			
		}

		System.out.println("valor Total: R$ " + pedido.valorTotal());
		

	}

}
