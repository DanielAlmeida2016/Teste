package parades.mananciais.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Calculadora {
	DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	

	public String gerarRelatorioMensal(Sistema sistema, Date mesAno){
		boolean primeiraVez;
		double volumeAnterior;
		double variacaoDiaria;
		double variacaoRepresa;
		double variacaoSistema;
		double primeiraMedicao = 0;
		double volumeInicialSistema = 0;
		double volumeFinalSistema = 0;
		
		String relatorio = "Relatório do Sistema " + sistema.getNome() + "\n\n";
		for(Represa represa:sistema.getRepresas()){
			relatorio += "\tRepresa: " + represa.nome + "\n";
			relatorio += String.format("%10s %12s %15s","Data", "Volume", "Variação Diária\n");
			primeiraVez = true;
			volumeAnterior=0;
			for(Medicao medicao:represa.medicoes){
				if (primeiraVez){
					variacaoDiaria = 0;
					primeiraVez = false;
					primeiraMedicao = medicao.getVolume();

					// calculando o volume inicial do Sistema. Somatoria dos primeiras medicoes de cada Represa.
					volumeInicialSistema += medicao.getVolume();
				}
				else {
					// calcula variacao Diaria da Represa.
					variacaoDiaria = ((medicao.getVolume()/volumeAnterior)-1)*100;
				}
				
				relatorio += String.format("%10s %12.2f %15.2f",formater.format(medicao.getData()),
						medicao.getVolume(),variacaoDiaria);
				relatorio += "\n";
				volumeAnterior = medicao.getVolume();
			}
			
			// calculando a variacao por Represa.
			variacaoRepresa = ((volumeAnterior/primeiraMedicao)-1)*100;
			relatorio += "------------------------------------------------";
			relatorio += "\nVariação Total da Represa: " + String.format("%12.2f",variacaoRepresa);
			relatorio += "\n\n";

			// calculando volume final do Sistema. Somatorio do ultimo volume da cada represa.
			volumeFinalSistema += volumeAnterior;
			
		} 
		
		// calculando variacao total por Sistema.
		variacaoSistema = ((volumeFinalSistema/volumeInicialSistema)-1)*100;
		relatorio += "------------------------------------------------";
		relatorio += "\nVariação Total do Sistema: " + String.format("%12.2f",variacaoSistema);
		relatorio += "\n\n";

		
		return relatorio;
	}
}
