
package net.mcreator.testone.world.structure;

@TestoneElements.ModElement.Tag
public class PiramitStructure extends TestoneElements.ModElement {

	public PiramitStructure(TestoneElements instance) {
		super(instance, 43);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::deserialize) {
			@Override
			public boolean place(IWorld iworld, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				int ci = pos.getX();
				int ck = pos.getZ();

				DimensionType dimensionType = iworld.getDimension().getType();
				boolean dimensionCriteria = false;

				if (dimensionType == DimensionType.OVERWORLD)
					dimensionCriteria = true;
				if (dimensionType == TheBetweenWorldDimension.type)
					dimensionCriteria = true;

				if (!dimensionCriteria)
					return false;

				if ((random.nextInt(1000000) + 1) <= 10000) {
					int count = random.nextInt(1) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16) + 8;
						int k = ck + random.nextInt(16) + 8;
						int j = iworld.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);

						j -= 1;

						Template template = ((ServerWorld) iworld.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("testone", "piramit"));
						if (template == null)
							return false;

						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];

						BlockPos spawnTo = new BlockPos(i, j + 0, k);
						template.addBlocksToWorldChunk(iworld, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random)
								.setMirror(mirror).setChunk((ChunkPos) null).setIgnoreEntities(false));

					}
				}

				return true;
			}
		};

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("testone:portalbiome")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
					Biome.createDecoratedFeature(feature, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
		}
	}

}
