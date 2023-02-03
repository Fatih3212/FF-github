public static class ModelBlueBossModel extends EntityModel {
	private final RendererModel bone;

	public ModelBlueBossModel() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 88, 40, 16.0F, -9.0F, -4.0F, 10, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -18.0F, -12.0F, -16.0F, 36, 8, 32, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 88, 56, -32.0F, -2.0F, 6.0F, 16, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 92, -32.0F, -2.0F, -10.0F, 16, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 76, 68, 8.0F, -4.0F, -28.0F, 5, 2, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 80, 86, 8.0F, -4.0F, 12.0F, 5, 2, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 40, -16.0F, -4.0F, -12.0F, 32, 4, 24, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 68, -14.0F, 0.0F, -10.0F, 28, 4, 20, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}