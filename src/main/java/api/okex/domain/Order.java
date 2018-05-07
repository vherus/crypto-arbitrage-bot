package api.okex.domain;

import api.DomainEntity;

public class Order implements DomainEntity {
    private Integer id;

    public Order(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
