package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Erro na reserva: a data de check-out deve ser posterior à data de check-in") ;
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date dataCheckIn, Date dataCheckOut)  {
		// trrows -> o método pode lançar um exceção
		Date now = new Date();
		if(dataCheckIn.before(now) || dataCheckOut.before(now)) {
			throw new DomainException("Erro na reserva: as datas de reserva para atualização devem ser futuras ") ;
		}
		if(!dataCheckOut.after(dataCheckIn)) {
			throw new DomainException("Erro na reserva: a data de check-out deve ser posterior à data de check-in") ;
		}
		this.checkIn = dataCheckIn;
		this.checkOut = dataCheckOut;
		
	}

	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " noites";
	}
	
	
}










