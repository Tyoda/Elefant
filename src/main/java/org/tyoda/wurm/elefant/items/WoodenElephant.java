package org.tyoda.wurm.elefant.items;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.elefant.Elefant;

import org.tyoda.wurm.Iconzz.Iconzz;

import java.io.IOException;
import java.util.logging.Level;

public class WoodenElephant {
    public static void onItemTemplatesCreated(){
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.tyoda.elefant.WoodenElephant");
        builder.name("wooden elephant", "wooden elephants", "A wooden elephant. It is very cute.");
        builder.material(Materials.MATERIAL_WOOD_BIRCH);
        builder.dimensions(10, 10, 50);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_DECORATION,
                ItemTypes.ITEM_TYPE_TEN_PER_TILE
        });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.tyoda.elefant.WoodenElephant", "mods/Elefant/icons/WoodenElephant.png"));
        builder.modelName("model.mod.tyoda.elefant.WoodenElephant.");
        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e){
            Elefant.logger.log(Level.SEVERE, "Failed while creating item template for Wooden Elephant.", e);
        }

        if(template != null) {
            if(Elefant.craftWithPlanks) {
                AdvancedCreationEntry elephantCreation = CreationEntryCreator.createAdvancedEntry(
                        SkillList.CARPENTRY_FINE, ItemList.plank, ItemList.plank, template.getTemplateId(), false, false, 0.0F, true, false, 0, 0.0, CreationCategories.DECORATION
                );
                elephantCreation.addRequirement(new CreationRequirement(1, ItemList.plank, Elefant.getInstance().craftHowManyPlanks, true));
            }
            if(Elefant.getInstance().craftWithLog) {
                CreationEntry elephantLogCreation = CreationEntryCreator.createSimpleEntry(
                        SkillList.CARPENTRY_FINE, ItemList.knifeCarving, ItemList.log, template.getTemplateId(), false, true, 10.0f, false, false, CreationCategories.DECORATION
                );
            }
        }
    }
}
