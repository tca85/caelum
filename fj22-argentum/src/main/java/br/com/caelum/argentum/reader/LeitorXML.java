package br.com.caelum.argentum.reader;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Utiliza a biblioteca XStream
 * http://xstream.codehaus.org
 * 
 * @author tca85
 *
 */
public class LeitorXML {
	//---------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream inputStream) {
		XStream stream = new XStream(new DomDriver());

		stream.alias("negociacao", Negociacao.class);
		return (List<Negociacao>) stream.fromXML(inputStream);
	}
	//---------------------------------------------------------------------------------------------
}