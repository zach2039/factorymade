package com.zach2039.factorymade.data;

import com.google.common.base.Preconditions;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.RegistryUtil;
import com.zach2039.factorymade.world.level.block.variant.SimpleMetalBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleNonCorrosiveMetalBlockVariant;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class FactoryMadeItemModelProvider extends ItemModelProvider {
	private static final String LAYER_0 = "layer0";
	
	private final Supplier<ModelFile> simpleModel = Lazy.of(() ->
			withGeneratedParent("simple_model")
					.transforms()

					.transform(TransformType.THIRD_PERSON_RIGHT_HAND)
					.rotation(-80, 260, -40)
					.translation(-1, -2, 2.5f)
					.scale(0.9f, 0.9f, 0.9f)
					.end()

					.transform(TransformType.THIRD_PERSON_LEFT_HAND)
					.rotation(-80, -280, 40)
					.translation(-1, -2, 2.5f)
					.scale(0.9f, 0.9f, 0.9f)
					.end()

					.transform(TransformType.FIRST_PERSON_RIGHT_HAND)
					.rotation(0, -90, 25)
					.translation(1.13f, 3.2f, 1.13f)
					.scale(0.68f, 0.68f, 0.68f)
					.end()

					.transform(TransformType.FIRST_PERSON_LEFT_HAND)
					.rotation(0, 90, -25)
					.translation(1.13f, 3.2f, 1.13f)
					.scale(0.68f, 0.68f, 0.68f)
					.end()

					.end()
	);
	
	public FactoryMadeItemModelProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
		super(generator, FactoryMade.MODID, existingFileHelper);
	}
	
	/**
	 * Gets a name for this provider, to use in logging.
	 */
	@Override
	public String getName() {
		return "OldGunsItemModels";
	}
	
	@Override
	protected void registerModels() {
		// Iron Grating Panes
		{
			ModBlocks.IRON_GRATING_PANES
					.getBlocks()
					.forEach(block -> {
						withGeneratedParent(
								block.get().asItem(),
								modLoc("block/" + RegistryUtil.getKey(
										ModBlocks.IRON_GRATING_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
										).getPath())
						);
					});
		}

		// Lead Grating Panes
		{
			ModBlocks.LEAD_GRATING_PANES
					.getBlocks()
					.forEach(block -> {
						withGeneratedParent(
								block.get().asItem(),
								modLoc("block/" + RegistryUtil.getKey(
										ModBlocks.LEAD_GRATING_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
								).getPath())
						);
					});
		}
	}


	private ResourceLocation registryName(final Item item) {
		return Preconditions.checkNotNull(RegistryUtil.getKey(item), "Item %s has a null registry name", item);
	}

	private String name(final Item item) {
		return registryName(item).getPath();
	}

	private ResourceLocation itemTexture(final Item item) {
		final ResourceLocation name = registryName(item);
		return new ResourceLocation(name.getNamespace(), ITEM_FOLDER + "/" + name.getPath());
	}

	private ItemModelBuilder withExistingParent(final Item item, final Item modelItem) {
		return withExistingParent(name(item), registryName(modelItem));
	}

	private ItemModelBuilder withGeneratedParentAndDefaultTexture(final Item item) {
		return withGeneratedParent(name(item))
				.texture(LAYER_0, itemTexture(item));
	}

	private ItemModelBuilder withGeneratedParent(final Item item, final ResourceLocation texture) {
		return withGeneratedParent(name(item))
				.texture(LAYER_0, texture);
	}
	
	private ItemModelBuilder withGeneratedParent(final String name) {
		return withExistingParent(name, mcLoc("generated"));
	}

	private ItemModelBuilder withSimpleParentAndDefaultTexture(final Item item) {
		return withSimpleParent(item, itemTexture(item));
	}

	private ItemModelBuilder withSimpleParent(final Item item, final ResourceLocation texture) {
		return withSimpleParent(item, texture.toString());
	}

	private ItemModelBuilder withSimpleParent(final Item item, final String texture) {
		return withSimpleParent(name(item))
				.texture(LAYER_0, texture);
	}

	private ItemModelBuilder withSimpleParent(final String name) {
		return getBuilder(name)
				.parent(simpleModel.get());
	}

	private void spawnEggItem(final Item item) {
		withExistingParent(name(item), mcLoc("template_spawn_egg"));
	}

}
