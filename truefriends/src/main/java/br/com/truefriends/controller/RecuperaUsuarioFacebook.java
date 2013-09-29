package br.com.truefriends.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.truefriends.service.UsuarioServico;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;


@WebServlet("/RecuperaUsuarioFacebook")
public class RecuperaUsuarioFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public RecuperaUsuarioFacebook() {
      
    }

   
  protected void inicia(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   
	   FacebookClient facebookCliente = new DefaultFacebookClient(request.getParameter("token"));
	   User facebookUser = facebookCliente.fetchObject("me", User.class);
	   Connection<User> friends = facebookCliente.fetchConnection("me/friends", User.class);
	   
	   
	   UsuarioServico usuarioServico = new UsuarioServico();
	   usuarioServico.persisteUsuarioServico(facebookUser);
   }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

}
