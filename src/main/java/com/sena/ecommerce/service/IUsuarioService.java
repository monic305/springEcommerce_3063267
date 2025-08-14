package com.sena.ecommerce.service;

import java.util.List;
import java.util.optional;

package com.sena.ecommerce.service;


public interface IUsuarioService {
	public Usuario save(Usuario usuario);
	
	public Optional<Usuario> get(Integer id);
		
	public void update (Usuario usuario);
	
	public void  delete(Integer usuario);

}
