package com.recipe.se.recipes.infrastructure.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StorePayload {
    private Store store;

    @JsonCreator
    public StorePayload(@JsonProperty("store") Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

