package models;

public class Rule {
    private long id;
    private InnerRule[] rules;

    public Rule(InnerRule[] rules) {
        this.rules = rules;
    }
    public Rule() { };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InnerRule[] getRules() {
        return rules;
    }

    public void setRules(InnerRule[] rules) {
        this.rules = rules;
    }
}
