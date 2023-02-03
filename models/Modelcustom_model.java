public static class Modelcustom_model extends EntityModel {
	private final RendererModel bone;
	private final RendererModel Ayak1_r1;
	private final RendererModel bone2;
	private final RendererModel Ayak9_r1;
	private final RendererModel bb_main;
	private final RendererModel Ghastkafas_r1;

	public Modelcustom_model() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);

		Ayak1_r1 = new RendererModel(this);
		Ayak1_r1.setRotationPoint(-14.5943F, -5.2921F, 3.0F);
		bone.addChild(Ayak1_r1);
		setRotationAngle(Ayak1_r1, 0.0F, -0.4363F, 1.5708F);
		Ayak1_r1.cubeList.add(new ModelBox(Ayak1_r1, 0, 0, -46.0F, -4.0F, -4.0F, 40, 8, 8, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(21.0F, 24.0F, 0.0F);

		Ayak9_r1 = new RendererModel(this);
		Ayak9_r1.setRotationPoint(-14.5943F, -5.2921F, 3.0F);
		bone2.addChild(Ayak9_r1);
		setRotationAngle(Ayak9_r1, 0.0F, -0.4363F, 1.5708F);
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, 0.0F, -3.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, -14.0F, 1.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, 8.0F, -15.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, -16.0F, -21.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, 26.0F, -17.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, 30.0F, 15.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, 9.0F, 10.0F, 40, 8, 8, 0.0F, false));
		Ayak9_r1.cubeList.add(new ModelBox(Ayak9_r1, 0, 0, -46.0F, -4.0F, 13.0F, 40, 8, 8, 0.0F, false));

		bb_main = new RendererModel(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		Ghastkafas_r1 = new RendererModel(this);
		Ghastkafas_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(Ghastkafas_r1);
		setRotationAngle(Ghastkafas_r1, 0.0F, 0.0F, 0.0F);
		Ghastkafas_r1.cubeList.add(new ModelBox(Ghastkafas_r1, 0, 0, -35.0F, -93.0F, -37.0F, 64, 64, 64, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}