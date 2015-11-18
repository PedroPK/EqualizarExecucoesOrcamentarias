package web.jsf.mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import io.ProcessarArquivoSaidaJobConferenciaExecucoesOrcamentarias;

@ManagedBean
@SessionScoped
public class ArquivoJobConferenciaMB {
	
	private Part aArquivo;
	
	public Part getArquivo() {
		return aArquivo;
	}
	
	public void setArquivo(Part aArquivoJobConferenciaExecucoesOrcamentarias) {
		this.aArquivo = aArquivoJobConferenciaExecucoesOrcamentarias;
	}
	
	public void enviarArquivo() {
		if ( this.aArquivo != null ) {
			try {
				ProcessarArquivoSaidaJobConferenciaExecucoesOrcamentarias.processar(
					this.aArquivo.getInputStream() 
				);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}