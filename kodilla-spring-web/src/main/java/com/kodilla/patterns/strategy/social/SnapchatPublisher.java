package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher {

    public String share() {
        System.out.println("Snapchat publisher");
        return "Snapchat";
    }
}
