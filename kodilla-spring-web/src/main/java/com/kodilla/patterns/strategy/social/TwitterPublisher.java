package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {

    public String share() {
        System.out.println("Twitter publisher");
        return "Twitter";
    }
}
