package fellowship.actions.stats;

import fellowship.characters.BaseCharacter;
import fellowship.actions.CharacterAction;
import fellowship.Stat;
import fellowship.events.Event;
import fellowship.events.Events;


public class Werewolf extends CharacterAction {

    public Werewolf(BaseCharacter character) {
        super(character);
    }

    @Override
    public void perform() {
        for (Stat type : Stat.values()) {
            character.addStat(type, 10);
        }
        character.on(Events.TurnStart, Event.after(10, t -> {
                    for (Stat type : Stat.values()) {
                        character.addStat(type, -10);
                    }
                }
        ));
    }

    @Override
    public int getManaCost() {
        return 30;
    }

    @Override
    public int getCooldown() {
        return 25;
    }
}
