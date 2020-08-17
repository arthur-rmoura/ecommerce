package io.github.arthurrmoura.dao.util;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe de uso genérica para o persistência usando o Hibernate
 * @author Vários Autores
 * @param <T>
 **/

public abstract class GenericDAO<T> {
	
	//@PersistenceContext(unitName = "EcommercePU")
	@Autowired
	protected EntityManager entityManager;
	
	private Class<T> entity;
	
	/**
	 * Construtor da classe recebendo a entidade
	 * @param entity entidade que será recebida pelo Generic
	 */
	public GenericDAO(Class<T> entity) {
		this.entity = entity;
	}
	
	/**
	 * Método utilizado para persistir a Entidade no banco de dados
	 * @param entity Entidade que será salva
	 * @return Retorna verdadeiro caso a gravação seja feita com sucesso e false para o caso contrário
	 **/
	public boolean save(final T entity) {
		try {
			this.entityManager.persist(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Método utilizado para persistir a Entidade no banco de dados e retornar a própria entidade com o id gerado
	 * @param entity Entidade que será salva
	 * @return Retorna verdadeiro caso a gravação seja feita com sucesso e false para o caso contrário
	 * @author Glaydson
	 **/
	public T saveReturnObject(final T entity) {
		try {
			this.entityManager.persist(entity);
			this.entityManager.refresh(entity);
			this.entityManager.flush();
			return entity;
		} catch (Exception e) {
			return entity;
		}
	}
	
	/**
	 * Método utilizado para deletar a Entidade no banco de dados
	 * @param entity Entidade que será apagada
	 * @return Retorna verdadeiro caso a exclusão seja feita com sucesso e false para o caso contrário
	 **/
	public boolean delete(T entity) {
		try {
			entity = this.entityManager.merge(entity);
			this.entityManager.remove(entity);
			return true;
		} catch (Exception e) {
			/*logger.error("Erro ao excluir " + this.entity.getName() + " :" + e.getMessage());*/
			return false;
		}
	}
	
	/**
	 * Método utilizado para atualizar a Entidade no banco de dados
	 * @param entity Entidade que será atualizada
	 * @return Retorna verdadeiro caso a atualização seja feita com sucesso e false para o caso contrário
	 **/
	public boolean update(final T entity) {
		try {
			this.entityManager.merge(entity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Método utilizado para buscar todos os itens da Entidade no banco de dados paginados
	 * @param pageSize Tamanho da Página
	 * @param pageIndex Identificador da Página
	 * @return Lista de Entidades retornada pela pesquisa
	 **/
	@SuppressWarnings({ "unchecked" })
	public List<T> listAll(int pageSize, int pageIndex) {
		return entityManager.createQuery(("SELECT e FROM " + entity.getName() + " e ")).setMaxResults(pageSize).setFirstResult(pageIndex * pageSize).getResultList();
	}
	
	/**
	 * Método utilizado para buscar todos os itens Seguindo os critérios de ordenação
	 * @param orderBy Critério de order by para a pesquisa
	 * @param modo Modo de ordenação da pesquisa que pode ser ASC ou DESC
	 * @param pageSize Tamanho da Página
	 * @param pageIndex Identificador da Página
	 * @return Lista de Entidades retornada pela pesquisa
	 **/
	@SuppressWarnings({ "unchecked" })
	public List<T> listAllOrder(String orderBy, String modo, int pageSize, int pageIndex) {
		return entityManager.createQuery(("SELECT e FROM " + entity.getName() + " e order by e." + orderBy + " " + modo)).setMaxResults(pageSize).setFirstResult(pageIndex * pageSize).getResultList();
	}
	
	/**
	 * Método utilizado para buscar uma Entidade no banco de dados pelo seu ID Inteiro
	 * @param id ID da Entidade
	 * @return Entidade
	 **/
	public T findbyId(Integer id) {
		return entityManager.find(entity, id);
	}
	
	/**
	 * Método utilizado para buscar uma Entidade no banco de dados pelo seu ID Long
	 * @param id ID da Entidade
	 * @return Entidade
	 **/
	public T findbyId(Long id) {
		return entityManager.find(entity, id);
	}
	
	/**
	 * Método utilizado para buscar uma Entidade no banco de dados pelo seu ID UUID
	 * @param id ID da Entidade
	 * @return Entidade
	 **/
	public T findbyId(UUID id) {
		return entityManager.find(entity, id);
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public List<T> listEntityFilter(String sql, Map<String, Object> parameters) {
		Query query = null;
		query = entityManager.createQuery(sql);
		for (String nomeParametro : parameters.keySet())
			if (parameters.get(nomeParametro) instanceof Date)
				query.setParameter(nomeParametro, (Date) parameters.get(nomeParametro), TemporalType.DATE);
			else
				query.setParameter(nomeParametro, parameters.get(nomeParametro));
		return query.getResultList();
	}
	
	/**
	 * Método utilizado para buscar todos os itens de acordo com o SQL paginado
	 * @param Query em JPQ que será usada para a busca
	 * @param pageSize Tamanho da Página
	 * @param pageIndex Identificador da Página
	 * @return Lista de Entidades retornada pela pesquisa
	 **/
	@SuppressWarnings({ "unchecked" })
	public List<T> listAll(String qry, Map<String, Object> parameters, int pageSize, int pageIndex) {
		Query query = null;
		query = entityManager.createQuery(qry);
		for (String nomeParametro : parameters.keySet())
			if (parameters.get(nomeParametro) instanceof Date)
				query.setParameter(nomeParametro, (Date) parameters.get(nomeParametro), TemporalType.DATE);
			else
				query.setParameter(nomeParametro, parameters.get(nomeParametro));
		return query.setMaxResults(pageSize).setFirstResult(pageIndex * pageSize).getResultList();
	}
}
