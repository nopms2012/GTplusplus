package miscutil.gregtech.init.machines;

import static miscutil.core.lib.LoadedMods.Gregtech;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import miscutil.core.util.Utils;
import miscutil.gregtech.metatileentity.implementations.GregtechMetaPipeEntity_Cable;

public class GregtechConduits {
	/**
	 * 
	 * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
	 * public static final long[] V = new long[] {0=8, 1=32, 2=128, 3=512, 4=2048, 5=8192, 6=32768, 7=131072, 8=524288, 9=Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
	 * 
	 */
	
	
	public static void run()
	{
		if (Gregtech){
			Utils.LOG_INFO("MiscUtils: Gregtech5u Content | Registering Custom Cables/Wire.");
			run1();
		}
		
	}
	
	private static void run1(){
		wireFactory("Blutonium", 8196, 30600, 1, 8, 2);
		wireFactory("Helium", 8, 30615, 3,6,9);
		wireFactory("HSLA", 128, 30630, 4, 8, 1);
	}	
	
	private static void wireFactory(String Material, int Voltage, int ID, long insulatedLoss, long uninsulatedLoss, long Amps){
		Materials T = Materials.valueOf(Material);
		int V = 0;
		if (Voltage == 8){
			V = 0;
		}
		else if (Voltage == 32){
			V = 1;
		}
		else if (Voltage == 128){
			V = 2;
		}
		else if (Voltage == 512){
			V = 3;
		}
		else if (Voltage == 2048){
			V = 4;
		}
		else if (Voltage == 8196){
			V = 5;
		}
		else if (Voltage == 32768){
			V = 6;
		}
		else if (Voltage == 131072){
			V = 7;
		}
		else if (Voltage == 524288){
			V = 8;
		}
		else if (Voltage == Integer.MAX_VALUE){
			V = 9;
		}
		else {
			Utils.LOG_ERROR("Failed to set voltage on "+Material+". Invalid voltage of "+Voltage+"V set.");
			Utils.LOG_ERROR(Material+" has defaulted to 8v.");
			V = 0;
		}
		//makeWires(T, ID, 2L, 4L, 2L, GT_Values.V[V], true, false);	 
		makeWires(T, ID, insulatedLoss, uninsulatedLoss, Amps, GT_Values.V[V], true, false);	 
		//makeWires(T, ID, bEC ? 2L : 2L, bEC ? 4L : 4L, 2L, gregtech.api.enums.GT_Values.V[V], true, false);	 
	}	

	private static void makeWires(Materials aMaterial, int aStartID, long aLossInsulated, long aLoss, long aAmperage, long aVoltage, boolean aInsulatable, boolean aAutoInsulated)
	{
		Utils.LOG_WARNING("MiscUtils: Gregtech5u Content | Registered "+aMaterial.name() +" as a new material for Wire & Cable.");
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt01, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 0, "wire." + aMaterial.name().toLowerCase() + ".01", "1x " + aMaterial.mDefaultLocalName + " Wire", 0.125F, aMaterial, aLoss, 1L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt02, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 1, "wire." + aMaterial.name().toLowerCase() + ".02", "2x " + aMaterial.mDefaultLocalName + " Wire", 0.25F, aMaterial, aLoss, 2L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt04, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 2, "wire." + aMaterial.name().toLowerCase() + ".04", "4x " + aMaterial.mDefaultLocalName + " Wire", 0.375F, aMaterial, aLoss, 4L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt08, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 3, "wire." + aMaterial.name().toLowerCase() + ".08", "8x " + aMaterial.mDefaultLocalName + " Wire", 0.5F, aMaterial, aLoss, 8L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt12, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 4, "wire." + aMaterial.name().toLowerCase() + ".12", "12x " + aMaterial.mDefaultLocalName + " Wire", 0.75F, aMaterial, aLoss, 12L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.wireGt16, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 5, "wire." + aMaterial.name().toLowerCase() + ".16", "16x " + aMaterial.mDefaultLocalName + " Wire", 1.0F, aMaterial, aLoss, 16L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
		if (aInsulatable)
		{
			GT_OreDictUnificator.registerOre(OrePrefixes.cableGt01, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 6, "cable." + aMaterial.name().toLowerCase() + ".01", "1x " + aMaterial.mDefaultLocalName + " Cable", 0.25F, aMaterial, aLossInsulated, 1L * aAmperage, aVoltage, true, false).getStackForm(1L));
			GT_OreDictUnificator.registerOre(OrePrefixes.cableGt02, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 7, "cable." + aMaterial.name().toLowerCase() + ".02", "2x " + aMaterial.mDefaultLocalName + " Cable", 0.375F, aMaterial, aLossInsulated, 2L * aAmperage, aVoltage, true, false).getStackForm(1L));
			GT_OreDictUnificator.registerOre(OrePrefixes.cableGt04, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 8, "cable." + aMaterial.name().toLowerCase() + ".04", "4x " + aMaterial.mDefaultLocalName + " Cable", 0.5F, aMaterial, aLossInsulated, 4L * aAmperage, aVoltage, true, false).getStackForm(1L));
			GT_OreDictUnificator.registerOre(OrePrefixes.cableGt08, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 9, "cable." + aMaterial.name().toLowerCase() + ".08", "8x " + aMaterial.mDefaultLocalName + " Cable", 0.75F, aMaterial, aLossInsulated, 8L * aAmperage, aVoltage, true, false).getStackForm(1L));
			GT_OreDictUnificator.registerOre(OrePrefixes.cableGt12, aMaterial, new GregtechMetaPipeEntity_Cable(aStartID + 10, "cable." + aMaterial.name().toLowerCase() + ".12", "12x " + aMaterial.mDefaultLocalName + " Cable", 1.0F, aMaterial, aLossInsulated, 12L * aAmperage, aVoltage, true, false).getStackForm(1L));
		}
	}
}