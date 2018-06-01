package br.com.fs.licenca.controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fs.licenca.dto.UsuarioDTO;
import br.com.fs.licenca.service.LicencaService;

@RestController
@RequestMapping("/licenses")

public class LicencaController implements Serializable {

	@Autowired
	private LicencaService licencaService;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4566642518896523105L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LicencaController.class);

	/**
	 * Retorna uma compra por id.
	 * 
	 * @param usuariosDTO.
	 *            usuarioDTO a ser manipulado.
	 * @return retorna os usuario associados com a licença.
	 * @throws NoSuchAlgorithmException
	 *             noSuchAlgorithmException se ocorrer um erro ao gerar licenca.
	 */
	@PostMapping
	public List<UsuarioDTO> obtemLicenca(@RequestBody List<UsuarioDTO> usuariosDTO)
			throws NoSuchAlgorithmException {
		LOGGER.info("Gerando cd-key...");
		return licencaService.obtemLicenca(usuariosDTO);
	}

}
