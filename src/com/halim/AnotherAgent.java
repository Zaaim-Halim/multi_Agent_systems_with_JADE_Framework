package com.halim;

import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AnotherAgent extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Override
	public void setup()
	{
		
		System.out.println("Starting agent 2 ....");
		this.addBehaviour(new  CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			 
			public void action() {
				ACLMessage msg = receive();
				if(msg != null)
				{
					
					Money m = null;
					try {
						m = (Money) msg.getContentObject();
						m.setAmount(m.getAmount()/10);
						m.setDevise("EURO");
						ACLMessage res = msg.createReply();
						res.setContentObject(m);
						send(res);
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								
				}
				else 
					block();
				
			}
		});
	}

}
