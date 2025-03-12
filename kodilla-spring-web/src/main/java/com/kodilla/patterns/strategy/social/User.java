package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public class User {
    private final String username;
    protected SocialPublisher socialPublisher;

    public User(String username) {
        this.username = username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
