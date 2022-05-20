package com.halim;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class UserAgent extends Agent{

	private static final long serialVersionUID = 1L;
	private UserGui gui;
    @Override
	public void setup() {
		System.out.println("user agent started ...");
		gui = new UserGui(this);
		
	}
    
    public void setNombres(float n1 , float n2, String operation) {
   
    	System.out.println(n1  +" "+ n2);
    	this.addBehaviour(new OneShotBehaviour() {
			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
				Calcule calc = new Calcule(n1 ,n2);
				try {
					msg.setContentObject(calc);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(operation) {
				case "+":
					msg.addReceiver(new AID("plus",AID.ISLOCALNAME));
					send(msg);
					break;
				case "-":
					msg.addReceiver(new AID("minus",AID.ISLOCALNAME));
					send(msg);
					break;
				case "*":
					msg.addReceiver(new AID("multipl",AID.ISLOCALNAME));
					send(msg);
					break;
				case "/":
					msg.addReceiver(new AID("devid",AID.ISLOCALNAME));
					send(msg);
					break;
				default:
					break;
				
				}
				
			}
		});
    	
    	this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg != null)
				{
					try {
						Calcule m = (Calcule) msg.getContentObject();
						gui.setRes(m.getRes());
						
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				block();
				
			}
		});
    }
}
