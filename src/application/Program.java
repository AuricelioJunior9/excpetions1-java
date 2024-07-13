package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		Integer numQuarto = sc.nextInt();
		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date dataCheckIn = sdf.parse(sc.next());
		System.out.print("Data do check-out: (dd/MM/yyyy): ");
		Date dataCheckOut = sdf.parse(sc.next());
		
		if(!dataCheckOut.after(dataCheckIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
	    }else {
	    	Reserva reserva = new Reserva(numQuarto, dataCheckIn, dataCheckOut);  
	    	System.out.println("Reserva: " + reserva); 
	    	System.out.println();
	    	System.out.println("Insira dados para atualizar a reserva ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			dataCheckIn = sdf.parse(sc.next());
			System.out.print("Data do check-out: (dd/MM/yyyy): ");
			dataCheckOut = sdf.parse(sc.next());
		
			
			Date now = new Date();
			if(dataCheckIn.before(now) || dataCheckOut.before(now)  ) {
				System.out.println("Erro na reserva: as datas de reserva para atualização devem ser futuras ");
			}else if(!dataCheckOut.after(dataCheckIn)){
				System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
			}else {
				reserva.atualizacaoDatas(dataCheckIn, dataCheckOut);
				System.out.println("Reserva: " + reserva); 
			}
	    }
		
		sc.close();
	}

}
