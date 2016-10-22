package fellowship.abilities.attacking;

import fellowship.characters.BaseCharacter;
import fellowship.abilities.Ability;
import fellowship.events.Events;
import fellowship.events.SliceEvent;

public class Reflexive implements Ability {
    @Override
    public void apply(BaseCharacter character) {
        Ability.addCooldown(3, character, Events.Death, event -> {
            character.slice(((SliceEvent)event).getSlicer());
        });
    }
}
