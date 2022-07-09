package com.zach2039.factorymade.data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.fluid.group.FluidGroup;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.text.FactoryMadeLang;
import com.zach2039.factorymade.world.level.block.IndustrialShaperBlock;

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
		
		addBlock(ModBlocks.IRON_NON_SLIP_WALKWAY, "Iron Non-Slip Walkway");
		addBlock(ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS, "Iron Non-Slip Walkway Stairs");
		addBlock(ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB, "Iron Non-Slip Walkway Slab");
		
		addBlock(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY, "Rusted Iron Non-Slip Walkway");
		addBlock(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS, "Rusted Iron Non-Slip Walkway Stairs");
		addBlock(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB, "Rusted Iron Non-Slip Walkway Slab");
		
		addBlock(ModBlocks.IRON_TRUSS, "Iron Truss");
		addBlock(ModBlocks.RUSTED_IRON_TRUSS, "Rusted Iron Truss");
		
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
		
		addBlock(ModBlocks.CONCRETE_SIDING, "Concrete Siding");
		addBlock(ModBlocks.CONCRETE_SIDING_STAIRS, "Concrete Siding Stairs");
		addBlock(ModBlocks.CONCRETE_SIDING_SLAB, "Concrete Siding Slab");
		
		addBlock(ModBlocks.WEATHERED_CONCRETE_SIDING, "Weathered Concrete Siding");
		addBlock(ModBlocks.WEATHERED_CONCRETE_SIDING_STAIRS, "Weathered Concrete Siding Stairs");
		addBlock(ModBlocks.WEATHERED_CONCRETE_SIDING_SLAB, "Weathered Concrete Siding Slab");
		
		addBlock(ModBlocks.BLACK_ASBESTOS_TILES, "Black Asbestos Tiles");
		addBlock(ModBlocks.BLACK_ASBESTOS_TILES_STAIRS, "Black Asbestos Tiles Stairs");
		addBlock(ModBlocks.BLACK_ASBESTOS_TILES_SLAB, "Black Asbestos Tiles Slab");
		
		addBlock(ModBlocks.WHITE_ASBESTOS_TILES, "White Asbestos Tiles");
		addBlock(ModBlocks.WHITE_ASBESTOS_TILES_STAIRS, "White Asbestos Tiles Stairs");
		addBlock(ModBlocks.WHITE_ASBESTOS_TILES_SLAB, "White Asbestos Tiles Slab");
		
		addBlock(ModBlocks.FLUORESCENT_LIGHT_PANEL, "Fluorescent Light Panel");
		addBlock(ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB, "Fluorescent Light Panel Slab");
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
	
	private <
	TYPE extends FluidType,
	STILL extends Fluid, FLOWING extends Fluid,
	BLOCK extends LiquidBlock, BUCKET extends Item,
	GROUP extends FluidGroup<TYPE, STILL, FLOWING, BLOCK, BUCKET>
	>
	void addFluidGroup(final GROUP group, final String name) {
		add(group.getType().get().getDescriptionId(), name);
		addBlock(group.getBlock(), name);
		addItem(group.getBucket(), String.format("%s Bucket", name));
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
