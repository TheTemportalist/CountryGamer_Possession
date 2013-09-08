package mods.CountryGamer_Possession.Possession;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class creativeTabPion extends CreativeTabs {

    public creativeTabPion(int tabID, String tabLabel) {
        super(tabID, tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {
        return Item.expBottle.itemID; //TODO remember to chnage this when we add any item to the mod
    }
    
    public String getTranslatedTabLabel(){
     return "Possession";
    }

}
