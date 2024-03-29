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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clube.sga.domain.Dependente;
import com.clube.sga.domain.EstadoCivil;
import com.clube.sga.domain.TipoDependente;
import com.clube.sga.domain.UF;
import com.clube.sga.service.AssociadoService;
import com.clube.sga.service.DependenteService;

@Controller
@RequestMapping("/dependentes")
public class DependenteController {
	
	@Autowired
	private DependenteService dependenteService;
	@Autowired
	private AssociadoService associadoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Dependente dependente) {
		return "dependente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("dependentes", dependenteService.buscarTodos());
		return "dependente/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Dependente dependente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "dependente/cadastro";
		}
		
		dependenteService.salvar(dependente);
		attr.addFlashAttribute("success", "Dependente inserido com sucesso.");
		return "redirect:/dependentes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("dependente", dependenteService.buscarPorId(id));
		return "dependente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Dependente dependente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "dependente/cadastro";
		}
		
		dependenteService.editar(dependente);
		attr.addFlashAttribute("success", "Dependente editado com sucesso.");
		return "redirect:/dependentes/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		dependenteService.excluir(id);
		attr.addFlashAttribute("success", "Dependente removido com sucesso.");
		return "redirect:/dependentes/listar";
	}	

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("tipoDependentes")
	public TipoDependente[] getTipoDependente() {
		return TipoDependente.values();
	}

	@ModelAttribute("estadoCivis")
	public EstadoCivil[] getEstadoCivis() {
		return EstadoCivil.values();
	}
/*	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("dependentes", dependenteService.buscarPorNome(nome));
		return "dependente/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("dependentes", dependenteService.buscarPorCargo(id));
		return "dependente/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("dependentes", dependenteService.buscarPorDatas(entrada, saida));
        return "dependente/lista";
    }
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
*/	

}
