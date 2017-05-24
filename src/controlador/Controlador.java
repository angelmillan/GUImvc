package controlador;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UserDAO;
import vista.Vista;
import modelo.Usuario;
public class Controlador implements ActionListener {
	
	private Vista vista;
	private UserDAO userDAO;
	private List<Usuario> listaUsuarios;
	private static int contador1 = 0;
	
	
	
	
	public Controlador(Vista vista, UserDAO userDAO) {
		this.vista = vista;
		this.userDAO = userDAO;
		actionListener(this);
		listaUsuarios = userDAO.getListaUsuarios();
		mostraUsuario(0);
	}



	//respuesta a los eventos de la vista
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case ("<"):
			contador1--;
			if (contador1 < 0)
				contador1 = listaUsuarios.size()-1;
			System.out.println(listaUsuarios.size() + " " + contador1);
			mostraUsuario(contador1);
			break;
		case (">"):
			contador1++;
			if (contador1 == listaUsuarios.size())
					contador1 = 0;
			System.out.println(listaUsuarios.size() + " " + contador1);
			mostraUsuario(contador1);
			break;
		case (">>"):	
			contador1 += 25;
			if (contador1 >= listaUsuarios.size())
				contador1 = 0;
			System.out.println(listaUsuarios.size() + " " + contador1);
			mostraUsuario(contador1);	
			break;
		case ("<<"):
			contador1 -= 25;
			if (contador1 < 0)
				contador1 = listaUsuarios.size()-1;
			System.out.println(listaUsuarios.size() + " " + contador1);
			mostraUsuario(contador1);
			break;
			
		default:
			break;
		}
		

	
				

	}
	
	//registro los eventos de la vista
	public void actionListener(ActionListener escuchador){
		vista.getButtonAvance1().addActionListener(escuchador);
		vista.getButtonRetroceso1().addActionListener(escuchador);
		vista.getButtonAvance25().addActionListener(escuchador);
		vista.getButtonRetroceso25().addActionListener(escuchador);
		
	}
	
	private void mostraUsuario(int indice){
		vista.getTextFieldLogin().setText(
				listaUsuarios.get(indice).getLogin());
		vista.getTextFieldPassword().setText(
				listaUsuarios.get(indice).getPassword());
		vista.getTextFieldCode().setText(
				listaUsuarios.get(indice).getCode());
		vista.getTextFieldGender().setText(
				listaUsuarios.get(indice).getGender());
	}

}
