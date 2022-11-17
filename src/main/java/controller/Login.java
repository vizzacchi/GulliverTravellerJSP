package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataSource;
import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String pagina = "";

            //System.out.println(email);
            //System.out.println(senha);
            
            Usuario user = this.buscarUsuario(email, senha);
            if(user != null) {
                request.getSession().setAttribute("Usuario", user);
                pagina = "/home.jsp";
                System.out.println("Usuário logado com sucesso");
            } else {
                pagina = "/erro.jsp";
                request.setAttribute("ErroMSG", "Usuário não encontrado");
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("Erro ao chamar login: " + e.getMessage());
        }
    }
    
    //EFETIVA O LOGIN
    private Usuario buscarUsuario(String email, String senha) {
        DataSource dataSource = new DataSource();
        UsuarioDao usuarioDao = new UsuarioDao(dataSource);
        
        Usuario retorno = usuarioDao.getByEmailSenha(email, senha);
        return retorno;
    }
}