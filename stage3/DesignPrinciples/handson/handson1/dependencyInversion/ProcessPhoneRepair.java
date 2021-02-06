package dependencyInversion;

public class ProcessPhoneRepair {

	public void repairSteps(IPhone phone) {
		String part1=phone.GetPhonePart1();
		System.out.println(part1+" repaired ");
		double partCost=phone.GetPart1Cost();
		System.out.println("Repair cost "+partCost*0.5);
	}
}
