package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.BootstrapServiceRegistryImpl;


public class BibliotecaMetodos {
	
	public static boolean isStringValida(String pString) {
		boolean resposta = false;
		
		if ( pString != null && pString.trim().length() > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isObjetoValido(Object pObjeto) {
		boolean resposta = false;
		
		if ( pObjeto instanceof String ) {
			if ( isStringValida((String) pObjeto) ) {
				resposta = true;
			}
		} else {
			if ( pObjeto != null ) {
				resposta = true;
			}
		}
		
		return resposta;
	}
	
	public static boolean isDataValida(String pData) {
		boolean resposta = false;
		
		if ( isStringValida(pData) ) {
			try {
				new SimpleDateFormat("dd/MM/yyyy").parse(pData);
				resposta = true;
			} catch (ParseException e) {
				resposta = false;
				e.printStackTrace();
			}
		}
		
		return resposta;
	}
	public static Date getData(String pData) {
		Date data = null;
		
		if ( isDataValida(pData) ) {
			try {
				data = new SimpleDateFormat("dd/MM/yyyy").parse(pData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static boolean isColecaoValida(Collection pColecao) {
		boolean resposta = false;
		if ( pColecao != null && !pColecao.isEmpty() ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isColecaoValida(Collection pColecao, int pIndice) {
		boolean resposta = false;
		
		if ( isColecaoValida(pColecao) && pColecao.size() > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray) {
		boolean resposta = false;
		if ( pArray != null && pArray.length > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray, int pIndice) {
		boolean resposta = false;
		
		if ( isArrayValido(pArray) && pArray.length > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	
	public static SessionFactory createSessionHibernate_4_2_21() {
		SessionFactory sessionFactory;
		
		ServiceRegistry registro = new BootstrapServiceRegistryImpl();
		Configuration configuracoes = new Configuration().configure("/META-ING/hibernate.cfg.xml");
		sessionFactory = configuracoes.buildSessionFactory(registro);
		
		return sessionFactory;
		
		//sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/*public static SessionFactory createSessionHibernate_4_3_11() {
		Configuration configuracoes = new Configuration().configure("/META-INF/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuracoes.getProperties());
		ServiceRegistry registro = builder.build();
		SessionFactory factory = configuracoes.buildSessionFactory(registro);
		return factory;
	}*/
	
	public static String getBooleanComoSimOuNao(boolean pBoolean) {
		String resposta = "Não";
		if ( pBoolean ) {
			resposta = "Sim";
		}
		
		return resposta;
	}
	
	public static boolean isStringNao(String pString) {
		boolean resposta = false;
		if ( pString.equalsIgnoreCase("Não") || pString.equalsIgnoreCase("Nao") ) {
			resposta = true;
		}
		return resposta;
	}
	
	public static boolean isStringSim(String pString) {
		boolean resposta = false;
		if ( pString.equalsIgnoreCase("Sim") ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isCPFvalido(String pCPF) {
		boolean resposta = false;
		if ( isStringValida(pCPF) ) {
			Pattern padrao = Pattern.compile("[0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2}");
			Matcher matcher = padrao.matcher(pCPF);
			
			resposta = matcher.matches();
		}
		
		return resposta;
	}
	
	public static boolean isEmailValido( String pEmail ) {
		boolean resposta = false;
		
		if ( isStringValida(pEmail) ) {
			Pattern padrao = Pattern.compile("([a-z]|[A-Z]\\d{3,})[@]([a-z]|[A-Z]{3,})[\\.])([a-z]|[A-Z]{2,})");
			Matcher matcher = padrao.matcher(pEmail);
			
			resposta = matcher.matches();
		}
		
		return resposta;
	}
	
}