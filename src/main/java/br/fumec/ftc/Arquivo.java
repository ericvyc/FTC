package br.fumec.ftc;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Arquivo extends JFrame {
	public Arquivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Auto Instrucional");

		JLabel lbl_arquivo = new JLabel("Busque seu arquivo de AFN:");
		JFileChooser selectArquivo = new JFileChooser();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addComponent(lbl_arquivo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(selectArquivo, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(51)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(selectArquivo, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_arquivo))
						.addContainerGap(51, Short.MAX_VALUE))
				);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(groupLayout);
	}

	private static final long serialVersionUID = 3150213557789221860L;
}
