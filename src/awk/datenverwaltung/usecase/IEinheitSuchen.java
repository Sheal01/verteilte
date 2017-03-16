package awk.datenverwaltung.usecase;


import awk.persistence.entity.Alien;
import awk.persistence.entity.Marines;
import awk.persistence.entity.Predator;

import java.util.List;

public interface IEinheitSuchen
{
    List<Marines> showAllMarines();

    List<Marines> showMarinesPerID(int id);
    List<Predator> showPredatorPerID(int id);
    List<Alien> showAlienPerID(int id);

    List<Marines> getMarineNames();
    List<Predator> getPredatorNames();
    List<Alien> getAlienNames();

    List<Marines> searchMarinePerName(String name);
    List<Alien> searchAlienPerName(String name);
    List<Predator> searchPredPerName(String name);

}
