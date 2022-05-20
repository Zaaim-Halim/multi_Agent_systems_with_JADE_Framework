package com.halim;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class MinusOpAgent extends Agent{

	
	private static final long serialVersionUID = 1L;
	@Override
	public void setup()
	{   
		
		// ************* TAKER BEHAVIOUR ******************//
		this.addBehaviour(new TickerBehaviour(this,1000) {
		
			private static final long serialVersionUID = 1L;

			@Override
			protected void onTick() {
				//System.out.println(new java.util.Date().toLocaleString());
				
			}
		});
		//************************************************/
		//########### PALNIFIVATION DE TACh ###############
		this.addBehaviour(new WakerBehaviour(this,1000) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onWake() {
				System.out.println(new java.util.Date().toLocaleString());
				
			}
		});
		//**************************************************/
		/*##################### excution follow an outomate ...  #############*/
        this.addBehaviour(new FSMBehaviour() {
			
			
		});
        //#################################################################
        
        
        
        
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg != null)
				{
					try {
						Calcule m = (Calcule) msg.getContentObject();
						m.setRes(m.getN1()-m.getN2());
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
