import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Classes.Compromisso;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Calendar;

public class Agenda {

	private JFrame frame;
	public static List<Compromisso> agenda = new Vector<Compromisso>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agenda() {
		initialize();
	}

	private static JTable table;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 648, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		table = new JTable() {
			  private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false;               
		        };
		    
		};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.setBounds(10, 11, 357, 244);
		frame.getContentPane().add(table);

		model.addColumn("Col1");
		model.addColumn("Col2");
		model.addColumn("Col3");
		model.addColumn("Col4");

		model.addRow(new Object[] { "Titulo", "descrição", "DataInicio", "DataFim" });

		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	AgendaCompromisso p = new AgendaCompromisso(agenda,table);
					p.setVisible(true);     
					p.setLocationRelativeTo(null);
		        }
		    }
		});
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					if (!e.getValueIsAdjusting()) {
				/*		Object Titulo = table.getModel().getValueAt(table.getSelectedRow(), 0);
						textFieldTitulo.setText((String) Titulo);
						Object Descricao = table.getModel().getValueAt(table.getSelectedRow(), 1);
						textDescricao.setText((String) Descricao);
						Object dataInicio = table.getModel().getValueAt(table.getSelectedRow(), 2);
						spinnerDataInicio.setValue(dataInicio);
						Object dataFim = (table.getModel().getValueAt(table.getSelectedRow(), 3));
						spinnerDataFim.setValue((dataFim)); */

					}
				} 
			}
		});
		 Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		
		JButton btnNovoCadastro = new JButton("novo cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgendaCompromisso p = new AgendaCompromisso(agenda,table);
				p.setVisible(true);     
				p.setLocationRelativeTo(null);
			}
		});
		btnNovoCadastro.setBounds(377, 7, 133, 23);
		frame.getContentPane().add(btnNovoCadastro);

	}
	
	

	@SuppressWarnings("serial")
	static TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof Date) {
				value = f.format(value);
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	};

	static void tela() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(1);

		for (Compromisso p : agenda) {
			model.addRow(new Object[] { p.getTitulo(), p.getDescricao(), p.getDatahorainicio(), p.getDatahorafim() });
		}

		table.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);

	}
}
