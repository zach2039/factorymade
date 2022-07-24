package com.zach2039.factorymade.data;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.text.FactoryMadeLang;
import com.zach2039.factorymade.util.ModStringUtil;
import com.zach2039.factorymade.world.level.block.IndustrialShaperBlock;
import com.zach2039.factorymade.world.level.block.variant.ComputerBlockVariant;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.FluidType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class FactoryMadeLanguageProvider extends LanguageProvider {
	private final Map<EntityType<?>, String> ENTITY_TYPE_NAMES = new HashMap<>();

	public FactoryMadeLanguageProvider(final DataGenerator gen) {
		super(gen, FactoryMade.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addEntities();
		addBlocks();
		addItems();
		addFluids();
		addPotions();
		addContainers();
		addCommands();
		addCapabilities();
		addKeyBindings();
		addConfig();
		addChatMessages();
		addSubtitles();
		addPatchouliEntries();
		addMisc();
	}

	@Override
	public String getName() {
		return "Factory Made " + super.getName();
	}

	private void addBlocks() {
		addBlock(ModBlocks.INDUSTRIAL_SHAPER, "Industrial Shaper");

		// Iron Non-Slip Walkway
		ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Non-Slip Walkway");
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Non-Slip Walkway Stairs");
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Non-Slip Walkway Slab");
		});

		// Iron Plate
		ModBlocks.IRON_PLATE_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Plate");
		});
		ModBlocks.IRON_PLATE_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Plate Stairs");
		});
		ModBlocks.IRON_PLATE_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Plate Slab");
		});

		// Iron Grating
		ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Grating");
		});
		ModBlocks.IRON_GRATING_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Grating Stairs");
		});
		ModBlocks.IRON_GRATING_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Grating Slab");
		});
		ModBlocks.IRON_GRATING_PANES.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Grating Pane");
		});

		// Iron Truss
		ModBlocks.IRON_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Iron Truss");
		});

		// Lead Non-Slip Walkway
		ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Non-Slip Walkway");
		});
		ModBlocks.LEAD_NON_SLIP_WALKWAY_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Non-Slip Walkway Stairs");
		});
		ModBlocks.LEAD_NON_SLIP_WALKWAY_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Non-Slip Walkway Slab");
		});

		// Lead Plate
		ModBlocks.LEAD_PLATE_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Plate");
		});
		ModBlocks.LEAD_PLATE_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Plate Stairs");
		});
		ModBlocks.LEAD_PLATE_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Plate Slab");
		});

		// Lead Grating
		ModBlocks.LEAD_GRATING_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Grating");
		});
		ModBlocks.LEAD_GRATING_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Grating Stairs");
		});
		ModBlocks.LEAD_GRATING_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Grating Slab");
		});
		ModBlocks.LEAD_GRATING_PANES.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Grating Pane");
		});

		// Lead Truss
		ModBlocks.LEAD_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Lead Truss");
		});
		
		addBlock(ModBlocks.WHITE_CINDER_BLOCK_BRICKS, "White Cinder Block Bricks");
		addBlock(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS, "White Cinder Block Bricks Stairs");
		addBlock(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB, "White Cinder Block Bricks Slab");
		
		addBlock(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS, "Yellow Cinder Block Bricks");
		addBlock(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_STAIRS, "Yellow Cinder Block Bricks Stairs");
		addBlock(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_SLAB, "Yellow Cinder Block Bricks Slab");
		
		addBlock(ModBlocks.RED_CINDER_BLOCK_BRICKS, "Red Cinder Block Bricks");
		addBlock(ModBlocks.RED_CINDER_BLOCK_BRICKS_STAIRS, "Red Cinder Block Bricks Stairs");
		addBlock(ModBlocks.RED_CINDER_BLOCK_BRICKS_SLAB, "Red Cinder Block Bricks Slab");
		
		addBlock(ModBlocks.BLUE_CINDER_BLOCK_BRICKS, "Blue Cinder Block Bricks");
		addBlock(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_STAIRS, "Blue Cinder Block Bricks Stairs");
		addBlock(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_SLAB, "Blue Cinder Block Bricks Slab");
		
		addBlock(ModBlocks.GREEN_CINDER_BLOCK_BRICKS, "Green Cinder Block Bricks");
		addBlock(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_STAIRS, "Green Cinder Block Bricks Stairs");
		addBlock(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_SLAB, "Green Cinder Block Bricks Slab");
		
		addBlock(ModBlocks.BROWN_CINDER_BLOCK_BRICKS, "Brown Cinder Block Bricks");
		addBlock(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_STAIRS, "Brown Cinder Block Bricks Stairs");
		addBlock(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_SLAB, "Brown Cinder Block Bricks Slab");

		// Concrete Siding
		ModBlocks.CONCRETE_SIDING_BLOCKS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Concrete Siding");
		});
		ModBlocks.CONCRETE_SIDING_STAIRS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Concrete Siding Stairs");
		});
		ModBlocks.CONCRETE_SIDING_SLABS.getBlocks().forEach(block -> {
			String variantName = block.get().getType().getSerializedName();
			String prefix = (!variantName.equals("clean")) ? ModStringUtil.capitalize(variantName + " ") : "";
			addBlock(block, prefix + "Concrete Siding Slab");
		});

		// Asbestos Tiles
		ModBlocks.ASBESTOS_TILES_BLOCKS.getBlocks().forEach(blockReg -> {
			String colorName = ModStringUtil.getColorName((DyeColor) blockReg.get().getType());
			String prefix = colorName + " ";
			addBlock(blockReg, prefix + "Asbestos Tiles");
		});
		ModBlocks.ASBESTOS_TILES_STAIRS.getBlocks().forEach(blockReg -> {
			String colorName = ModStringUtil.getColorName((DyeColor) blockReg.get().getType());
			String prefix = colorName + " ";
			addBlock(blockReg, prefix + "Asbestos Tiles Stairs");
		});
		ModBlocks.ASBESTOS_TILES_SLABS.getBlocks().forEach(blockReg -> {
			String colorName = ModStringUtil.getColorName((DyeColor) blockReg.get().getType());
			String prefix = colorName + " ";
			addBlock(blockReg, prefix + "Asbestos Tiles Slab");
		});

		// Computer
		ModBlocks.COMPUTER_BLOCKS.getBlocks().forEach(blockReg -> {
			String suffix = " " + ((ComputerBlockVariant) blockReg.get().getType()).getDisplayName();
			addBlock(blockReg, "Computer" + suffix);
		});

		addBlock(ModBlocks.FLUORESCENT_LIGHT_PANEL, "Fluorescent Light Panel");
		addBlock(ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB, "Fluorescent Light Panel Slab");

		addBlock(ModBlocks.INDUSTRIAL_WALL_LIGHT, "Industrial Wall Light");
	}

	private void addItems() {
		
	}

	private void addFluids() {

	}

	private void addEntities() {

	}

	private void addPotions() {
		
	}

	private void addContainers() {
		add(IndustrialShaperBlock.CONTAINER_TITLE.getString(), "Industrial Shaper");
	}

	private void addCommands() {
		
	}

	private void addCapabilities() {
		
	}

	private void addChatMessages() {

	}

	private void addKeyBindings() {

	}

	private void addConfig() {

	}

	private void addSubtitles() {

	}
	
	private void addPatchouliEntries() {
		
	}

	private void addMisc() {
		add("itemGroup." + FactoryMade.MODID, "Factory Made");
	}

	@Override
	public void addEntityType(final Supplier<? extends EntityType<?>> key, final String name) {
		super.addEntityType(key, name);
		ENTITY_TYPE_NAMES.put(key.get(), name);
	}

	private String getPotionItemTranslationKey(final Supplier<? extends Potion> potion, final Item item) {
		final ItemStack stack = PotionUtils.setPotion(new ItemStack(item), potion.get());
		return stack.getItem().getDescriptionId(stack);
	}

	private void add(final FactoryMadeLang lang, final String value) {
		add(lang.getTranslationKey(), value);
	}
	
	private void addPatchouliBookPage(final String key, final String value) {		
		add("oldguns.page." + key, value);
	}
	
	private void addPatchouliBookLang(final String key, final String value) {		
		add("oldguns.lang." + key, value);
	}
	
	private void addPatchouliBookEntry(final String key, final String value) {
		add("oldguns.entry." + key, value);
	}
	
	private void addPatchouliBookCategory(final String key, final String value) {
		add("oldguns.category." + key, value);
	}
	
	private void addPatchouliBookCategoryDescription(final String key, final String value) {
		add("oldguns.description." + key, value);
	}

	private void addPatchouliBookLanding(final String value) {
		add("oldguns.landing", value);
	}
	
	private void add(final FactoryMadeLang prefix, final StringRepresentable enumValue, final String name) {
		add(prefix.getTranslationKey() + "." + enumValue.getSerializedName(), name);
	}
	
	private String translate(final DyeColor colour) {
		return translate("color.minecraft." + colour.getName());
	}

	private String translate(final String key) {
		return I18n.get(key);
	}
}
