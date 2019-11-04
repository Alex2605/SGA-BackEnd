package com.clube.sga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clube.sga.domain.Associado;
import com.clube.sga.domain.EstadoCivil;
import com.clube.sga.domain.TipoAssociado;
import com.clube.sga.domain.UF;
import com.clube.sga.service.AssociadoService;

@Controller
@RequestMapping("/associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
//	@Autowired
//	private CargoService cargoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Associado associado) {
		return "associado/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("associados", associadoService.buscarTodos());
		return "associado/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Associado associado, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "associado/cadastro";
		}
		
		associadoService.salvar(associado);
		attr.addFlashAttribute("success", "Associado inserido com sucesso.");
		return "redirect:/associados/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("associado", associadoService.buscarPorId(id));
		return "associado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Associado associado, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "associado/cadastro";
		}
		
		associadoService.editar(associado);
		attr.addFlashAttribute("success", "Associado editado com sucesso.");
		return "redirect:/associados/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		associadoService.excluir(id);
		attr.addFlashAttribute("success", "Associado removido com sucesso.");
		return "redirect:/associados/listar";
	}	

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("tipoAssociados")
	public TipoAssociado[] getTipoAssociado() {
		return TipoAssociado.values();
	}

	@ModelAttribute("estadoCivis")
	public EstadoCivil[] getEstadoCivis() {
		return EstadoCivil.values();
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("associados", associadoService.buscarPorNome(nome));
		return "associado/lista";
	}

	@GetMapping("/buscar/cpf")
	public String getPorCPF(@RequestParam("CPF") String CPF, ModelMap model) {	
		model.addAttribute("associados", associadoService.buscarPorCPF(CPF));
		return "associado/lista";
	}

/*
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("associados", associadoService.buscarPorCargo(id));
		return "associado/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("associados", associadoService.buscarPorDatas(entrada, saida));
        return "associado/lista";
    }
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
*/	

}
