package fluff.gradle;

public abstract class AbstractManager extends FluffBase {
	
	protected abstract void onInit();
	
	@Override
	protected void init(FluffGradle fluff) {
		super.init(fluff);
		
		onInit();
	}
}
