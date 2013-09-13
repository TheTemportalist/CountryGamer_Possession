package CountryGamer_Possession.Possession.Client.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;

/**
 * Stores information about a model
 * so it can be stored in ModelList
 * @author Altra
 * @credit iChun
 */
public class ModelInfo {
	public final Class entityClass;
	public final RendererLivingEntity entityRender;
	public final ModelBase baseModel;
	//public final ArrayList<ModelRenderer> modelList;

	public ModelInfo(Class entityClass, RendererLivingEntity render, ModelBase modelInstance){
		this.entityClass = entityClass;
		this.entityRender = render;
		this.baseModel = modelInstance;
		//modelList = ModelHelper.getModelCubes(modelInstance);
	}
}