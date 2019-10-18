package com.clube.sga.managedbean;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clube.sga.domain.Associado;
import com.clube.sga.repositories.AssociadoRepository;



@Controller
public class AssociadoMB {
	@Autowired
	private AssociadoRepository repository;

	@RequestMapping("/")
	public String index(){
		System.out.println("Passo aqui");
		return "index";
	}

	
    @RequestMapping("listaassociados")
    public String listaAssociados(Model model) {
    	System.out.println("Passo aqui 02");    	
    	Iterable<Associado> associados = repository.findAll();
        model.addAttribute("associados", associados);  
        System.out.println("Retorno");
    	return "listaassociados";
   	
 }
    
    @RequestMapping("salvarassociados")
    public String salvarAssociados() {
    	return "salvarassociados";
    }
    
    @RequestMapping(value= "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("CPF") String CPF, 
                       @RequestParam("dataNascimento") String dataNascimento ) throws Exception{
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Associado novoAssociado = new Associado(nome, CPF, sdf.parse(dataNascimento));
        repository.save(novoAssociado);
        return "salvarassociados";
    }


    /*	    
	public String getlistaAssociados() {
   	System.out.println("Passo aqui 03");
   	return "Voltando a informação";
    Client c = Client.create();
    WebResource wr = c.resource("http://localhost:8080/associados/");
    String json = wr.get(String.class);
    Gson gson = new Gson();    
    return gson.fromJson(json, new TypeToken<List<Associado>>(){}.getType());
    return wr.get(String.class);
	}
	*/
}
