package com.halim;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.instance();
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.MAIN_HOST, "localhost");
		profile.setParameter(Profile.GUI, "false");
		ContainerController cc  = runtime.createMainContainer(profile);
		try {
			//AgentController agentController = cc.createNewAgent("agent1",MyAgent.class.getName() , null);
			//AgentController agentController3 = cc.createNewAgent("agent2", AnotherAgent.class.getName(), null);
			AgentController agentControllerHalim = cc.createNewAgent("plus", PlusAgent.class.getName(), null);
			AgentController agentControllerUser = cc.createNewAgent("user", UserAgent.class.getName(), null);
			AgentController agentControllerMinus = cc.createNewAgent("minus", MinusOpAgent.class.getName(), null);
			AgentController agentControllerMultipl = cc.createNewAgent("multipl", MultiplOpAgent.class.getName(), null);
			AgentController agentControllerDevid = cc.createNewAgent("devid", DeviOpAgent.class.getName(), null);
			//agentController.start();
			//agentController3.start();
			agentControllerHalim.start();
			agentControllerUser.start();
			agentControllerMinus.start();
			agentControllerMultipl.start();
			agentControllerDevid.start();
		} catch (StaleProxyException e) {
			System.err.println(" failed");
			e.printStackTrace();
		}

	}

}
