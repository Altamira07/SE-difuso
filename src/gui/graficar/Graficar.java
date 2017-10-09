package gui.graficar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funcion.Funcion;
import funcion.Membresia;
import funcion.Punto;

public class Graficar extends JPanel implements ActionListener {
	private Funcion funcion;
	private int ancho, alto;
	private ArrayList<Punto> puntos;
	private double segmento;
	private double tamano;
	private Punto pInicial, pFinal;
	Punto evaluado = null;
	private JButton btnCalcMembresia;
	private JTextField txfX;
	private Grafica grafica;
	private Membresia membresia;

	public Graficar(Funcion funcion) {
		this.funcion = funcion;
		puntos = funcion.getPuntos();
		setLayout(new BorderLayout());
		grafica = new Grafica();
		add(grafica, BorderLayout.CENTER);
		btnCalcMembresia = new JButton("Calcular membresia");
		setBorder(BorderFactory.createLineBorder(Color.black));
		txfX = new JTextField();
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		pnl.add(btnCalcMembresia);
		pnl.add(txfX);
		membresia = new Membresia(funcion);
		add(pnl, BorderLayout.NORTH);
		btnCalcMembresia.addActionListener(this);

		this.setSize(360, 260);
		ancho = this.getWidth();
		alto = this.getHeight();

	}

	private int caclValRealX(double x) {
		double val = pFinal.getX() - x;
		x = tamano - val;
		return (int) (segmento * x) + 30;
	}

	private int caclValRealY(double y) {
		double val = (200 * y);
		val = 200 - val;
		return (int) (val + 30);
	}

	public Punto getEvaluado() {
		return evaluado;
	}

	public void setEvaluado(Punto evaluado) {
		this.evaluado = evaluado;
	}

	private class Grafica extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			// Lineas de la grafica
			g2.drawLine(30, 30, 30, alto - 30);
			g2.drawLine(30, alto - 30, ancho - 30, alto - 30);
			g2.drawString("0", 20, alto - 30);
			g2.drawString("1", 20, 30);
			// Dibujando valores X
			pInicial = puntos.get(0);
			pFinal = puntos.get(puntos.size() - 1);
			g2.drawString(pInicial.getX() + "", 30, alto - 10);
			g2.drawString(pFinal.getX() + "", ancho - 30, alto - 10);
			// Titulo de la funcion
			g2.drawString(funcion.getNombre(), 100, 15);
			// Dibujando funcion
			tamano = pFinal.getX() - pInicial.getX();
			segmento = (ancho - 60) / tamano;
			Punto a = puntos.get(0);
			g2.setColor(Color.RED);
			;
			for (int i = 1; i < puntos.size(); i++) {
				Punto b = puntos.get(i);
				g2.drawLine(caclValRealX(a.getX()), caclValRealY(a.getY()), caclValRealX(b.getX()),
						caclValRealY(b.getY()));
				a = b;
			}
			g2.setColor(Color.BLUE);
			if (evaluado != null) {
				g2.fillOval(caclValRealX(evaluado.getX()) - 5, caclValRealY(evaluado.getY()) - 5, 10, 10);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		evaluado = new Punto(Double.parseDouble(txfX.getText().toString()));
		evaluado.setY(membresia.calcMembresia(evaluado.getX()));
		JOptionPane.showMessageDialog(null, "El valor de membresia es:" + evaluado.getY());
		grafica.repaint();
	}

}
