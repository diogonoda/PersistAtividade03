package br.com.atividade03.programa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.atividade03.dao.GenericDao;
import br.com.atividade03.entity.Clientes;

public class testar {

	public static void main(String[] args) {

		//JpaUtil jpaUtil = new JpaUtil(); // como sabe quem ser� persistido?
		
		// conforme modelo comentado abaixo passo por par�metro a unidade que
		// ser� persistida = PersistAtividade03,

		 EntityManagerFactory entityManagerFactory =
		 Persistence.createEntityManagerFactory("PersistAtividade03");
		 EntityManager em = entityManagerFactory.createEntityManager();
		 
System.out.println("debug 1");

		GenericDao dao = GenericDao(); // como instancia essa classe ?

System.out.println("debug 2");
		
		// alimenta objeto cliente para novo cadastro
		Clientes clientes = new Clientes();
		clientes.setNome("Silas Ianez");
		clientes.setEmail("silas@gmail.com");
		
System.out.println("debug 3");

		dao.adicionar(clientes);
		
System.out.println("debug 4");

		// Recuperar clientes
		List<Clientes> lisclientes = dao.listar();
		for (Clientes cliente : lisclientes) {
			System.out.println(cliente.getNome() + " - " + cliente.getEmail());
		}

		// atualizar
		// como sabe qual atualizar? devo setar alguma informa��o
		// clientes.setNome("Silas Ianez") e ser� feito o merge?;
		dao.atualizar(clientes);

		// remove
		// como sabe qual remover?
		dao.remover(clientes);

		// Busca cliente pelo ID
		Clientes x = new Clientes();
		x = (Clientes) dao.buscar(1);
		System.out.println(x.getIdcliente() + " - " + x.getNome());

	}

	private static GenericDao GenericDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
