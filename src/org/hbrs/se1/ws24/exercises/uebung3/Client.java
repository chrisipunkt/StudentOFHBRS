package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung2.Member;

public class Client {

    public static void main(String[] args) {
        Container container = Container.getInstance();

        try {
            Member member1 = new ConcreteMember(1);
            Member member2 = new ConcreteMember(2);

            container.addMember(member1);
            container.addMember(member2);

            MemberView view = new MemberView();
            view.dump(container.getCurrentList());

            // Persistenz testen
            container.setPersistenceStrategy(new PersistenceStrategyStream<>());
            container.store();
            container.load();
            view.dump(container.getCurrentList());

        } catch (ContainerException | PersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
