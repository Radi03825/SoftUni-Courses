package core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		if(unitType.equals("Archer")) {
			return new Archer();
		}else if(unitType.equals("Pikeman")) {
			return new Pikeman();
		}else if (unitType.equals("Swordsman")) {
			return new Swordsman();
		}else if (unitType.equals("Gunner")) {
			return new Gunner();
		}else if (unitType.equals("Horseman")) {
			return new Horseman();
		}else {
			return null;
		}
	}
}
