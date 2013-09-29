package br.com.truefriends.persistencia;

import javax.persistence.EntityManager;

import br.com.truefriends.modelo.Usuario;


public class UsuarioDAO {

private final EntityManager em;

public UsuarioDAO(EntityManager em){
	this.em=em;
}

//Persiste o novo usuario do facebook
public void persisteUsuario(Usuario usuario){
	em.getTransaction().begin();
	em.persist(usuario);
    em.getTransaction().commit();
}


}
