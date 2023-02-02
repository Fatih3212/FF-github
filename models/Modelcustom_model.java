public static class Modelcustom_model extends EntityModel {
	private final RendererModel bb_main;
	private final RendererModel Ayak6_r1;
	private final RendererModel Ghastkafas_r1;

	public Modelcustom_model() {
		textureWidth = 256;
		textureHeight = 256;

		bb_main = new RendererModel(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		Ayak6_r1 = new RendererModel(this);
		Ayak6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(Ayak6_r1);
		setRotationAngle(Ayak6_r1, 0.0F, 0.2618F, 1.5708F);
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -31.0F, -20.0F, -35.0F, 32, 8, 8, 0.0F, false));
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -31.0F, 14.0F, -38.0F, 32, 8, 8, 0.0F, false));
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -31.0F, -15.0F, -25.0F, 32, 8, 8, 0.0F, false));
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -31.0F, -1.0F, -13.0F, 32, 8, 8, 0.0F, false));
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -31.0F, 15.0F, 2.0F, 32, 8, 8, 0.0F, false));
		Ayak6_r1.cubeList.add(new ModelBox(Ayak6_r1, 0, 0, -33.0F, -16.0F, 9.0F, 32, 8, 8, 0.0F, false));

		Ghastkafas_r1 = new RendererModel(this);
		Ghastkafas_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(Ghastkafas_r1);
		setRotationAngle(Ghastkafas_r1, 0.0F, 0.0F, 0.0F);
		Ghastkafas_r1.cubeList.add(new ModelBox(Ghastkafas_r1, 0, 0, -35.0F, -82.0F, -37.0F, 64, 64, 64, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}