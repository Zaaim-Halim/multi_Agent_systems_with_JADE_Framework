package com.halim;

import java.io.IOException;
import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class MyAgent extends Agent {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void setup()
	{
	    System.out.println("strating agent 1 : ");   
		/*
		 * this.addBehaviour(new OneShotBehaviour() {
		 * 
		 * 
		 * private static final long serialVersionUID = 1L;
		 * 
		 * @Override public void action() {
		 * 
		 * ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		 * msg.setContent("Hello from agent1"); msg.addReceiver(new AID("agent2",
		 * AID.ISLOCALNAME)); send(msg);
		 * 
		 * 
		 * } }); this.addBehaviour(new CyclicBehaviour() {
		 * 
		 * private static final long serialVersionUID = 1L;
		 * 
		 * @Override public void action() { ACLMessage msgReceived = receive();
		 * if(msgReceived != null)
		 * System.out.println("in agent1 : recived a message : "+
		 * msgReceived.getContent()); else block();
		 * 
		 * } });
		 */
	    
	    addBehaviour(new OneShotBehaviour() {
			
		
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
				Scanner scan = new Scanner(System.in);
						
				try {
					Double d = scan.nextDouble();
					String devise = scan.next();
					Money m = new Money(d,devise);
					msg.setContentObject(m);
					System.out.println("sending : " + m.toString());
					msg.addReceiver(new AID("agent2",AID.ISLOCALNAME));
					scan.close();
					send(msg);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
	    
	    addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage reponse = receive();
				if(reponse != null) {
					try {
						System.out.println("recived : "+ reponse.getContentObject().toString());
					} catch (UnreadableException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		});
	}
	
	public MyAgent()
	{
	}

}
