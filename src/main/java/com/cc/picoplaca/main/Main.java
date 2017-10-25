/**
 * 
 */
package com.cc.picoplaca.main;

import java.util.Scanner;

import com.cc.picoplaca.beans.PicoPlacaBean;
import com.cc.picoplaca.service.PicoPlacaService;
import com.cc.picoplaca.service.impl.PicoPlacaServiceImpl;

/**
 * @author ccarrillo
 *
 */
public class Main {
	
	public static void main (String[] args) {
		PicoPlacaService service = new PicoPlacaServiceImpl();
		System.out.println("Enter your car ID (Ex: PCB3010): " );
		Scanner in = new Scanner(System.in);
		String id = in.nextLine().trim();
		
		if (!service.isValidId(id)) {
			System.out.println("Invalid car ID. Please enter it again");
			in.close();
			return;
		}
		
		System.out.println("Enter a date (dd/MM/yyyy): " );
		String date = in.nextLine().trim();
		
		System.out.println("Enter a time (hh:mm): " );
		String time = in.nextLine().trim();
		
		if (in != null) {
			in.close();
		}
		
		PicoPlacaBean bean = new PicoPlacaBean(id, date, time);
		
		if (service.isAbleToBeOnRoad(bean)) {
			System.out.println("Your car can be on the road");
		} else {
			System.out.println("Your car can NOT be on the road");
		}
	}
}
