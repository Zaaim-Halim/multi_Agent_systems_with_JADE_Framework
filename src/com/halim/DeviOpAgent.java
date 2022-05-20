package com.halim;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class DeviOpAgent  extends Agent{
	@Override
	public void setup()
	{
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg != null)
				{
					try {
						Calcule m = (Calcule) msg.getContentObject();
						m.setRes(m.getN1()/m.getN2());
						ACLMessage res = msg.createReply();
						try {
							res.setContentObject(m);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						send(res);
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
