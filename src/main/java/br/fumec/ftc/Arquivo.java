package br.fumec.ftc;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Arquivo extends JFrame {
	public Arquivo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Auto Instrucional");

		JLabel lbl_arquivo = new JLabel("Busque seu arquivo de AFN:");
		JFileChooser selectArquivo = new JFileChooser();
		selectArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_nome_arquivo.setText(selectArquivo.getSelectedFile().getAbsolutePath());
			}
		});
		
		JLabel lbl_nome_arquivo = new JLabel("Seu arquivo:");
		
		txt_nome_arquivo = new JTextField();
		txt_nome_arquivo.setEditable(false);
		txt_nome_arquivo.setColumns(10);
		
		JButton btn_avancar = new JButton("Avançar");
		btn_avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					FileReader arquivo = new FileReader(txt_nome_arquivo.getText());
					BufferedReader lerArq = new BufferedReader(arquivo);
					
					String linha = lerArq.readLine();
					while (linha != null) { 
						System.out.printf("%s\n", linha); 
						linha = lerArq.readLine(); 
					}
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
				} catch (IOException e2){
					JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo");
				}
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lbl_arquivo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(selectArquivo, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(lbl_nome_arquivo)
							.addGap(31)
							.addComponent(txt_nome_arquivo, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(btn_avancar)))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(selectArquivo, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_arquivo))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_nome_arquivo)
						.addComponent(txt_nome_arquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_avancar))
					.addGap(59))
		);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(groupLayout);
	}

	private static final long serialVersionUID = 3150213557789221860L;
	private JTextField txt_nome_arquivo;
}
