package repository;

import model.Charakteren;

import java.util.*;

public class CharakterenRepo implements IRepository<Charakteren> {

    private final List<Charakteren> charakterens = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void create(Charakteren obj) {
        obj.setId(currentId++);
        charakterens.add(obj);
    }

    @Override
    public Charakteren read(int id) {
        for (Charakteren charakteren : charakterens) {
            if (charakteren.getId() == id) {
                return charakteren;
            }
        }
        return null;
    }

    @Override
    public void update(Charakteren obj) {
        Charakteren charakteren = read(obj.getId());
        if (charakteren != null) {
            charakteren.setName(obj.getName());
            charakteren.setRegion(obj.getRegion());
            charakteren.setProducts(obj.getProducts());
        }
    }

    @Override
    public void delete(int id) {
        charakterens.removeIf(charakteren -> charakteren.getId() == id);
    }

    @Override
    public List<Charakteren> getAll() {
        return charakterens;
    }
}
