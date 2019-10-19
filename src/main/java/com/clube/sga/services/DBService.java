package com.clube.sga.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clube.sga.domain.Associado;
import com.clube.sga.domain.Cidade;
import com.clube.sga.domain.Dependente;
import com.clube.sga.domain.Endereco;
import com.clube.sga.domain.Estado;
import com.clube.sga.domain.Telefone;
import com.clube.sga.domain.Visitante;
import com.clube.sga.domain.enums.EstadoCivil;
import com.clube.sga.domain.enums.TipoAssociado;
import com.clube.sga.domain.enums.TipoDependente;
import com.clube.sga.domain.enums.TipoTelefone;
import com.clube.sga.repositories.CidadeRepository;
import com.clube.sga.repositories.EnderecoRepository;
import com.clube.sga.repositories.EstadoRepository;
import com.clube.sga.repositories.PessoaRepository;
import com.clube.sga.repositories.TelefoneRepository;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public void instanciateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Instancia o associado");
		
		Associado assoc3 = new Associado(null, "Tio Patinhas", "88185426058", sdf.parse("01/01/1940"), EstadoCivil.SOLTEIRO, sdf.parse("01/01/2001"), TipoAssociado.EFETIVO);
		pessoaRepository.saveAll(Arrays.asList(assoc3));
		
		Associado assoc1 = new Associado(null, "Pato Donald", "56065907782", sdf.parse("25/02/1965"), EstadoCivil.CASADO, sdf.parse("01/01/2001"), TipoAssociado.EFETIVO);
		Dependente dep1 = new Dependente(null, "Margarida", "85538059057", sdf.parse("09/04/1966"), EstadoCivil.CASADO, sdf.parse("01/01/2001"), TipoDependente.ESPOSO);
		Dependente dep2 = new Dependente(null, "Huguinho", "83263784706", sdf.parse("19/11/2002"), EstadoCivil.SOLTEIRO, sdf.parse("10/02/2002"), TipoDependente.FILHO);
		Dependente dep3 = new Dependente(null, "Zezinho", "72421894700", sdf.parse("13/06/2006"), EstadoCivil.SOLTEIRO, sdf.parse("20/10/2006"), TipoDependente.FILHO);
		Dependente dep4 = new Dependente(null, "Luizinho", "56065907782", sdf.parse("16/08/2007"), EstadoCivil.SOLTEIRO, sdf.parse("30/11/2007"), TipoDependente.FILHO);
		Visitante visi1 = new Visitante(null, "Gastão", "56065907782", sdf.parse("16/04/1975"), EstadoCivil.DIVORCIADO, sdf.parse("26/05/2012"));
		
		visi1.setAssociado(assoc1);
		dep1.setAssociado(assoc1);
		dep2.setAssociado(assoc1);
		dep3.setAssociado(assoc1);
		dep4.setAssociado(assoc1);
		
		assoc1.getDependentes().addAll(Arrays.asList(dep1,dep2,dep3,dep4));
		assoc1.getVisitantes().addAll(Arrays.asList(visi1));
		
		Telefone tel1 = new Telefone(null, "22988079945", TipoTelefone.CELULAR);
		Telefone tel2 = new Telefone(null, "2138701539", TipoTelefone.COMERCIAL);
		Telefone tel3 = new Telefone(null, "213466234", TipoTelefone.RECADO);
		Telefone tel4 = new Telefone(null, "22988261604", TipoTelefone.CELULAR);
		Telefone tel5 = new Telefone(null, "2226521099", TipoTelefone.RESIDENCIAL);
		
		Estado est1 = new Estado(null, "Rio de Janeiro");
		Cidade c1 = new Cidade(null, "Saquarema",est1);
		est1.getCidades().addAll(Arrays.asList(c1));
		
		Endereco e1 = new Endereco(null, "Rua Cento e Seis", "149", "Casa", "Jaconé", "28999044", assoc1, c1);
		assoc1.getEnderecos().addAll(Arrays.asList(e1));
		dep1.getEnderecos().addAll(Arrays.asList(e1));
		dep2.getEnderecos().addAll(Arrays.asList(e1));
		dep3.getEnderecos().addAll(Arrays.asList(e1));
		dep4.getEnderecos().addAll(Arrays.asList(e1));
		
		assoc1.getTelefones().addAll(Arrays.asList(tel1, tel2, tel3));
		dep1.getTelefones().addAll(Arrays.asList(tel4, tel5));
		assoc1.getEmails().addAll(Arrays.asList("alexanderprof@yahoo.com.br", "alequinho@gmail.com", "alexsantos.26.05@gmail.com"));
		dep1.getEmails().addAll(Arrays.asList("marjoriefabiana@yahoo.com.br"));
		
		tel1.setPessoa(assoc1);
		tel2.setPessoa(assoc1);
		tel3.setPessoa(assoc1);
		tel4.setPessoa(dep1);
		tel5.setPessoa(dep1);


		pessoaRepository.saveAll(Arrays.asList(assoc1));
		pessoaRepository.saveAll(Arrays.asList(dep1));
		pessoaRepository.saveAll(Arrays.asList(dep2));
		pessoaRepository.saveAll(Arrays.asList(dep3));
		pessoaRepository.saveAll(Arrays.asList(dep4));
		pessoaRepository.saveAll(Arrays.asList(visi1));
		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(c1));
		enderecoRepository.saveAll(Arrays.asList(e1));
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4, tel5));
		Associado assoc2 = new Associado(null, "Sr. Incrível", "72421894700", sdf.parse("01/01/1955"), EstadoCivil.CASADO, sdf.parse("01/01/2001"), TipoAssociado.EFETIVO);
		Dependente dep5 = new Dependente(null, "Mulher Elástico", "85538059057", sdf.parse("09/04/1950"), EstadoCivil.CASADO, sdf.parse("01/01/2001"), TipoDependente.ESPOSO);
		Dependente dep6 = new Dependente(null, "Violeta", "83263784706", sdf.parse("19/11/2002"), EstadoCivil.SOLTEIRO, sdf.parse("10/02/2002"), TipoDependente.FILHO);
		Dependente dep7 = new Dependente(null, "Flexa", "72421894700", sdf.parse("13/06/2006"), EstadoCivil.SOLTEIRO, sdf.parse("20/10/2006"), TipoDependente.FILHO);
		Dependente dep8 = new Dependente(null, "Zezé", "56065907782", sdf.parse("16/08/2007"), EstadoCivil.SOLTEIRO, sdf.parse("30/11/2007"), TipoDependente.FILHO);
		Visitante visi2 = new Visitante(null, "Gelado", "56065907782", sdf.parse("16/04/1975"), EstadoCivil.DIVORCIADO, sdf.parse("26/05/2012"));
		
		visi2.setAssociado(assoc2);
		dep5.setAssociado(assoc2);
		dep6.setAssociado(assoc2);
		dep7.setAssociado(assoc2);
		dep8.setAssociado(assoc2);
		
		assoc2.getDependentes().addAll(Arrays.asList(dep5,dep6,dep7,dep8));
		assoc2.getVisitantes().addAll(Arrays.asList(visi2));
		
		Telefone tel6 = new Telefone(null, "22988079945", TipoTelefone.CELULAR);
		Telefone tel7 = new Telefone(null, "2138701539", TipoTelefone.COMERCIAL);
		Telefone tel8 = new Telefone(null, "213466234", TipoTelefone.RECADO);
		Telefone tel9 = new Telefone(null, "22988261604", TipoTelefone.CELULAR);
		Telefone tel10 = new Telefone(null, "2226521099", TipoTelefone.RESIDENCIAL);
		
		Estado est2 = new Estado(null, "São Paulo");
		Cidade c2 = new Cidade(null, "Piracicaba",est2);
		est2.getCidades().addAll(Arrays.asList(c2));
		
		Endereco e2 = new Endereco(null, "Rua das Flores", "500", "Casa", "Jaconé", "28999044", assoc2, c2);
		assoc2.getEnderecos().addAll(Arrays.asList(e2));
		dep5.getEnderecos().addAll(Arrays.asList(e2));
		dep6.getEnderecos().addAll(Arrays.asList(e2));
		dep7.getEnderecos().addAll(Arrays.asList(e2));
		dep8.getEnderecos().addAll(Arrays.asList(e2));
		
		assoc2.getTelefones().addAll(Arrays.asList(tel6, tel7, tel8));
		dep5.getTelefones().addAll(Arrays.asList(tel9, tel10));
		assoc2.getEmails().addAll(Arrays.asList("alexanderprof@yahoo.com.br", "alequinho@gmail.com", "alexsantos.26.05@gmail.com"));
		dep5.getEmails().addAll(Arrays.asList("marjoriefabiana@yahoo.com.br"));
		

		pessoaRepository.saveAll(Arrays.asList(assoc2));
		pessoaRepository.saveAll(Arrays.asList(dep5));
		pessoaRepository.saveAll(Arrays.asList(dep6));
		pessoaRepository.saveAll(Arrays.asList(dep7));
		pessoaRepository.saveAll(Arrays.asList(dep8));
		pessoaRepository.saveAll(Arrays.asList(visi2));
		estadoRepository.saveAll(Arrays.asList(est2));
		cidadeRepository.saveAll(Arrays.asList(c2));
		enderecoRepository.saveAll(Arrays.asList(e2));
		telefoneRepository.saveAll(Arrays.asList(tel6, tel7, tel8, tel9, tel10));
	}
		

}
