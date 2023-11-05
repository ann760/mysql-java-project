package project;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import project.entity.Project;
import project.exception.DbException;
import project.service.ProjectServices;

public class ProjectsApp {
	private Scanner scanner = new Scanner(System.in);
	private ProjectServices projectService = new ProjectServices();
	
	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project"
	);
	// @formatter:on
	
	public static void main(String[] args) {
		new ProjectsApp().processUserSelections();
	}

	private void processUserSelections() {
		boolean done = false;
		while (!done) {
			
			try {
				int selection = getUserSelecton();
				switch (selection) {
				case -1:
					done = exitMenu();
					break;
				case 1:
					createProject();
					break;
				
				default: 
					System.out.println("\n" + selection + " is not a valid selection. Try again.");
					break;
				}

			} catch (Exception e) {
				System.out.println("\nError: " + e + " Try again.");

			}
		}
	}
	
	private void createProject() {
		String projectName = getStringInput("Enter the project name");
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
		BigDecimal actualHours = getDecimalInput("Enter the actual hours");
		Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
		String notes = getStringInput("Enter the project notes");
		
		Project project = new Project();
		
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		Project dbProject = projectService.addProject(project);
		System.out.println("You have successfully created project: " + dbProject);
	}

	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return new BigDecimal(input).setScale(2);
		}
		catch(NumberFormatException e) {
			throw new DbException(input + " is not a valid decimal number.");
		}
	}

	private boolean exitMenu() {
		System.out.println("Exiting Menu");
		return true;
	}

	private int getUserSelecton() {
		printOperations();
		Integer us = getIntInput("\nEnter a menu selection");
		return Objects.isNull(us) ? -1 : us;
	}

	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number");
		}
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String line = scanner.nextLine();

		return line.isBlank() ? null : line.trim();
	}
	
	private void printOperations() {
		System.out.println();
		System.out.println("\nThese are the avaliable selections. Press the Enter key to quit:");

		operations.forEach(line -> System.out.println("   " + line));
	}

}
