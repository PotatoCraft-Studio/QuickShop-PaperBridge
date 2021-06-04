package org.maxgamer.quickshop.paperbridge;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.block.Chest;
import org.jetbrains.annotations.Nullable;
import org.maxgamer.quickshop.shop.ShopInfoStorage;
import org.maxgamer.quickshop.util.JsonUtil;

public class PaperBridge {
    public boolean isPaper() {
        return Util.isClassAvailable("com.destroystokyo.paper.PaperConfig");
    }

    public boolean isAdventureSupported() {
        return Util.isClassAvailable("io.papermc.paper.adventure.AdventureComponent");
    }

    public void setChestTitle(Chest chest,String show, ShopInfoStorage storage){
        chest.customName(Component.text(show).hoverEvent(HoverEvent.showText(Component.text(JsonUtil.getGson().toJson(storage)))).asComponent());
    }
    @Nullable
    public ShopInfoStorage readChestTitle(Chest chest){
        Component component =  chest.customName();
        if(component == null){
            return null;
        }
        net.kyori.adventure.text.event.HoverEvent<?> hoverEvent = component.hoverEvent();
        if(hoverEvent != null){
            Component hoverText = (Component) hoverEvent.value();
            org.maxgamer.quickshop.util.Util.debugLog("HoverText: "+hoverText);
            return JsonUtil.getGson().fromJson(hoverText.toString(),ShopInfoStorage.class);
        }
        return null;
    }
}
