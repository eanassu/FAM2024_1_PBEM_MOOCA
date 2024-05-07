package br.com.vemprafam.logica;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

public class LogicaBusca implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		Aluno a = dao.buscarPeloRa(ra);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataS = dateFormat.format(a.getDataNascimento());
		request.setAttribute("ra", a.getRa());
		request.setAttribute("nome", a.getNome());
		request.setAttribute("dataNascimento", dataS);
		request.setAttribute("renda", a.getRenda());
		return "alterar.jsp";
	}

}
