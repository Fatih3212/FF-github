public static class ModelGhast extends EntityModel {
	private final RendererModel body;
	private final RendererModel tentacle1;
	private final RendererModel tentacle2;
	private final RendererModel tentacle3;
	private final RendererModel tentacle4;
	private final RendererModel tentacle5;
	private final RendererModel tentacle6;
	private final RendererModel tentacle7;
	private final RendererModel tentacle8;
	private final RendererModel tentacle9;

	public ModelGhast() {
		textureWidth = 256;
		textureHeight = 256;

		body = new RendererModel(this);
		body.setRotationPoint(0.0F, 4.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, -8.0F, -8.0F, 64, 64, 64, 0.0F, false));

		tentacle1 = new RendererModel(this);
		tentacle1.setRotationPoint(-3.7F, 11.0F, -5.0F);
		tentacle1.cubeList.add(new ModelBox(tentacle1, 24, 32, -1.0F, 0.0F, -1.0F, 8, 32, 8, 0.0F, false));

		tentacle2 = new RendererModel(this);
		tentacle2.setRotationPoint(1.3F, 11.0F, -5.0F);
		tentacle2.cubeList.add(new ModelBox(tentacle2, 16, 32, 4.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F, false));

		tentacle3 = new RendererModel(this);
		tentacle3.setRotationPoint(6.3F, 11.0F, -5.0F);
		tentacle3.cubeList.add(new ModelBox(tentacle3, 0, 0, -6.0F, 0.0F, -1.0F, 2, 13, 2, 0.0F, false));

		tentacle4 = new RendererModel(this);
		tentacle4.setRotationPoint(-6.3F, 11.0F, 0.0F);
		tentacle4.cubeList.add(new ModelBox(tentacle4, 0, 32, -1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F, false));

		tentacle5 = new RendererModel(this);
		tentacle5.setRotationPoint(-1.3F, 11.0F, 0.0F);
		tentacle5.cubeList.add(new ModelBox(tentacle5, 0, 32, -1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F, false));

		tentacle6 = new RendererModel(this);
		tentacle6.setRotationPoint(3.7F, 11.0F, 0.0F);
		tentacle6.cubeList.add(new ModelBox(tentacle6, 8, 32, -1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F, false));

		tentacle7 = new RendererModel(this);
		tentacle7.setRotationPoint(-3.7F, 11.0F, 5.0F);
		tentacle7.cubeList.add(new ModelBox(tentacle7, 8, 0, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));

		tentacle8 = new RendererModel(this);
		tentacle8.setRotationPoint(1.3F, 11.0F, 5.0F);
		tentacle8.cubeList.add(new ModelBox(tentacle8, 8, 0, 4.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));

		tentacle9 = new RendererModel(this);
		tentacle9.setRotationPoint(6.3F, 11.0F, 5.0F);
		tentacle9.cubeList.add(new ModelBox(tentacle9, 0, 0, -6.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		tentacle1.render(f5);
		tentacle2.render(f5);
		tentacle3.render(f5);
		tentacle4.render(f5);
		tentacle5.render(f5);
		tentacle6.render(f5);
		tentacle7.render(f5);
		tentacle8.render(f5);
		tentacle9.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}