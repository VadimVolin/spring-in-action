package spitter.data.springjdbc.springplushibernate;

import spitter.data.Spitter;

import java.util.List;

public interface SpitterDAO {

    public void addSpitter(Spitter spitter);
    public Spitter findById(int id);
    public List<Spitter> list();
    public void delete(Spitter spitter);

}
