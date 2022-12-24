package team;

import java.util.List;
import java.util.ArrayList;

/**
 * Class which keeps a list of all the employees. 
 * @author Marten De Cock r0800075
 *
 */
public class EmployeeList {

	private List<Employee> employeeList;

	/**
	 * Constructor method of the EmployeeList class. 
	 * @param list
	 */
	public EmployeeList(List<Employee> list) {
		this.setEmployeeList(list);
	}

	/**
	 * @return a list of employees
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param list list of employees
	 */
	public void setEmployeeList(List<Employee> list) {
		this.employeeList = list;
	}
	
	/**
	 * Gets the Bioinformatician at index i.
	 * Isolates the bioinformaticians from the EmployeeList, which can then be called by saying which bioinformatician you want by giving their place in that list with i.
	 * @param i index of the BioInformatician 
	 * @return BioInformatician at index i
	 */
	public BioInformatician getBioinformatician(int i) {
		List<BioInformatician> biList = new ArrayList<>();
		
		for (Employee e : this.getEmployeeList()) {
			if (e instanceof BioInformatician) {
				biList.add(((BioInformatician) e));
			} else {
				continue;
			}
		}
		return biList.get(i);
		
	}
	
	/**
	 * Gets the TeamLead at index i.
	 * Isolates the team leaders from the EmployeeList, which can then be called by saying which team leader you want by giving their place in that list with i.
	 * @param i index of TeamLeader
	 * @return TeamLeader at index i
	 */
	public TeamLead getTeamLead(int i) {
		List<TeamLead> tlList = new ArrayList<>();
		
		for (Employee e : this.getEmployeeList()) {
			if (e instanceof TeamLead) {
				tlList.add(((TeamLead) e));
			} else {
				continue;
			}
		}
		return tlList.get(i);
		
	}
	
	/**
	 * Gets the TechnicalSupport at index i.
	 * Isolates the technical supports from the EmployeeList, which can then be called by saying which technical support you want by giving their place in that list with i.
	 * @param i index of the TechnicalSupport
	 * @return TechnicalSupport at index i
	 */
	public TechnicalSupport getTechSupportList(int i) {
		List<TechnicalSupport> tsList = new ArrayList<>();
		
		for (Employee e : this.getEmployeeList()) {
			if (e instanceof TechnicalSupport) {
				tsList.add(((TechnicalSupport) e));
			} else {
				continue;
			}
		}
		return tsList.get(i);
		
	}

	/**
	 * Prints a list of all the employees with their name, function and experience.
	 */
	public void printEmployees() {
		String newLine = System.lineSeparator();
		
		System.out.println(newLine + "### Team members:" + newLine);
		
		for (Employee e : employeeList) {
			System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
			System.out.println("Function: " + e.getFunction());
			System.out.println("Experience: " + e.getExperience() + " years" + newLine);
		}
		
		System.out.println("###" + newLine);
		
	}
	
}
