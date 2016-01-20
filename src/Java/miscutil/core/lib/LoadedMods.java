package miscutil.core.lib;

import miscutil.core.util.Utils;
import cpw.mods.fml.common.Loader;

public class LoadedMods {

	//Initialize Variables
	public static boolean Gregtech = false;
	public static boolean EnderIO = false;
	public static boolean Big_Reactors = false;
	public static boolean IndustrialCraft2 = false;
	public static boolean Simply_Jetpacks = false;
	public static boolean RFTools = false;
	public static boolean Thaumcraft = false;
	public static boolean Extra_Utils = false;
	public static boolean PneumaticCraft = false;
	private static int totalMods;

	public static void checkLoaded(){
		Utils.LOG_INFO("Looking for optional mod prereqs.");
		if (Loader.isModLoaded("gregtech") == true ){
			Gregtech = true;
			totalMods++;
		}
		if (Loader.isModLoaded("EnderIO") == true){
			EnderIO = true;
			totalMods++;
		}
		if (Loader.isModLoaded("BigReactors") == true){
			Big_Reactors = true;
			totalMods++;
		}
		if (Loader.isModLoaded("IC2") == true){
			IndustrialCraft2 = true;
			totalMods++;
		}
		if (Loader.isModLoaded("simplyjetpacks") == true){
			Simply_Jetpacks = true;
			totalMods++;
		}
		if (Loader.isModLoaded("rftools") == true){
			RFTools = true;
			totalMods++;
		}
		if (Loader.isModLoaded("Thaumcraft") == true){
			Thaumcraft = true;
			totalMods++;
		}
		if (Loader.isModLoaded("ExtraUtilities") == true){
			Extra_Utils = true;
			totalMods++;
		}
		if (Loader.isModLoaded("PneumaticCraft") == true){
			PneumaticCraft = true;
			totalMods++;
		}
	
		Utils.LOG_INFO("Content found for "+totalMods+" mods");
		
	}
}
