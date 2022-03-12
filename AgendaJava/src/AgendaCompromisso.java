import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.Compromisso;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;

public class AgendaCompromisso extends JFrame {
	private JTextField textFieldTitulo;

	
	public AgendaCompromisso(List<Compromisso> agenda, JTable table) {
		
		setBounds(100, 100, 648, 521);
		getContentPane().setLayout(null);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(10, 25, 216, 20);
		getContentPane().add(textFieldTitulo);
		
		JLabel lblNewLabeltitulo = new JLabel("Titulo");
		lblNewLabeltitulo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabeltitulo);
		
		JLabel lblNewLabelDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabelDescricao.setBounds(10, 73, 46, 14);
		getContentPane().add(lblNewLabelDescricao);
		
		JTextArea textDescricao = new JTextArea();
		textDescricao.setBounds(10, 89, 216, 103);
		getContentPane().add(textDescricao);
		
		JLabel lblDatainicio = new JLabel("dataInicio");
		lblDatainicio.setBounds(10, 203, 89, 14);
		getContentPane().add(lblDatainicio);
		
		JSpinner spinnerDataInicio = new JSpinner();
		spinnerDataInicio.setModel(new SpinnerDateModel(new Date(1638414000000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerDataInicio.setBounds(10, 218, 111, 37);
		getContentPane().add(spinnerDataInicio);
		
		JLabel lblDatafim = new JLabel("dataFim");
		lblDatafim.setBounds(10, 275, 89, 14);
		getContentPane().add(lblDatafim);
		
		JSpinner spinnerDataFim = new JSpinner();
		spinnerDataFim.setModel(new SpinnerDateModel(new Date(1638414000000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerDataFim.setBounds(10, 289, 111, 37);
		getContentPane().add(spinnerDataFim);
		
		
		
		 Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
			
		
		JButton btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agenda.add(new Compromisso(textFieldTitulo.getText(), textDescricao.getText(),
						(Date) spinnerDataInicio.getValue(), (Date) spinnerDataFim.getValue(), null));
				textFieldTitulo.setText("");
				textDescricao.setText("");
				spinnerDataInicio.setValue(date);
				spinnerDataFim.setValue(date);
				Agenda.tela();
			}
		});
		btnNewButtonSalvar.setBounds(10, 337, 89, 23);
		getContentPane().add(btnNewButtonSalvar);
		
		JButton btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compromisso c = (Compromisso) agenda.get(table.getSelectedRow() - 1);
				c.setTitulo(textFieldTitulo.getText());
				c.setDescricao(textDescricao.getText());
				c.setDatahorainicio((Date) spinnerDataInicio.getValue());
				c.setDatahorafim((Date) spinnerDataFim.getValue());
				int i = table.getSelectedRow();
				

				Agenda.tela();
				table.setRowSelectionInterval(i, i);
			}
		});
		btnNewButtonEditar.setBounds(10, 371, 89, 23);
		getContentPane().add(btnNewButtonEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compromisso c = (Compromisso) agenda.get(table.getSelectedRow() - 1);
				agenda.remove(c);
				Agenda.tela();
			}
		});
		btnDeletar.setBounds(10, 405, 89, 23);
		getContentPane().add(btnDeletar);
		
		if (table.getSelectedRow() > -1) {
			Object Titulo = table.getModel().getValueAt(table.getSelectedRow(), 0);
			textFieldTitulo.setText((String) Titulo);
			Object Descricao = table.getModel().getValueAt(table.getSelectedRow(), 1);
			textDescricao.setText((String) Descricao);
			Object dataInicio = table.getModel().getValueAt(table.getSelectedRow(), 2);
			spinnerDataInicio.setValue(dataInicio);
			Object dataFim = (table.getModel().getValueAt(table.getSelectedRow(), 3));
			spinnerDataFim.setValue((dataFim)); 
			}
		
		
	}
}
