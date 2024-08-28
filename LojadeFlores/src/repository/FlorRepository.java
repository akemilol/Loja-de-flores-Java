package repository;

import models.Flor;
import java.util.ArrayList;
import java.util.List;


public class FlorRepository implements CrudRepository {
    private List<Flor>  flores = new ArrayList<>();

    @Override
    public void cadastrar(Flor flor) {
        flores.add(flor);
    }

    @Override
    public List<Flor> listar() {
        return flores;
    }

    @Override
    public Flor consultarPorCodigo(int codigo) {
        for (Flor flor : flores) {
            if (flor.getCodigo() == codigo) {
                return flor;
            }
        }
        return null;
    }


}
