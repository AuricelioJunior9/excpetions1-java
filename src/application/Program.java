package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		try{
			System.out.print("Número do quarto: ");
			Integer numQuarto = sc.nextInt();
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do check-out: (dd/MM/yyyy): ");
			Date dataCheckOut = sdf.parse(sc.next());
			
				
			Reserva reserva = new Reserva(numQuarto, dataCheckIn, dataCheckOut);  
		    System.out.println("Reserva: " + reserva); 
		    System.out.println();
		    System.out.println("Insira dados para atualizar a reserva ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do check-out: (dd/MM/yyyy): ");
			dataCheckOut = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(dataCheckIn, dataCheckOut);
			System.out.println("Reserva: " + reserva); 
		}
		catch(ParseException e){
			System.out.println("Formato da data inválido");
		}catch(DomainException e) {
			System.out.println( e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado ");
		}
			
	    
		
		sc.close();
	}

}
