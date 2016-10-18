package parades.mananciais.model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void test() {

		Calculadora calculadora = new Calculadora();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		
		try {
			Medicao medicao1 = new Medicao(100, sdf.parse("01/09/2016"));
			Medicao medicao2 = new Medicao(105, sdf.parse("03/09/2016"));
			Medicao medicao3 = new Medicao(100, sdf.parse("04/09/2016"));
			Medicao medicao4 = new Medicao(110, sdf.parse("05/09/2016"));
			Medicao medicao5 = new Medicao(107, sdf.parse("06/09/2016"));
			Medicao medicao6 = new Medicao(115, sdf.parse("10/09/2016"));
			Medicao medicao7 = new Medicao(120, sdf.parse("12/09/2016"));
			Medicao medicao8 = new Medicao(150, sdf.parse("19/09/2016"));
		
			ArrayList<Medicao> medicoes1 = new ArrayList<Medicao>();
			medicoes1.add(medicao1);
			medicoes1.add(medicao2);
			medicoes1.add(medicao3);
			medicoes1.add(medicao4);
			medicoes1.add(medicao5);
	
			
			Represa represa1 = new Represa("Represa A", medicoes1);

			ArrayList<Medicao> medicoes2 = new ArrayList<Medicao>();

			medicoes2.add(medicao1);
			medicoes2.add(medicao2);
			medicoes2.add(medicao3);
			medicoes2.add(medicao4);
			medicoes2.add(medicao5);
			medicoes2.add(medicao6);
			medicoes2.add(medicao7);
			medicoes2.add(medicao8);
			
			Represa represa2 = new Represa("Represa B", medicoes2);
			
			ArrayList<Represa> represas = new ArrayList<Represa>();
			represas.add(represa1);
			represas.add(represa2);
					
			Sistema sistema = new Sistema("Sistema Cantareira", represas);
			
			String retorno = "Relatório do Sistema Sistema Cantareira\n\n\tRepresa: Represa A\n      Data       Volume Variação Diária\n01/01/2016       100,00            0,00\n03/01/2016       105,00            5,00\n04/01/2016       100,00           -4,76\n05/01/2016       110,00           10,00\n06/01/2016       107,00           -2,73\n------------------------------------------------\nVariação Total da Represa:         7,00\n\n\tRepresa: Represa B\n      Data       Volume Variação Diária\n01/01/2016       100,00            0,00\n03/01/2016       105,00            5,00\n04/01/2016       100,00           -4,76\n05/01/2016       110,00           10,00\n06/01/2016       107,00           -2,73\n10/01/2016       115,00            7,48\n12/01/2016       120,00            4,35\n19/01/2016       150,00           25,00\n------------------------------------------------\nVariação Total da Represa:        50,00\n\n------------------------------------------------\nVariação Total do Sistema:        28,50\n\n";
			
			assertEquals("relatorio ", calculadora.gerarRelatorioMensal(sistema , null), retorno);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
