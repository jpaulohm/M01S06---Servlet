package tech.devinhouse.m01s06servlet.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.devinhouse.m01s06servlet.model.Pessoa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/pessoa")
public class PessoaServlet extends HttpServlet {

    List<Pessoa> pessoaList = new ArrayList<Pessoa>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(pessoaList);
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        Integer idade = Integer.parseInt(req.getParameter("idade"));

        pessoaList.add(new Pessoa(idade,nome));
        System.out.println("doPost - " + pessoaList.get(pessoaList.size()-1));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer index = Integer.parseInt(req.getParameter("index"));

        if (pessoaList.size()<index && index>=0){
            pessoaList.remove(index);
            System.out.println("doDelete " + index + "feito");
            resp.getWriter().println("doDelete " + index + "feito");

            return;
        }
        resp.getWriter().println("Nao pode dar doDelete em " + index + " pois não existe");
        System.out.println("Nao pode dar doDelete em " + index + " pois não existe");
        return;
    }
}


