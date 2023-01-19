package Ventanas;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import DeustoLand.TipoEntrada;

public class Renderer extends JLabel implements TableCellRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private TipoEntrada tipoE = null;
	private ArrayList<Integer> is=null;
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		this.setText(value.toString());
		this.setFont(new Font("Helvetica Bold", Font.PLAIN, 12));
		
		if(tipoE!=null) {
			TipoEntrada tipoV = (TipoEntrada) table.getModel().getValueAt(row, 3);
			if (tipoV.equals(tipoE)) {
				this.setOpaque(true);
				this.setBackground(new Color(207, 154, 231));
			} else {
				this.setOpaque(false);
			}
			tipoE = null;
		}
		if(is != null) {
			if(is.contains(row)) {
				this.setOpaque(true);
				this.setBackground(new Color(207, 154, 231));
			}
			is=null;
		}
		return this;
	}

	public void setEntrada(TipoEntrada entrada) {
		tipoE = entrada;
	}
	public void setArray(ArrayList<Integer> is) {
		this.is=is;
	}
}