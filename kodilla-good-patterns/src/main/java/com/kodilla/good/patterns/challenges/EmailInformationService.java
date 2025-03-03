package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements  InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Wiadomość e-mail wysłana do " + user.getEmail() + ": Zamówienie zostało przyjęte.");
    }
}

