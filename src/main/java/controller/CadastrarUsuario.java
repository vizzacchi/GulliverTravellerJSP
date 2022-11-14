package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.UsuarioDao;
import model.Perfil;
import model.Usuario;

@WebServlet("/cadastrar_usuario")
public class CadastrarUsuario extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String pagina = "";
        
        try {
            Usuario usuario = new Usuario();
            
            //PERFIL
            Perfil perfil = new Perfil();
            perfil.setId(1);
            usuario.setPerfil(perfil);
            
            //USUÁRIO
            usuario.setNome(request.getParameter("usuario"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setAtivo(1);

            //REALIZA O CADASTRO
            DataSource dataSource = new DataSource();
            UsuarioDao usuarioDao = new UsuarioDao(dataSource);
            usuarioDao.create(usuario);
            dataSource.getConnection().close();
            
            pagina = "/sucesso.jsp";
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("ErroMSG", "Erro ao cadastrar usuário.");
            e.printStackTrace();
            
            pagina = "/erro.jsp";
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }
    }
}