package it.unisa.SMS;

import java.util.GregorianCalendar;

public class SMS {
  private final String mittente;
  private final GregorianCalendar data;
  private final int id;
  private static int totSMS=0;
  private final String text;

  public SMS(String mittente, GregorianCalendar calendar, String text){
    this.mittente=mittente;
    this.data=calendar;
    this.id=totSMS;
    totSMS++;
    this.text=text;
  }

  public GregorianCalendar getData(){
    return data;
  }

  public String getSender(){
    return mittente;
  }

  public String getText(){
    return text;
  }

  public int getTotalNumberSMS(){
    return totSMS;
  }

  public GregorianCalendar getDate(){
    return data;
  }
}