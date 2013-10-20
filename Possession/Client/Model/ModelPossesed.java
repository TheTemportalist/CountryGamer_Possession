package CountryGamer_Possession.Possession.Client.Model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import CountryGamer_Possession.Possession.Entity.EntityPossesed;

/**
 * The Model for the player when they are possessing
 * @author Altra
 */
public class ModelPossesed extends ModelBase {

        public ModelInfo modelInfo;
        
        public EntityPossesed entityPossesed;

        public ArrayList<ModelRenderer> modelList;
        
        public ModelPossesed(){}

        public ModelPossesed(EntityPossesed entity){
                this.entityPossesed = entity;
        }

        @Override
        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
                modelInfo.baseModel.render(entity, f, f1, f2, f3, f4, f5);
        }

        @Override
    public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
        }
}