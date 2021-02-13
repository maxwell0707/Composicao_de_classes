package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date momento;
	private StatusPedido statusPedido;
	private Cliente cliente;
	private List<ItemPedido> list = new ArrayList();

	public Pedido(StatusPedido statusPedido, Cliente cliente) {

		this.momento = new Date();
		this.statusPedido = statusPedido;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getList() {
		return list;
	}

	public void addList(ItemPedido itemPedido) {
		list.add(itemPedido);
	}

	public void removeList(ItemPedido itemPedido) {
		list.remove(itemPedido);
	}

	public double valorTotal() {
		double soma = 0;

		for (ItemPedido list : list) {

			soma += list.subTotal();
		}
		return soma;

	}

	@Override
	public String toString() {
		return
				"Cliente: "
				+getCliente().getNome()
				+"\nEmail: "
				+getCliente().getEmail()
				+"\nData de nascimento: "
				+sdf.format(getCliente().getDataNascimento())
				+"\n*******************************************"
				+"\nPEDIDO: ";
				
				
				
	}

}
