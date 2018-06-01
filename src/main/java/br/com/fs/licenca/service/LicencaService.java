package br.com.fs.licenca.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.fs.licenca.dto.UsuarioDTO;

@Service
public class LicencaService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LicencaService.class);

	public List<UsuarioDTO> obtemLicenca(List<UsuarioDTO> usuariosDTO) {
		usuariosDTO.forEach(usuario -> {
			try {
				usuario.setLicenca(generateKey());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		});

		return usuariosDTO;
	}

	private String generateKey() throws NoSuchAlgorithmException {
		SecretKey secretKey = null;
		try {
			secretKey = KeyGenerator.getInstance("AES").generateKey();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Erro ao criar algoritmo.");
			throw new NoSuchAlgorithmException("Impossivel gerar algoritmo do cd-key", e.getCause());
		}
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}

}
