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
import java.io.File;
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
		
		txt_nome_arquivo = new JTextField();
		txt_nome_arquivo.setEditable(false);
		txt_nome_arquivo.setColumns(10);
		
		JButton btn_avancar = new JButton("Avançar");
		btn_avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txt_nome_arquivo.getText().equals("")) {
				
				try {
					
					FileReader arquivo = new FileReader(txt_nome_arquivo.getText());
					BufferedReader lerArq = new BufferedReader(arquivo);
					
					String linha = lerArq.readLine();
					while (linha != null) { 
						System.out.printf("%s\n", linha); 
						linha = lerArq.readLine(); 
					}
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(getContentPane() , "Arquivo não encontrado");
				} catch (IOException e2){
					JOptionPane.showMessageDialog(getContentPane(), "Não foi possível ler o arquivo");
				}
				
			}
				
			}
		});
		
		JButton btn_arquivo = new JButton("Abrir arquivo");
		btn_arquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFileChooser fc = new JFileChooser();
                 int res = fc.showOpenDialog(getContentPane());
                 
                 if(res == JFileChooser.APPROVE_OPTION){
                     File arquivo = fc.getSelectedFile();  
                     txt_nome_arquivo.setText(arquivo.getAbsolutePath());
                 }
                 
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lbl_arquivo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txt_nome_arquivo, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btn_arquivo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_avancar)
					.addGap(51))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_arquivo)
						.addComponent(txt_nome_arquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_avancar)
						.addComponent(btn_arquivo))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		this.setSize(800, 324);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(groupLayout);
	}

	private static final long serialVersionUID = 3150213557789221860L;
	private JTextField txt_nome_arquivo;
}
