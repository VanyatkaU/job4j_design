package ru.job4j.ood.isp;

/**
 * Пример № 3.
 * Нарушение принципа ISP (Interface Segregation Principle),
 * Сплавы можно разделить по группам.
 */

public interface Alloys {

    void bronze();

    void brass();

    void steel();

    void castIron();

    void aluminum();

}

/**interface CopperAlloys {

    void bronze();

    void brass();
}

interface BlackAlloys {

    void steel();

    void castIron();
}

interface AluminumAlloys {

    void foundryAluminum();

    void deformableAluminum();
}*/
