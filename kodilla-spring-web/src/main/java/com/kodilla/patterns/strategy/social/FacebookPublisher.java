package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher {
    public String share() {
        System.out.println("Facebook publisher");
        return "Facebook";
    }
}
