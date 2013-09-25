package CountryGamer_Possession.Possession.Util;
/**
 * EnumAbility Class
 * defines possible entity abilities for reference
 * @author Country_Gamer
 *
 */
public enum EnumAbility {
	
	TELEPORT(EnumAbilityType.TRAVEL),
	SPRINT(EnumAbilityType.TRAVEL),
	CLIMB(EnumAbilityType.TRAVEL),
	FLY(EnumAbilityType.TRAVEL),
	
	PUNCH(EnumAbilityType.DAMAGE),
	SHOOT(EnumAbilityType.DAMAGE),
	
	THROW(EnumAbilityType.SPECIAL),
	CONVERT(EnumAbilityType.SPECIAL),
	MULTIPLY(EnumAbilityType.SPECIAL),
	PICKUP(EnumAbilityType.SPECIAL),
	SUMMON(EnumAbilityType.SPECIAL),
	CREATE(EnumAbilityType.SPECIAL);
	
	private enum EnumAbilityType {
		TRAVEL, DAMAGE, SPECIAL;
	}
	private final EnumAbilityType abilityType;
	
	private EnumAbility(EnumAbility.EnumAbilityType type) {
		this.abilityType = type;
		
	}
	
	public EnumAbilityType getAbilityType() { return this.abilityType; }
	
}
