package br.com.caelum.banco;

public class TestaString {
	public static void main(String[] args) {
		String s = "fj1  1";
		s.replaceAll("1", "2");
		System.out.println(s);

		// \s = Anything that is a space character (including space, tab characters etc)
		//String teste = s.replaceAll("1", "2").replaceAll("\\s","");
		
		String teste = s.replaceAll("1", "2").trim();

		if (!teste.isEmpty()) {
			System.out.println(teste);
			System.out.println(teste.length());
		}
	}
}