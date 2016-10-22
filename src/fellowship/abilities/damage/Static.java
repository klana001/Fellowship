package fellowship.abilities.damage;

import fellowship.characters.BaseCharacter;
import fellowship.abilities.CharacterAbility;
import fellowship.events.Event;
import fellowship.events.Events;

public class Static implements CharacterAbility {

    @Override
    public void apply(BaseCharacter character) {
        character.on(Events.TurnStart, Event.forever(i -> {
            character.enemyCharacters(1).forEach(c -> c.damage(5));
        }));
    }

    @Override
    public boolean repeatable() {
        return true;
    }
}
