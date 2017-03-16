package awk.datenverwaltung.usecase;


import awk.persistence.entity.Strategiekarte;
import awk.persistence.entity.Umgebungskarte;

import java.util.List;

public interface IKarteSuchen
{
    List<Strategiekarte> showMarineStrategiekarten(int id);
    List<Strategiekarte> showAlienStrategiekarten(int id);
    List<Strategiekarte> showPredStrategiekarten(int id);

    List<Umgebungskarte> showUmgebungskarten(int id);

    List<Strategiekarte> showStrategiekarten(String name);
    List<Umgebungskarte> showUmgebungskarten(String name);
}
