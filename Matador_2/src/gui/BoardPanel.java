package gui;

import gui.FieldPanel.Builder;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{
	Dimension fieldDimension = null;
	DiceLabel d1 = new DiceLabel();
	DiceLabel d2 = new DiceLabel();
	private int d1XModifier;
	private int d1YModifier;
	private int d2XModifier;
	private int d2YModifier;
	private FieldPanel[] fields;
	
	protected BoardPanel()
	{
		d1XModifier = this.getSize().width / 2;
		d1YModifier = this.getSize().height / 2;
		d2XModifier = this.getSize().width / 2;
		d2YModifier = this.getSize().height / 2;
		fieldDimension = new Dimension();
		this.setLayout(null);
		this.setBackground(Color.GREEN);
		this.add(d1);
		this.add(d2);
		
		setupFields();
	}
	
	protected void updatePositions()
	{
		fieldDimension.setSize( this.getSize().getWidth() / 11.0,  this.getSize().getHeight() / 11.0);
		d1.setBounds(d1XModifier, d1YModifier, 65, 65);
		d2.setBounds(d2XModifier, d2YModifier, 65, 65);
		
		int xOffset = 10;
		int yOffset = 10;
		for (int i = 0; i < fields.length; i++)
		{
			fields[i].setBounds(xOffset * fieldDimension.width, yOffset * fieldDimension.height, fieldDimension.width, fieldDimension.height);
			fields[i].updatePositions();
			
			//first 10 fields, bottom right to left
			if(xOffset > 0 && yOffset == 10)
				xOffset--;
			
			//next 10 fields, left side bottom and up
			else if(xOffset == 0 && yOffset > 0)
				yOffset--;
			
			//next 10, top left to right
			else if(xOffset < 10 && yOffset == 0)
				xOffset++;
			
			//final 10, right side top to bottom
			else if(xOffset == 10 && yOffset < 10)
				yOffset++;
		}
	}
	
	protected void setDice(int value1, int value2)
	{
		Random r = new Random();
		d1.setDice(value1);
		d1XModifier = r.nextInt((this.getSize().width - 2 * fieldDimension.width) - 65);
		d1YModifier = r.nextInt((this.getSize().height - 2 * fieldDimension.height) - 65);
		d2.setDice(value2);
		d2XModifier = r.nextInt((this.getSize().width - 2 * fieldDimension.width) - 65);
		d2YModifier = r.nextInt((this.getSize().height - 2 * fieldDimension.height) - 65);
		d1.setVisible(true);
		d2.setVisible(true);
	}
	
	//Standard Board generator
	protected void setupFields()
	{
		this.fields = new FieldPanel[40];
		
		this.fields[0] = new FieldPanel.Builder()
								  .setTitle("START")
								  .setSubText("kr. 4000")
								  .setBGColor(Color.RED)
								  .build();
		
		this.fields[1] = new FieldPanel.Builder()
		  						  .setTitle("Rødovrevej")
		  						  .setSubText("kr. 1200")
		  						  .setBGColor(new Color(109, 245, 247)) //custom ligher blue
		  						  .build();
		
		this.fields[2] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		
		
		this.fields[3] = new FieldPanel.Builder()
								  .setTitle("Hvidovrevej")
								  .setSubText("kr. 1200")
								  .setBGColor(new Color(109, 245, 247))//custom ligher blue
								  .build();
		
		this.fields[4] = new FieldPanel.Builder()
		  						  .setTitle("Skat")
		  						  .setSubText("10% / kr. 4000")
		  						  .build();

		
		this.fields[5] = new FieldPanel.Builder()
		  						  .setTitle("Scanlines")
		  						  .setSubText("kr. 4000")
		  						  .setPicture(Builder.FERRY1)
		  						  .build();
		
		this.fields[6] = new FieldPanel.Builder()
		  						  .setTitle("Roskildevej")
		  						  .setSubText("kr. 2000")
		  						  .setBGColor(new Color(255, 110, 0))//custom Orange
		  						  .build();
		
		this.fields[7] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		
		this.fields[8] = new FieldPanel.Builder()
		  						  .setTitle("Valby Langgade")
		  						  .setSubText("kr. 2000")
		  						  .setBGColor(new Color(255, 110, 0))//custom Orange
		  						  .build();
		
		this.fields[9] = new FieldPanel.Builder()
		  						  .setTitle("Allégade")
		  						  .setSubText("kr. 2400")
		  						  .setBGColor(new Color(255, 110, 0))//custom Orange
		  						  .build();
		
		this.fields[10] = new FieldPanel.Builder()
		  						  .setTitle("Fængsel")
		  						  .setSubText("På Besøg")
		  						  .setPicture(Builder.JAIL)
		  						  .build();
		
		this.fields[11] = new FieldPanel.Builder()
								  .setTitle("Frederiksberg Allé")
								  .setSubText("kr. 2800")
								  .setBGColor(Color.GREEN)
								  .build();
		this.fields[12] = new FieldPanel.Builder()
								  .setTitle("Tuborg")
								  .setSubText("kr. 3000")
								  .setPicture(Builder.BREWERY1)
								  .build();
		this.fields[13] = new FieldPanel.Builder()
								  .setTitle("Bülowsvej")
								  .setSubText("kr. 2800")
								  .setBGColor(Color.GREEN)
								  .build();
		this.fields[14] = new FieldPanel.Builder()
								  .setTitle("Gl. Kongevej")
								  .setSubText("kr. 3200")
								  .setBGColor(Color.GREEN)
								  .build();
		this.fields[15] = new FieldPanel.Builder()
								  .setTitle("Mols Linien")
								  .setSubText("kr. 4000")
								  .setPicture(Builder.FERRY2)
								  .build();
		this.fields[16] = new FieldPanel.Builder()
								  .setTitle("Bernstoftsvej")
								  .setSubText("kr. 3600")
								  .setBGColor(Color.LIGHT_GRAY)
								  .build();
		this.fields[17] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		this.fields[18] = new FieldPanel.Builder()
								  .setTitle("Hellerupvej")
								  .setSubText("kr. 3600")
								  .setBGColor(Color.LIGHT_GRAY)
								  .build();
		this.fields[19] = new FieldPanel.Builder()
								  .setTitle("Strandvejen")
								  .setSubText("kr. 4000")
								  .setBGColor(Color.LIGHT_GRAY)
								  .build();
		this.fields[20] = new FieldPanel.Builder()
								  .setTitle("Helle")
								  .setSubText("Helle")
								  .setPicture(Builder.CONES)
								  .build();
		this.fields[21] = new FieldPanel.Builder()
								  .setTitle("------------------------------------------------------------------------------")
								  .setSubText("kr. 2800")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[22] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		this.fields[23] = new FieldPanel.Builder()
								  .setTitle("------------------------------------------------------------------------------")
								  .setSubText("kr. 2800")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[24] = new FieldPanel.Builder()
								  .setTitle("------------------------------------------------------------------------------")
								  .setSubText("kr. 2800")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[25] = new FieldPanel.Builder()
								  .setTitle("ColorLine")
								  .setSubText("kr. 4000")
								  .setPicture(Builder.FERRY3)
								  .build();
		this.fields[26] = new FieldPanel.Builder()
								  .setTitle("Bredgade")
								  .setSubText("kr. 5200")
								  .setBGColor(Color.WHITE)
								  .build();
		this.fields[27] = new FieldPanel.Builder()
								  .setTitle("Kgs. Nytorv")
								  .setSubText("kr. 5200")
								  .setBGColor(Color.WHITE)
								  .build();
		this.fields[28] = new FieldPanel.Builder()
								  .setTitle("Coca Cola")
								  .setSubText("3000")
								  .setPicture(Builder.BREWERY2)
								  .build();
		this.fields[29] = new FieldPanel.Builder()
								  .setTitle("Østergade")
								  .setSubText("kr. 5800")
								  .setBGColor(Color.WHITE)
								  .build();
		this.fields[30] = new FieldPanel.Builder()
								  .setTitle("Gå i fængsel")
								  .setSubText("gå i fængsel")
								  .setPicture(Builder.GOTOJAIL)
								  .build();
		this.fields[31] = new FieldPanel.Builder()
								  .setTitle("Amagertorv")
								  .setSubText("kr. 6000")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[32] = new FieldPanel.Builder()
								  .setTitle("VimmelSkaftet")
								  .setSubText("kr. 6000")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[33] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		this.fields[34] = new FieldPanel.Builder()
								  .setTitle("Nygade")
								  .setSubText("kr. 6400")
								  .setBGColor(Color.YELLOW)
								  .build();
		this.fields[35] = new FieldPanel.Builder()
								  .setTitle("Oslo Færgen")
								  .setSubText("kr. 4000")
								  .setPicture(Builder.FERRY4)
								  .build();
		this.fields[36] = new FieldPanel.Builder()
								  .setTitle("Prøv Lykken")
								  .setSubText("Prøv Lykken")
								  .setPicture(Builder.PRØVLYKKEN)
								  .build();
		this.fields[37] = new FieldPanel.Builder()
								  .setTitle("Frederiksberg gade")
								  .setSubText("kr. 7000")
								  .setBGColor(new Color(211, 0, 104)) //custom purple
								  .build();
		this.fields[38] = new FieldPanel.Builder()
								  .setTitle("Extraordinær skat")
								  .setSubText("betal 2000")
								  .build();
		this.fields[39] = new FieldPanel.Builder()
								  .setTitle("Rådhuspladsen")
								  .setSubText("kr. 8000")
								  .setBGColor(new Color(211, 0, 104)) //custom purple
								  .build();
		
		setupFields(this.fields);
	}
	
	//custom board generator
	protected void setupFields(FieldPanel[] fields)
	{
		this.fields = fields;
		
		for (int i = 0; i < fields.length; i++)
		{
			this.add(fields[i]);
			fields[i].setVisible(true);
		}
	}
	
	
	
}
