/**
 * Copyright (c) 2008-2011 Luis Gustavo Nardin <gnardin@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package agents.jade;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
=======
import agents.jade.JADEAgent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05

/**
 * 
 */
<<<<<<< HEAD
public class JADEAgentGUI extends JFrame {
=======
public class JADEAgentGUI extends JFrame{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Default window X and Y position
	public final Integer	DEFAULT_POSX	= new Integer(0);
	
	public final Integer	DEFAULT_POSY	= new Integer(0);
	
	private Integer				posX					= this.DEFAULT_POSX;
	
	private Integer				posY					= this.DEFAULT_POSY;
	
	private JADEAgent			agent;
	
	private JComboBox			agentCombo;
	
	private JButton				queryButton		= new JButton();
	
	private JButton				clearButton		= new JButton();
	
	private JTextArea			logArea				= new JTextArea();
	
	private JScrollPane		logScroll			= new JScrollPane();
	
	private GridLayout		paneLayout;
	
	private JTextArea			textArea			= new JTextArea();
	
	private JScrollPane		textScroll		= new JScrollPane();
	
	
	/**
	 * Constructor of the agent graphical user interface
	 * 
	 * @param agent
	 *          Agent class which is related to thos graphical user interface
	 * @param agentName
	 *          Agent name
	 * @param posX
	 *          Start X-axis of the graphical window
	 * @param posY
	 *          Start Y-axis of the graphical window
	 */
	public JADEAgentGUI(JADEAgent agent, String agentName, Integer posX,
<<<<<<< HEAD
			Integer posY) {
=======
			Integer posY){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.agent = agent;
		
		if(posX != null)
			this.posX = posX;
		
		if(posY != null)
			this.posY = posY;
		
		this.setTitle(agentName);
		
<<<<<<< HEAD
		try {
			this.guiInit();
		} catch(Exception e) {
=======
		try{
			this.guiInit();
		}catch(Exception e){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			e.printStackTrace();
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Creates the agent graphical user interface
	 * 
	 * @param none
	 * @return none
	 */
<<<<<<< HEAD
	public void guiInit() throws Exception {
=======
	public void guiInit() throws Exception{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Container pane = this.getContentPane();
		
		// Defining the Main Pane properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(700, 400);
		this.setLocation(this.posX, this.posY);
		paneLayout = new GridLayout(4, 0);
		pane.setLayout(paneLayout);
		
		// Defining query Text Area properties
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createTitledBorder("Query"));
		
		// Defining query Scroll properties
		textScroll = new JScrollPane(textArea);
		textScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(textArea);
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		
		// Defining list of agents
		agentCombo = new JComboBox(this.agent.getAgents());
		agentCombo.setAutoscrolls(true);
		pane.add(agentCombo);
		
		GridLayout buttonLayout = new GridLayout(0, 2);
		JPanel pButtons = new JPanel(buttonLayout);
		
		// Defining clear Send Button properties
		queryButton.setText("Send");
<<<<<<< HEAD
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((String) agentCombo.getSelectedItem() != null) {
=======
		queryButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				if((String) agentCombo.getSelectedItem() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					agent.send((String) agentCombo.getSelectedItem(), textArea.getText());
				}
			}
		});
		pButtons.add(queryButton, BorderLayout.WEST);
		
		// Defining Clear results Button properties
		clearButton.setText("Clear");
<<<<<<< HEAD
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
=======
		clearButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				textArea.setText("");
				logArea.setText("");
			}
		});
		pButtons.add(clearButton, BorderLayout.EAST);
		
		pane.add(pButtons);
		
		// Defining log Text Area properties
		logArea.setEditable(true);
		logArea.setLineWrap(true);
		logArea.setBorder(BorderFactory.createTitledBorder("Communication Log"));
		
		// Defining query Scroll properties
		logScroll = new JScrollPane(logArea);
		logScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(logScroll, BorderLayout.SOUTH);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Write a message into the Communication Log text area
	 * 
	 * @param message
	 *          Message to be written
	 * @return none
	 */
<<<<<<< HEAD
	public void logWrite(final String message) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
=======
	public void logWrite(final String message){
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				logArea.append(message + "\r\n");
			}
		});
	}
}