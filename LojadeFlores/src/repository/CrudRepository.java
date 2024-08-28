package repository;

import models.Flor;
import java.util.List;

public interface CrudRepository {
    void cadastrar(Flor flor);
    List<Flor> listar();
    Flor consultarPorCodigo(int codigo);
    // Adicione outros métodos para consultar, alterar e excluir conforme necessário
}
