package fellowship.abilities.attacking;

import fellowship.characters.BaseCharacter;
import fellowship.abilities.Ability;
import fellowship.events.Events;
import fellowship.events.SliceEvent;

public class Reflexive extends Ability {
    @Override
    public void apply(BaseCharacter character) {
        Ability.addCooldown(3, character, Events.Sliced, event -> {
            BaseCharacter slicer = ((SliceEvent)event).getSlicer();
            if (slicer.getAbilities().anySatisfy(i -> i.toString().equals("Reflexive"))){
                return;
            }
            character.slice(slicer);
        });
    }
}
