import java.util.Random;
import java.util.Vector;

public class SOMNode 
{
	private Vector<Double> weightVect = new Vector<Double>();
	private double matDistX, matDistY;
	private int m_iLeft, m_iTop, m_iRight, m_iBottom;
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @param top
	 * @param bot
	 * @param numWeights
	 */
	public SOMNode(int left, int right, int top, int bot, int numWeights)
	{
		Random rand = new Random();
		double r;
		m_iLeft = left;
		m_iRight = right;
		m_iTop = top;
		m_iBottom = bot;
		
		
		/**
		 * Init. weights
		 * check and make sure rand.nextDouble() doesn't return
		 * 0.0
		 */
		for(int w = 0; w<numWeights; w++)
		{
			r = rand.nextDouble();
			while(r==0.0)
				r=rand.nextDouble();
			weightVect.add(r);
		}
		
		/**
		 * We calculate the center of the node
		 */
		matDistX = m_iLeft + (m_iRight - m_iLeft)/2.0;
		matDistY = m_iTop + (m_iBottom - m_iTop)/2.0;
		
	}
	
	public double getDistance(Vector<Double> inVect)
	{
		double dist = 0.0;
		for(int i = 0; i<weightVect.size(); i++)
			dist = dist + (inVect.get(i) - weightVect.get(i)) * (inVect.get(i) - weightVect.get(i));
		return Math.sqrt(dist);
		
	}
	
	
}
