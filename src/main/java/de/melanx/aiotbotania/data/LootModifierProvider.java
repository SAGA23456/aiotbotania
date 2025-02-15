package de.melanx.aiotbotania.data;

import de.melanx.aiotbotania.AIOTBotania;
import de.melanx.aiotbotania.handler.lootmodifier.DisposeModifier;
import de.melanx.aiotbotania.handler.lootmodifier.GrassModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(DataGenerator generator) {
        super(generator, AIOTBotania.MODID);
    }

    @Override
    protected void start() {
        this.add("dispose", new DisposeModifier(new LootItemCondition[]{}));
        this.add("grass", new GrassModifier(new LootItemCondition[]{}));
    }
}
