package model;

import java.util.LinkedList;

/**
 * A class that holds all of the accounts created in the program.
 * @author Eren Þenoðlu, Batuhan Özçömlekçi
 * @version 23.12.2018
 */


	public class ConsultantContainer {
		
	public LinkedList<Consultant> list;
	
	/**
	 * Constructs a new ConsultantContainer object and initializes three objects.
	 */
	public ConsultantContainer()
	{
		String path = getClass().getClassLoader().getResource(".").getPath();
		path = path.substring( 0 , path.length() - 4 );
		path += "src/";
		System.out.println("consultantconainerpath" + path);
		list = new LinkedList<Consultant>();
		list.add( new Consultant( 75,42,"Harold Dirksen","You are expecting to get high profit from stocks. Definitely not an easy task, but I'm here to help you !", path + "consultantOne.png") );
		list.add( new Consultant( 225,65,"Brian Schwartz","I think you need some good advice about stocks. You came to the right guy.That should be"  
							+  "doable for someone like me, right?", path + "consultantTwo.jpg" ) );
		list.add( new Consultant( 475,100,"Matthew Hedberg","Please, do not hesitate to contact me because I am very good at predicting stock values. If you need guidance about stocks. I can be of assitance !",path + "consultantThree.jpg" ) );
	} 
	/**
	 * Returns the consultant object with given ID.
	 * @param ID the ID of the consultant.
	 * @return the consultant
	 */
	public Consultant getConsultant(int ID) {
		return list.get(ID);
		
	}
}
