package br.com.caelum.argentum.modelo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.reader.LeitorXML;
import junit.framework.Assert;

public class LeitorXMLTest {

	//---------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	@Test
	public void carregaXMLComUmaNegociacaoEmUmaListaUnitaria() {
		String xmlDeTeste = "<list> "
				+ "<negociacao> "
				+ "<preco>43.5</preco>"
				+ "<quantidade>1000</quantidade>"
				+ "<data><time>1322233344455</time></data>"
				+ "</negociacao>"
				+ "</list>";

		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(true, negociacoes.size() == 1);
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco(), 0.00001);
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade(), 0.00001);
	}
	//---------------------------------------------------------------------------------------------
	
//  finalizar o exercício opcional 7, página 68	
//	public void verificarCasosExcepcionais(){
//		
//	}
}
