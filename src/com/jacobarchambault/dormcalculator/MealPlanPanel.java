package com.jacobarchambault.dormcalculator;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MealPlanPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox dorms; // To store dorm list
	private JComboBox meals; // To store meal plan list

	/**
	 * Constructor
	 */
	public MealPlanPanel() {
		// Create a GridLayout manager.
		setLayout(
				new GridLayout(
						2,
						2));
		// Add the labels and text fields to this panel.
		add(
				new JLabel(
						"Select a Dorm:"));
		// Create a combo box .
		dormComboBox();

		// Add the labels and text fields to this panel.
		add(
				new JLabel(
						"Select a meal plan:"));
		mealComboBox();
	}

	private void mealComboBox() {
		meals = new JComboBox();
		meals.addItem(
				"7 meals per week");
		meals.addItem(
				"14 meals per week");
		meals.addItem(
				"Unlimited meals per week");
		add(
				meals);
	}

	private void dormComboBox() {
		dorms = new JComboBox();
		dorms.addItem(
				"Allen Hall");
		dorms.addItem(
				"Pike Hall");
		dorms.addItem(
				"Farthing Hall");
		dorms.addItem(
				"University Suites");
		add(
				dorms);
	}

	public void calculateCharges() {
		double dormPrice = getSelectedDorm();
		double mealPrice = getSelectedMealPlan();
		JOptionPane.showMessageDialog(
				null,
				String.format(
						"Total charges per semester: $%,.2f",
						dormPrice + mealPrice));
	}

	private double getSelectedDorm() {
		Object selectedDorm = dorms.getSelectedItem();
		if (selectedDorm.toString()
				.contains(
						"Allen")) {
			return 1500;
		} else if (selectedDorm.toString()
				.contains(
						"Pike")) {
			return 1600;
		} else if (selectedDorm.toString()
				.contains(
						"Farthing")) {
			return 1200;
		} else {
			return 1800;
		}
	}

	private double getSelectedMealPlan() {
		Object mealPlan = meals.getSelectedItem();
		if (mealPlan.toString()
				.contains(
						"7")) {
			return 560;
		} else if (mealPlan.toString()
				.contains(
						"14")) {
			return 1095;
		} else {
			return 1500;
		}

	}
}
