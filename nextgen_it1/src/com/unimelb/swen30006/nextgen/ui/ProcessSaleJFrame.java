package com.unimelb.swen30006.nextgen.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.unimelb.swen30006.nextgen.datatype.ItemID;
import com.unimelb.swen30006.nextgen.datatype.Money;
import com.unimelb.swen30006.nextgen.domain.ProductCatalog;
import com.unimelb.swen30006.nextgen.domain.Register;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Simple UI layer
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-08-01
 *
 */
public class ProcessSaleJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnMakeNewSale = new JButton("Make New Sale");
	private JButton btnEnterItem = new JButton("Enter New Item");
	private JButton btnEndSale = new JButton("End Sale");
	private JButton btnMakePayment = new JButton("Make Payment");
	
	private JLabel lblItemID = new JLabel("Item ID", SwingConstants.CENTER);
	private JLabel lblQuantity = new JLabel("Quantity", SwingConstants.CENTER);
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbx;
	
	private JTextField txtQuantity = new JTextField("");
	
	private JTextArea txtArea = new JTextArea();
	
	@SuppressWarnings("unused")
	private Register register;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ProcessSaleJFrame(final Register register, ProductCatalog catalog){
		this.register = register;
		
		cbx = new JComboBox(catalog.getIDs().toArray());
		cbx.setAlignmentY(CENTER_ALIGNMENT);
		
		txtQuantity.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		JScrollPane scroll = new JScrollPane (txtArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(lblItemID);
		panel.add(cbx);
		panel.add(lblQuantity);
		panel.add(txtQuantity);
		panel.add(btnMakeNewSale);
		panel.add(btnEnterItem);
		panel.add(btnEndSale);
		panel.add(btnMakePayment);
		
		btnEnterItem.setVisible(false);
		btnEndSale.setVisible(false);
		btnMakePayment.setVisible(false);
		
		btnMakeNewSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//delegate event to register
				register.makeNewSale();
				
				//output for observation
				txtArea.setText("");
				txtArea.append("Start new sale!\n");
				btnMakeNewSale.setVisible(false);
				btnEnterItem.setVisible(true);
				btnEndSale.setVisible(true);
			}
        });
		
		btnEnterItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//collect data
				ItemID id = new ItemID(cbx.getSelectedItem().toString());
				int quantity = 0;
				try{
					quantity = Integer.parseInt(txtQuantity.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Quantity not valid");
					return;
				}
				//delegate event to register
				register.enterItem(id, quantity);
				
				txtQuantity.setText("");
				//output for observation
				txtArea.append("add item "+id+" Qty:" + quantity + "\n");
			}
        });
		
		btnEndSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//delegate event to register
				register.endSale();
				//output for observation
				txtArea.append("End Sale!\n");
				btnMakePayment.setVisible(true);
				btnEnterItem.setVisible(false);
				btnEndSale.setVisible(false);
			}
        });
		
		btnMakePayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String paid = JOptionPane.showInputDialog(null, "Total: "+register.getTotal()+"\nCash Paid");
				if(paid == null){
					JOptionPane.showMessageDialog(null, "Input not valid");
					return;
				}
				//delegate event to register
				register.makePayment(new Money(new BigDecimal(paid)));;
				//output for observation
				txtArea.append("Print receipt:\n");
				txtArea.append(register.printReceipt()+"\n");
				btnMakeNewSale.setVisible(true);
				btnMakePayment.setVisible(false);
			}
        });
		
		txtArea.setEditable(false);
		
		this.setTitle("The Foo Store");
		this.setLayout(new GridLayout(2,1));
		this.add(panel);
		this.add(scroll);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
