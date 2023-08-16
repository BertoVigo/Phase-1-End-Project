package MainClass;

import java.io.IOException;
import java.util.Scanner;

import BusinessLogic.BusinessLogicRun;
import CustomException.CheckedExceptionForBusiness;

public class MainClassLogic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch = null;
		String ch2 = null;
		BusinessLogicRun bl=new BusinessLogicRun();
		System.out.println("********************************************************************************");
		System.out.println("*         Welcome To Lockers Pvt. Ltd. File user and manager.                  *");
		System.out.println("*                                                                              *");
		System.out.println("*      Developer:  Roberto Domínguez - bertodominguez@gmail.com                *");
		System.out.println("*                                                                              *");
		System.out.println("********************************************************************************");
		do {
			System.out.println(" Select one of the following options:                            ");
			System.out.println();
			System.out.println("  Option 1 -> View all the files in the folder in ascending order");
			System.out.println();
			System.out.println("  Option 2 -> Advanced options                                   ");
			System.out.println();
			System.out.println("  Option 3 -> QUIT                                               ");
			System.out.println();
				ch = sc.nextLine();
			switch (ch) {
			case "1":
					bl.retrieveFiles();
					System.out.println();
					break;
			case "2":
				do {
					System.out.println();
					System.out.println(" Select one of the following options:                   ");
					System.out.println();
					System.out.println("  Option 1 - Add a File to the Application              ");
					System.out.println();
					System.out.println("  Option 2 - Delete a File From the Application         ");
					System.out.println();
					System.out.println("  Option 3 - Search a File From the Application         ");
					System.out.println();
					System.out.println("  Option 4 - Go Back to Main Menu                     \n");
					
						ch2 = sc.nextLine();
						
					switch(ch2) {
					case "1":
						System.out.println(" Please name the file Name to be created \n");
						String addfile = sc.nextLine();
						try {
							bl.addFile(addfile);
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						continue;
					case "2":
						System.out.println(" Please input the file Name to be deleted \n");
						String deletefile = sc.nextLine();
						try {
							bl.deleteFile(deletefile);
						} catch (CheckedExceptionForBusiness e) {
							System.out.println(e.getMessage());;
						}
						continue;
					case "3":
						System.out.println(" Please input the file Name to be searched \n");
						String searchfile = sc.nextLine();
						 bl.searchFile(searchfile);
						 continue;
						
					case "4":System.out.println(" Going Back to Main Menu \n");
							break;
							
					default:System.out.println(" Error! Choice should be between 1 to 4 ");
							continue;
					}
					break;
				}while(ch2 != "4");
				break;
			case "3":
				System.out.println("\n Thank you for using our application. Bye!!\n");
				System.exit(0);
			
			default:System.out.println(" Error! Choice should be between 1 to 3 ");
				System.out.println();
			break;
			}
		} while (ch != "3");

	}

}
