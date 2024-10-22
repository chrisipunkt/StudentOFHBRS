package org.hbrs.se1.ws24.exercises.uebung2;


public class ConcreteMember implements Member {

    private Integer id = null;

    public ConcreteMember( Integer id ){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public void setID ( Integer id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberKonkret [id=" + id + "]";
    }
}