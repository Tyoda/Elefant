package org.tyoda.wurm.elefant;

import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.Versioned;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.items.ModItems;
import org.tyoda.wurm.elefant.items.WoodenElephant;

import java.util.Properties;
import java.util.logging.Logger;

public class Elefant implements WurmServerMod, ItemTemplatesCreatedListener, Versioned, Configurable {
    public static Logger logger = Logger.getLogger(Elefant.class.getName());
    public static boolean craftWithPlanks = true;
    public boolean craftWithLog = true;
    public int craftHowManyPlanks = 10;
    private static Elefant instance;
    public Elefant(){
        instance = this;
    }

    @Override
    public void configure(Properties p) {
        craftWithPlanks = Boolean.parseBoolean(p.getProperty("craftWithPlanks", String.valueOf(craftWithPlanks))); // default: "false"
        craftHowManyPlanks = Integer.parseInt(p.getProperty("craftHowManyPlanks", String.valueOf(craftHowManyPlanks)));
        craftWithLog = Boolean.parseBoolean(p.getProperty("craftWithLog", String.valueOf(craftWithLog)));
    }

    @Override
    public void onItemTemplatesCreated() {
        ModItems.init();
        WoodenElephant.onItemTemplatesCreated();
    }

    public static Elefant getInstance(){
        return instance;
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
