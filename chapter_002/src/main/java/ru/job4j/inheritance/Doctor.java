package ru.job4j.inheritance;
/**
 * Class doctor
 * @author Andrei Pashchenko.
 * @version 1
 * @since 15.02.2019
 */
public class Doctor extends Profession {
    /**
     * Healing the patient.
     * @param patient  Patient.
     * @return Diagnose.
     */
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();

        return diagnose;
    }
}
